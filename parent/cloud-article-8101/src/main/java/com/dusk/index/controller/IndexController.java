package com.dusk.index.controller;

import com.dusk.article.domain.Article;
import com.dusk.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/indexController")
public class IndexController {

    @Value("${com.dusk.name}")
    private String name;

    @Autowired
    private MenuService menuService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value="/index.do")
    public String index(ModelMap map){
        map.put("name",name);
        //获取一级菜单标题
        List<Menu> menuList = menuService.getMenuListByLevelAndStatus(MenuEnum.MenuLevel.MENU_LEVEL_ONE.getCode(),MenuEnum.MenuStatus.MENU_STATUS_NORMAL.getCode());
        map.put("menuList",menuList);
        //获取主页显示的推荐贴
        List<Article> articleList = articleService.getArticleListByStatusAndPageNum(null,null,null);
        map.put("articleList",articleList);
        return "/index";
    }

}
