package com.dusk.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dusk.article.domain.Article;
import org.springframework.cache.annotation.CachePut;

import java.util.List;

/**
 *
 */
public interface ArticleService extends IService<Article> {

    Article getArticleById(Integer id,Integer type,Integer user_id);

    /**
     *
     * @param status 状态
     * @param pageNum 页数 从0 开始
     * @param pageCount 每页条数
     * @return
     */
    List<Article> getArticleListByStatusAndPageNum(String status, Integer pageNum, Integer pageCount);

    //当有事务的时候 使用@Transactional+Cacheable(value = "article",key = "#article.id")
    //@Transactional
    //@Cacheable(value = "article",key = "#article.id")
    @CachePut(value = "article",key = "#article.id")
    Integer saveArticleEdit(Article article);
}
