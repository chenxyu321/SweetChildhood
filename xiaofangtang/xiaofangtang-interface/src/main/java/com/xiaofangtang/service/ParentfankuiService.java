package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Parentfankui;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ParentfankuiService {
    Parentfankui getparentfankuiByid(int id);
    List<Parentfankui> getparentfankui();
    int insertparentfankui(Parentfankui parentfankui);
    int delparentfankui(int id);
    int upparentfankui(Parentfankui parentfankui);
}
