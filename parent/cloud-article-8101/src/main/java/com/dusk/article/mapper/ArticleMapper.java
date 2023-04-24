package com.dusk.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dusk.article.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity generator..Article
 */
public interface ArticleMapper extends BaseMapper<Article> {

    Article getArticleById(@Param("id") Integer id, @Param("type") Integer type, @Param("user_id") Integer user_id);

    /**
     * @param status 状态
     * @param pageNum 页数 从0 开始
     * @param pageCount 每页条数
     * @return
     */
    List<Article> getArticleListByStatusAndPageNum(@Param("status") Integer status, @Param("pageNum") Integer pageNum, @Param("pageCount") Integer pageCount);

    /**
     * 保存文章，返回新保存的文章
     * @param article
     * @return
     */
    Integer saveArticleEdit(Article article);
}




