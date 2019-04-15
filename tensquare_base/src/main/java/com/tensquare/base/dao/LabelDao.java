package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * ClassName: LabelDao
 * Author:   Light
 * Date:     2019/4/15 14:05
 * Description:
 */

public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label > {

}