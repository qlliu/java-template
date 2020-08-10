package com.doublefs.common.javatemplate.dao;

import com.doublefs.common.javatemplate.model.FeedConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * @author liuqingliang
 */
@Mapper
public interface FeedConfigDao {
    @Select("select * from feed_config limit 1")
    FeedConfig getTest();
}
