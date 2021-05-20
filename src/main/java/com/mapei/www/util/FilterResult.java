package com.mapei.www.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterResult {

    /**
     * @param object 需要处理的数据
     * @param fields 需要返回给前端的字段
     * @return
     */
    public static Object main(Object object, String[] fields) {
        PropertyPreFilters propertyPreFilters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter include = propertyPreFilters.addFilter();
        include.addIncludes(fields);//include.addExcludes(fields) 或者排除掉一些字段
        String json = JSONObject.toJSONString(object, include, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);

        return JSONObject.parse(json);
    }



}
