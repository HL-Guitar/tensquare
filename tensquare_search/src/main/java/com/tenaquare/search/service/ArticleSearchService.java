package com.tenaquare.search.service;

import com.tenaquare.search.dao.ArticleSearchDao;
import com.tenaquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * ClassName: ArticleSearchService
 *
 * @Author: Light
 * @Date: 2019/4/23 17:03
 * Description:
 */
@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;

    /*@Autowired
    private IdWorker idWorker;*/
    //文章搜索
    public Page<Article> findByKey(String keywords, int page, int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords,pageRequest);
    }

    //增加文章
    public void add(Article article){
        //rticle.setId(idWorker.nextId()+"");
        articleSearchDao.save(article);
    }
}