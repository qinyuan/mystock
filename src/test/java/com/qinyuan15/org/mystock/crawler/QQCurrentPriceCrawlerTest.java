package com.qinyuan15.org.mystock.crawler;

import com.google.common.collect.Lists;
import junit.framework.TestCase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QQCurrentPriceCrawlerTest extends TestCase {
    private QQCurrentPriceCrawler crawler = new QQCurrentPriceCrawler();

    public void testGet() throws Exception {
        Price price = crawler.get("s_sh000001");
        assertThat(price.getStock().getQueryName()).isEqualTo("s_sh000001");
        assertThat(price.getStock().getCode()).isEqualTo("000001");
        assertThat(price.getStock().getName()).isEqualTo("上证指数");
        assertThat(price.getPrice()).isEqualTo(3338.07);
        assertThat(price.getRate()).isEqualTo(2.32);
    }

    public void testGet1() throws Exception {
        //List<String> queryNames = Lists.newArrayList("sh000001");
        List<String> queryNames = Lists.newArrayList("s_sh000001", "s_sz000651");

        List<Price> prices = crawler.get(queryNames);
        assertThat(prices.get(0).getStock().getQueryName()).isEqualTo("s_sh000001");
        assertThat(prices.get(0).getStock().getCode()).isEqualTo("000001");
        assertThat(prices.get(0).getStock().getName()).isEqualTo("上证指数");
        assertThat(prices.get(0).getPrice()).isEqualTo(3338.07);
        assertThat(prices.get(0).getRate()).isEqualTo(2.32);

        assertThat(prices.get(1).getStock().getQueryName()).isEqualTo("s_sz000651");
        assertThat(prices.get(1).getStock().getCode()).isEqualTo("000651");
        assertThat(prices.get(1).getStock().getName()).isEqualTo("格力电器");
        assertThat(prices.get(1).getPrice()).isEqualTo(17.45);
        assertThat(prices.get(1).getRate()).isEqualTo(2.11);
    }
}
