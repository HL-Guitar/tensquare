package com.tenaquare.search.dao;

import com.tenaquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ClassName: ArticleSearchDao
 *
 * @Author: Light
 * @Date: 2019/4/23 17:02
 * Description:
 */

public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    /**
     * 文章搜索. 模糊查询
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}