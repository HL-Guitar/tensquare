package com.tenaquare.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * ClassName: Article
 *
 * @Author: Light
 * @Date: 2019/4/23 16:41
 * Description:
 * 是否索引，看该域是否能被搜索     index= true
 * 是否分词，表示搜索的时候是整体匹配还是单词匹配    analyzer="ik_max_word"（存储时）    searchAnalyzers(搜索时)
 * 是否存储，就是是否在界面上显示   store = true
 */
@Document(indexName = "tensquare_article",type = "article")
public class Article implements Serializable {
    @Id
    private String id;//ID

    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;//标题

    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;//文章正文

    private String state;//审核状态


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}