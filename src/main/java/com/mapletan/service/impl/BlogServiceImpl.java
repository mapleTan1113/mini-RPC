package com.mapletan.service.impl;

import com.mapletan.common.Blog;
import com.mapletan.service.BlogService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mapleTan
 * @Description
 * @date 2022/08/31
 **/

@Slf4j
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").useId(22).build();
        log.info("客户端查询了"+id+"博客");
        return blog;
    }
}
