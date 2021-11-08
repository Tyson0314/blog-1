package com.dabin.dao;

import com.dabin.pojo.dto.BlogAddRequest;
import com.dabin.pojo.dto.BlogListRequest;
import com.dabin.pojo.meta.BlogDO;
import com.dabin.pojo.meta.BlogExample;
import com.dabin.pojo.meta.BlogWithBLOBs;
import com.dabin.pojo.vo.BlogDetail4UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogWithBLOBs record);

    int insertSelective(BlogWithBLOBs record);

    List<BlogWithBLOBs> selectByExampleWithBLOBs(BlogExample example);

    List<BlogDO> selectByExample(BlogExample example);

    BlogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogWithBLOBs record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogWithBLOBs record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") BlogDO record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(BlogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BlogWithBLOBs record);

    int updateByPrimaryKey(BlogDO record);

    BlogWithBLOBs selectByIdAndStatus(@Param("id") Integer id, @Param("blogStatus") Byte blogStatus);

    List<BlogDO> selectBlogs(BlogListRequest blogListRequest);

    List<BlogDetail4UserVO> selectHotOrRecommendBlogs(@Param("code") int code, @Param("limit") int limit);

    int updateBlog(BlogAddRequest blogAddRequest);

    /**
     * 上一条-1 或者 下一条1
     * @param id
     * @return
     */
    BlogDO selectLastOrNext(@Param("id")Integer id, @Param("isLast")boolean isLast);


    int updateBlogCount(@Param("blogId") Integer id, @Param("type") String type);
}
