package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Zuoye;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ZuoyeService {
    Zuoye getzuoyeByid(int id);
    List<Zuoye> getzuoye();
    List<Zuoye> getzuoyeBystudent(int sid);
    int insertzuoye(Zuoye zuoye);
    int delzuoye(int id);
    int upzuoye(Zuoye zuoye);
}
