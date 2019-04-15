package com.tensquare.base.Service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * ClassName: LabelService
 * Author:   Light
 * Date:     2019/4/15 14:08
 * Description:
 */

@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;
    int i;
    //查询全部
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    //通过id来查询
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }
    //增加
    public void add(Label label) {
        // i=i/0;
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void delete(String id) {

        labelDao.deleteById(id);
    }

}