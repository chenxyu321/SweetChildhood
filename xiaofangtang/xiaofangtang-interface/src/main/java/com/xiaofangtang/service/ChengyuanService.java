package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Chengyuan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ChengyuanService {
    Chengyuan getchengyuanByid(int id);
    List<Chengyuan> getchengyuan();
    List<Chengyuan> getchengyuanBystudent(int sid);
    int insertchengyuan(Chengyuan chengyuan);
    int delchengyuan(int id);
    int upchengyuan(Chengyuan chengyuan);
}
