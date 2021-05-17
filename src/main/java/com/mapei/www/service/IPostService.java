package com.mapei.www.service;

import com.mapei.www.entity.Post;

import java.util.List;

public interface IPostService {
    /**
     * 获取文章列表
     * @return 文章列表List
     */
    public List<Post> getPost();

    /**
     * 获取文章详情
     * @param id 文章id
     * @return Post
     */
    public Post queryPostById(String id);

}
