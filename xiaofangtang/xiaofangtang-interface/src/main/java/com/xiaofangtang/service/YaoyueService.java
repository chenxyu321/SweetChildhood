package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Yaoyue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface YaoyueService {
    Yaoyue getyaoyueByid(int id);
    List<Yaoyue> getyaoyue();
    List<Yaoyue> getyaoyueByteacher(String teacher);
    int insertyaoyue(Yaoyue yaoyue);
    int delyaoyue(int id);
    int upyaoyue(Yaoyue yaoyue);
}
