package com.qinyuan15.org.mystock.crawler;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.qinyuan.lib.network.http.HttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Query current price from qt.gtimeg.cn
 * Created by qinyuan on 15-10-15.
 */
public class QQCurrentPriceCrawler implements CurrentPriceCrawler {
    private final static String site = "http://qt.gtimg.cn";
    private final static Logger LOGGER = LoggerFactory.getLogger(QQCurrentPriceCrawler.class);

    @Override
    public List<Price> get(List<String> queryNames) {
        if (queryNames == null || queryNames.size() == 0) {
            LOGGER.error("queryNames is empty: {}", queryNames);
            return new ArrayList<>();
        }

        String url = buildUrl(queryNames);
        String content = new HttpClient().getContent(url);
        String[] lines = content.trim().split("\n");
        List<Price> prices = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            Price price = buildPriceByLine(lines[i]);
            if (price != null) {
                price.getStock().setQueryName(queryNames.get(i));
                prices.add(price);
            }
        }
        return prices;
    }

    @Override
    public Price get(String queryName) {
        List<Price> prices = get(Lists.newArrayList(queryName));
        return prices.size() == 0 ? null : prices.get(0);
    }

    private String buildUrl(List<String> queryNames) {
        return site + "/q=" + Joiner.on(",").join(queryNames);
    }

    private Price buildPriceByLine(String line) {
        if (StringUtils.isBlank(line)) {
            return null;
        }
        line = line.replaceAll("^[^\"]*\"", "").replaceAll("~*\";$", "");

        String[] elements = line.split("~+");
        if (elements.length < 6) {
            return null;
        }

        Stock stock = new Stock();
        stock.setName(elements[1]);
        stock.setCode(elements[2]);

        Price price = new Price();
        price.setStock(stock);
        price.setPrice(Double.parseDouble(elements[3]));
        price.setRate(Double.parseDouble(elements[5]));

        return price;
    }
}
