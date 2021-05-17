package com.mapei.www.service.impl;

import com.mapei.www.dao.PostServiceDao;
import com.mapei.www.entity.Post;
import com.mapei.www.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostService implements IPostService {

    @Autowired
    PostServiceDao postServiceDao;

    /**
     * 获取文章列表
     * @return 文章列表List
     */
    public List<Post> getPost(){
        List<Post> list = postServiceDao.getPost();
        for(Post post : list){
            post.formatTime(post.getCreated_at());
        }
        return list;
    }

    /**
     * 获取文章详情
     * @param id 文章id
     * @return Post
     */
    public Post queryPostById(String id){
        Post post = postServiceDao.queryPostById(id);
        post.formatTime(post.getCreated_at());
        return post;
    }

}
