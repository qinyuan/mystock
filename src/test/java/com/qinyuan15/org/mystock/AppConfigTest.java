package com.qinyuan15.org.mystock;

import com.google.common.collect.Lists;
import com.qinyuan.lib.database.test.DatabaseTestCase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppConfigTest extends DatabaseTestCase {

    @Test
    public void testGetQueryNames() throws Exception {
        AppConfig.setQueryNames(Lists.newArrayList("aa", "bb"));
        assertThat(AppConfig.getQueryNames()).containsExactly("aa", "bb");
    }
}
