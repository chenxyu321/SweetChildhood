package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Shangke;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ShangkeService {
    Shangke getshangkeByid(int id);
    List<Shangke> getshangke();
    List<Shangke> getshangkeBystudent(int id);
    int insertshangke(Shangke shangke);
    int delshangke(int id);
    int upshangke(Shangke shangke);
}
