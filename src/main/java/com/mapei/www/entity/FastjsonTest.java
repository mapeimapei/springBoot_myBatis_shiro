package com.mapei.www.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class FastjsonTest {

    @JSONField(name = "post_id")
    private Integer id;
    private String string;
    /**
     * 格式化日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 转换为json时不包括该属性
     */
    @JSONField(serialize = false)
    private String ignore;

}
