package com.qinyuan15.org.mystock.crawler;

import java.util.List;

public interface CurrentPriceCrawler {
    public List<Price> get(List<String> queryNames);

    public Price get(String queryName);
}
