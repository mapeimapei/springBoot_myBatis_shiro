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

    /**
     * 添加文章
     * @param post
     * @return
     */
    public Post addSingle(Post post);


    /**
     * 更新文章
     * @param post
     * @return
     */
    public Post updateSingle(Post post);

    /**
     *  删除文章
     * @param id
     * @return
     */
    public int deleteSingle(String id);



}
