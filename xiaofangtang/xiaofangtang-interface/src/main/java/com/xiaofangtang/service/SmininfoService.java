package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Smininfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface SmininfoService {
    Smininfo getsmininfoByid(int id);
    List<Smininfo> getsmininfo();
    List<Smininfo> getsmininfoBystudent(int sid);
    int insertsmininfo(Smininfo smininfo);
    int delsmininfo(int id);
    int upsmininfo(Smininfo smininfo);
}
