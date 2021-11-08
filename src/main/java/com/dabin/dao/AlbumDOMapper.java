package com.dabin.dao;

import com.dabin.pojo.meta.AlbumDO;
import com.dabin.pojo.meta.AlbumDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDOMapper {
    long countByExample(AlbumDOExample example);

    int deleteByExample(AlbumDOExample example);

    int deleteByPrimaryKey(Short id);

    int insert(AlbumDO record);

    int insertSelective(AlbumDO record);

    List<AlbumDO> selectByExample(AlbumDOExample example);

    AlbumDO selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") AlbumDO record, @Param("example") AlbumDOExample example);

    int updateByExample(@Param("record") AlbumDO record, @Param("example") AlbumDOExample example);

    int updateByPrimaryKeySelective(AlbumDO record);

    int updateByPrimaryKey(AlbumDO record);
}
