package com.qinyuan15.org.mystock.controller;

import com.qinyuan.lib.mvc.controller.BaseController;
import com.qinyuan15.org.mystock.AppConfig;
import com.qinyuan15.org.mystock.crawler.QQCurrentPriceCrawler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {

    @RequestMapping("/index")
    public String index() {
        setTitle("stock");

        setAttribute("prices", new QQCurrentPriceCrawler().get(AppConfig.getQueryNames()));

        addCssAndJs("index");
        return "index";
    }

    /*
    @RequestMapping("/hello-world.json")
    @ResponseBody
    public String json(){
        return success();
    }
    */
}
