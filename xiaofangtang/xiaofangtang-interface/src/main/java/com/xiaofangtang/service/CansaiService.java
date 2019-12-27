package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Cansai;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface CansaiService {
    Cansai getcansaiByid(int id);
    List<Cansai> getcansai();
    List<Cansai> getcansaiBystudent(int sid);
    int insertcansai(Cansai cansai);
    int delcansai(int id);
    int upcansai(Cansai cansai);
}
