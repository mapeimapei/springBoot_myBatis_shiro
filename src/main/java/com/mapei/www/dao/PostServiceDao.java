package com.mapei.www.dao;

import com.mapei.www.entity.Post;
import com.mapei.www.result.ResponseData;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostServiceDao {

    public List<Post> getPost();
    public Post queryPostById(String id);


}
