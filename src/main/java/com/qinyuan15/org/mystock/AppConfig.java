package com.qinyuan15.org.mystock;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.qinyuan.lib.config.AppConfigDao;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {
    private final static AppConfigDao dao = new AppConfigDao();
    private final static String QUERY_NAMES_KEY = "queryNames";
    private final static String QUERY_NAMES_SEPARATOR = ",";

    public static List<String> getQueryNames() {
        String queryNames = dao.get(QUERY_NAMES_KEY);
        if (StringUtils.isBlank(queryNames)) {
            return new ArrayList<>();
        } else {
            return Lists.newArrayList(queryNames.split(QUERY_NAMES_SEPARATOR));
        }
    }

    public static void setQueryNames(List<String> queryNames) {
        dao.save(QUERY_NAMES_KEY, Joiner.on(QUERY_NAMES_SEPARATOR).join(queryNames));
    }
}
