package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Chengguo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ChengguoService {
    Chengguo getchengguoByid(int id);
    List<Chengguo> getchengguo();
    List<Chengguo> getchengguoBystudent(int sid);
    int insertchengguo(Chengguo chengguo);
    int delchengguo(int id);
    int upchengguo(Chengguo chengguo);
}
