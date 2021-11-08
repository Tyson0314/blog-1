package com.dabin.dao;

import com.dabin.pojo.meta.BlogTagsDO;
import com.dabin.pojo.meta.BlogTagsDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface BlogTagsDOMapper {
    long countByExample(BlogTagsDOExample example);

    int deleteByExample(BlogTagsDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogTagsDO record);

    int insertSelective(BlogTagsDO record);

    List<BlogTagsDO> selectByExample(BlogTagsDOExample example);

    BlogTagsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogTagsDO record, @Param("example") BlogTagsDOExample example);

    int updateByExample(@Param("record") BlogTagsDO record, @Param("example") BlogTagsDOExample example);

    int updateByPrimaryKeySelective(BlogTagsDO record);

    int updateByPrimaryKey(BlogTagsDO record);
}
