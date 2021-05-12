package com.mapei.www.entity;

import lombok.Data;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.omg.CORBA.WStringValueHelper;

import java.util.UUID;

@Data
public class UserService extends Login {
    private String user_id;
    private String address;
    private String image;
    private String tel;

    public void setUser_id(){
        String uuid = UUID.randomUUID().toString();
        this.user_id = uuid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setPasswd(String passwd){
        Md5Hash pwd = new Md5Hash(passwd,"mapei",2);
        this.passwd = String.valueOf(pwd);
    }

    public String getPasswd() {
        return passwd;
    }
}
