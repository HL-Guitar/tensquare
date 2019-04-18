package com.tensquare.base.controller;

import com.tensquare.base.Service.LabelService;
import com.tensquare.base.pojo.Label;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import util.IdWorker;

import java.util.List;
import java.util.Map;

/**
 * ClassName: BaseController
 * @Author:   Light
 * @Date:     2019/4/15 13:50
 * Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;
    @Autowired
    private IdWorker idWorker;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Label> all = labelService.findAll();
        return new Result(true,StatusCode.OK,"查询成功",all);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        Label label=labelService.findById(id);
        return new Result(true,StatusCode.OK,"查询对象成功",label);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label){
        label.setId(idWorker.nextId()+"");
        labelService.add(label);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Label label,@PathVariable String id){
        label.setId(id);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        labelService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 条件查询
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap){
        List<Label> labelList = labelService.findSearch(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",labelList);
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap,@PathVariable int page,@PathVariable int size){
        Page<Label> pageList = labelService.findSearch(searchMap,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(pageList.getTotalElements(),pageList.getContent()));
    }

}