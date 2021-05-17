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

    public List<Post> getPost(){
        List<Post> list = postServiceDao.getPost();

        for(Post post : list){
            post.formatTime(post.getCreated_at());
        }
        
        return list;
    }
}
