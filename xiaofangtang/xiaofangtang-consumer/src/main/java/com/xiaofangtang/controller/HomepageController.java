package com.xiaofangtang.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofangtang.model.Teacher;
import com.xiaofangtang.service.HomedataService;
import com.xiaofangtang.service.TeacherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HomepageController {
    @Reference
    private HomedataService homedataService;
    @Reference
    private TeacherService teacherService;

    @RequestMapping("/getyao")
    public Map getyao(){
        List<Integer> list1 = homedataService.getyaoyuenumGroupBytime();
        List<String> list2 = homedataService.getyaoyuedateGroupBytime();
        Map<Object,Object> data= new HashMap<>();
        data.put("num",list1);
        data.put("time",list2);
        Map map = new HashMap();
        map.put("state",1);
        map.put("message","ok");
        map.put("data",data);
        return map;
    }

    @RequestMapping("/getdao")
    public Map getdao(){
        List<Integer> list1 = homedataService.getdaofangGroupBytime();
        List<String> list2 = homedataService.getdaofangdateGroupBytime();
        Map<Object,Object> data= new HashMap<>();
        data.put("num",list1);
        data.put("time",list2);
        Map map = new HashMap();
        map.put("state",1);
        map.put("message","ok");
        map.put("data",data);
        return map;
    }

    @RequestMapping("/getprice")
    public Map getprice(){
        List<Double> list1 = homedataService.getsumpriceGroupBytime();
        List<String> list2 = homedataService.gettimeGroupBytime();
        Map<Object,Object> data= new HashMap<>();
        data.put("num",list1);
        data.put("time",list2);
        Map map = new HashMap();
        map.put("state",1);
        map.put("message","ok");
        map.put("data",data);
        return map;
    }

    @RequestMapping("/gettyao")
    public Map gettyao(){
        List<Integer> list1 = homedataService.getyaoyuenumGroupByteacher();
        List<String> list2 = homedataService.getteacherGroupByteacher();
        List<String> list3 = new ArrayList<String>();
        for (String s1:list2)
        {
            Teacher teacher = new Teacher();
            teacher = teacherService.getteacherByid(Integer.parseInt(s1));
            String nickname = teacher.getNickname();
            list3.add(nickname);
        }
        Map<Object,Object> data= new HashMap<>();
        data.put("num",list1);
        data.put("name",list3);
        Map map = new HashMap();
        map.put("state",1);
        map.put("message","ok");
        map.put("data",data);
        return map;
    }

    @RequestMapping("/getsnum")
    public Map getsnum(){
        List<Integer> list1 = homedataService.getstudentnumGoupByclass();
        List<String> list2 = homedataService.getclassname();
        Map<Object,Object> data= new HashMap<>();
        data.put("num",list1);
        data.put("name",list2);
        Map map = new HashMap();
        map.put("state",1);
        map.put("message","ok");
        map.put("data",data);
        return map;
    }
}
