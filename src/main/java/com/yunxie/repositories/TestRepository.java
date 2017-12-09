package com.yunxie.repositories;

import com.yunxie.models.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by WXH on 2017/11/20.
 */
@Mapper
public interface TestRepository {

    @Select("select * from test where id = #{id}")
    public Test getById(@Param("id") Long id);

    public Test selectByPrimaryKey(@Param("id") Long id);
}
