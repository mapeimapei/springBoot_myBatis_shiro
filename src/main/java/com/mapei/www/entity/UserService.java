package com.mapei.www.entity;

import lombok.Data;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.omg.CORBA.WStringValueHelper;

import java.util.UUID;

@Data
public class UserService {
    private String email;
    private String passwd;
    private String name;
    private String admin;
    private String status;
    private String user_id;
    private String address;
    private String image;
    private String tel;

    public void MD5Passwd(){
        Md5Hash pwd = new Md5Hash(this.passwd,"mapei",2);
        this.passwd = pwd.toString();
    }

    public void UUID(){
        String uuid = UUID.randomUUID().toString();
        this.user_id = uuid;
    }

}
