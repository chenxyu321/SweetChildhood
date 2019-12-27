package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Huodong;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface HuodongService {
    Huodong gethuodongByid(int id);
    List<Huodong> gethuodong();
    List<Huodong> gethuodongBystudent(int id);
    int inserthuodong(Huodong huodong);
    int delhuodong(int id);
    int uphuodong(Huodong huodong);
}

