package com.yunxie.repositories;

import com.yunxie.models.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;

/**
 * Created by WXH on 2017/11/22.
 */
@Mapper
public interface TestXMLRepository {

    Test selectByPrimaryKey(@Param("id") Integer id);

}
