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

    public Post addSingle(Post post);
    public Post updateSingle(Post post);

//    insert：   插入n条记录，返回影响行数n。（n>=1，n为0时实际为插入失败）
//    update：更新n条记录，返回影响行数n。（n>=0）
//    delete： 删除n条记录，返回影响行数n。（n>=0）

    int deleteSingle(String id);




}
