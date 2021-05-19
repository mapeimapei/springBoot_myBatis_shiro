package com.mapei.www.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Data
public class Post {

    @NotBlank
    @JSONField(name = "post_id")
    private String id;
    @NotBlank
    private String user_id;
    @NotBlank
    private String user_name;
    private String user_image = "about:blank";
    @NotBlank
    private String name;
    @NotBlank
    private String summary;
    @NotBlank
    @JSONField(serialize = false)
    private String content;

    private String created_at;

    public void UUID(){
        this.id = UUID.randomUUID().toString();
    }

    public void formatTime(String created_at){
        String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        this.created_at = new SimpleDateFormat(TIME_FORMAT).format(new Date(Long.parseLong(created_at+"000")));
    }

    public void curTime(){
        this.created_at = new Date().toString();
    }


}
