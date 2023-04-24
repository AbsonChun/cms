package com.dusk.article.controller;

import com.dusk.article.domain.Article;
import com.dusk.article.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/articleController")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/getArticleById.do")
    public String getArticleById(HttpServletRequest request,ModelMap modelMap, Integer id,Integer type){
        if (id != null ){
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            Article article = articleService.getArticleById(id,type,user.getId());
            modelMap.put("article",article);
            return "/article/articleDetail";
        }
        return "/error";
    }

    @RequestMapping(value = "/articleEdit.do")
    public String articleEdit(){

        return "/article/articleEdit";
    }

    @RequestMapping(value = "/saveArticleEdit.do")
    @ResponseBody
    public Map<String,String> saveArticleEdit(Article article){
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        Map<String,String> returnMap = new HashMap<>();
        article.setStatus(1);
        article.setClick(0);
        article.setCreateUser(user.getId());
        Integer id = articleService.saveArticleEdit(article);
        if(id==null){
            returnMap.put("code","300");
            returnMap.put("message","保存失败！");
        }else{
            returnMap.put("code","200");
            returnMap.put("message","保存成功！");
        }
        return returnMap;
    }
}
