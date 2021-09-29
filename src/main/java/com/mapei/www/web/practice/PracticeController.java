package com.mapei.www.web.practice;

import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/practice/")
@Api(value = "实践模块")
public class PracticeController {

    @PostMapping("demo1/postTest")
    public ResponseData postTest(@RequestBody Map map) throws Exception {
        return new ResponseData(ExceptionMsg.SUCCESS, map);
    }

    // @RequestParam 参数不一样需要用，如果一样就不用了
    @GetMapping("demo1/getTest")
    public ResponseData postTest(@RequestParam("user_id") String id, @RequestParam("name") String name, @RequestParam("sex") String sex) throws Exception {
        Map<String, String> map = new HashMap();
        map.put("user_id", id);
        map.put("name", name);
        map.put("sex", sex);
        return new ResponseData(ExceptionMsg.SUCCESS, map);
    }

    @GetMapping("demo1/getTest2")
    public ResponseData postTest2(String id, String name, String sex) throws Exception {

        System.out.println(id);
        System.out.println(name);
        System.out.println(sex);

        Map<String, String> map = new HashMap();
        map.put("id", id);
        map.put("name", name);
        map.put("sex", sex);
        return new ResponseData(ExceptionMsg.SUCCESS, map);
    }


}
