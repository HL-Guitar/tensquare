package com.tenaquare.search.controller;

import com.tenaquare.search.pojo.Article;
import com.tenaquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ArticleSearchController
 *
 * @Author: Light
 * @Date: 2019/4/23 17:07
 * Description:
 */

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;


    //文章搜索
    @RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size){
        Page<Article> articlePage = articleSearchService.findByKey(keywords, page, size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<>(articlePage.getTotalElements(),articlePage.getContent()));
    }


    //添加文章
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article){
        articleSearchService.add(article);
        return new Result(true,StatusCode.OK,"操作成功");
    }
}