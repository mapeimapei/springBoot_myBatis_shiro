package com.mapei.www.web;


import com.mapei.www.result.ResponseData;
import com.mapei.www.service.impl.DemoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
@RequestMapping("/demo")
@Api(value = "演示")
public class DemoServiceController {

    @Autowired
    DemoService demoService;

    @GetMapping("/findById")
    public ResponseData findById(@NotBlank(message = "id不能为空") @RequestParam String id){
        return demoService.findById(id);
    }


}
