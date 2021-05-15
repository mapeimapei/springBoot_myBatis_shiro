package com.mapei.www.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapei.www.dao.TbUserDao;
import com.mapei.www.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author longzhonghua
 * @createdata 3/17/2019 7:08 PM
 * @description
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @Autowired
    TbUserDao tbUserDao;

    @GetMapping("/demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("demo");
        return modelAndView;
    }

    @GetMapping("/listall")
    public String listCategory(Model m, @RequestParam(value="start",defaultValue="0")int start, @RequestParam(value = "size", defaultValue = "2") int size) throws Exception {
        //1. 在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
        //2. 根据start,size进行分页，并且设置id 倒排序
        PageHelper.startPage(start,size,"name desc");
        //3. 因为PageHelper的作用，这里就会返回当前分页的集合了
        List<TbUser> cs = tbUserDao.SelectTbUser();
        //4. 根据返回的集合，创建PageInfo对象
        PageInfo<TbUser> page = new PageInfo<>(cs);
        //5. 把PageInfo对象扔进model，以供后续显示
        m.addAttribute("page", page);
        //System.out.println(page..is.end.e.isIsLastPage().I.getLastPage().f.isIsFirstPage().getFirstPage().getLastPage().isIsFirstPage());
        //6. 跳转到listCategory.jsp
        return "list";
    }





}
