package com.tensquare.base.Service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Label> findSearch(Map searchMap) {
        Specification<Label> specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     * 构建查询条件
     */
    private Specification<Label> createSpecification(Map searchMap){
        Specification<Label> specification = new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //用于封装查询条件的集合
                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("labelname")!=null && !"".equals(searchMap.get("labelname"))) {
                    //添加条件到Predicate集合,模糊查询使用cb.like
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class),"%"+(String)searchMap.get("labelname")+"%"));
                }
                if (searchMap.get("state")!=null && !"".equals(searchMap.get("state"))) {
                    //状态查询cb.equal
                    predicateList.add(criteriaBuilder.equal(root.get("state").as(String.class),(String)searchMap.get("state")));
                }
                if (searchMap.get("recommend")!=null && !"".equals(searchMap.get("recommend"))) {
                    //是否推荐,cb.equal
                    predicateList.add(criteriaBuilder.equal(root.get("recommend").as(String.class),(String)searchMap.get("recommend")));
                }
                //将条件集合转成数组,转成参数中的数组对象
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return specification;
    }
    /**
     * 条件+分页
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<Label> findSearch(Map searchMap, int page, int size) {
        Specification<Label> specification = createSpecification(searchMap);
        //执行分页,0表示第一页
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification,pageRequest);
    }

}