package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Ruxuetest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface RuxuetestService {
    Ruxuetest getruxuetestByid(int id);
    List<Ruxuetest> getruxuetest();
    List<Ruxuetest> getruxuetestBystudent(int sid);
    List<Ruxuetest> getruxuetestBystudentandclass(int sid,String classes);
    int insertruxuetest(Ruxuetest ruxuetest);
    int delruxuetest(int id);
    int upruxuetest(Ruxuetest ruxuetest);
}
