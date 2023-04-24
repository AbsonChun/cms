package com.dusk.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dusk.article.domain.Article;
import com.dusk.article.enums.ArticleEnum;
import com.dusk.article.mapper.ArticleMapper;
import com.dusk.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    public Article getArticleById(Integer id,Integer type,Integer user_id){
        return articleMapper.getArticleById(id,type,user_id);
    }

    /**
     *
     * @param status 状态
     * @param pageNum 页数 从0 开始
     * @param pageCount 每页条数
     * @return
     */
    public List<Article> getArticleListByStatusAndPageNum(String status, Integer pageNum, Integer pageCount){
        if(status == null ){
            status = ArticleEnum.ArticleStatus.ARTICLE_STATUS_NORMAL.getCode();  //标记为正常
        }
        if(pageNum == null ){
            pageNum = 0;
        }
        if(pageCount == null ){
            pageCount = 20;
        }
        return articleMapper.getArticleListByStatusAndPageNum(status,pageNum,pageCount);
    }

    //当有事务的时候 使用@Transactional+Cacheable(value = "article",key = "#article.id")
    //@Transactional
    //@Cacheable(value = "article",key = "#article.id")
    @CachePut(value = "article",key = "#article.id")
    public Integer saveArticleEdit(Article article){
        return articleMapper.saveArticleEdit(article);
    }

}




