package com.dabin.pojo.meta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDO  extends  BaseDO{

    private Integer categoryId;

    private String title;

    private String summary;

    private String imgUrl;

    private String blogCatalog;

    private String author;

    private Integer code;

    private Integer viewCount;

    private Integer likeCount;

    private Integer commentCount;

    private Byte blogStatus;
}
