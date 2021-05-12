package com.mapei.www.entity;

import lombok.Data;
import org.apache.shiro.crypto.hash.Md5Hash;

@Data
public class Login {
    protected String email;
    protected String passwd;
    protected String name;
    protected String admin;
    protected String status;
}
