package com.mapei.www.entity;

import lombok.Data;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.omg.CORBA.WStringValueHelper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
public class User {


    @NotBlank(message = "Email不能为空")
    @Email
    private String email;


    @NotEmpty(message = "密码不能为空")
    private String passwd;

    private String name;
    private String admin;
    private String status;
    private String user_id;
    private String address;
    private String image;
    private String tel;


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void MD5Passwd(){
        Md5Hash pwd = new Md5Hash(this.passwd,"mapei",2);
        this.passwd = pwd.toString();
    }

    public void UUID(){
        String uuid = UUID.randomUUID().toString();
        this.user_id = uuid;
    }

}
