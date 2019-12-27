package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Ketangbiaoxian;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface KetangbiaoxianService {
    Ketangbiaoxian getketangbiaoxianByid(int id);
    List<Ketangbiaoxian> getketangbiaoxian();
    List<Ketangbiaoxian> getketangbiaoxianBystudent(int sid);
    List<Ketangbiaoxian> getketangbiaoxianBystudentandclass(int sid,String classes);
    int insertketangbiaoxian(Ketangbiaoxian ketangbiaoxian);
    int delketangbiaoxian(int id);
    int upketangbiaoxian(Ketangbiaoxian ketangbiaoxian);
}