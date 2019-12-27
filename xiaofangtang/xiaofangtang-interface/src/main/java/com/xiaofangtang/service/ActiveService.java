package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Active;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Service
public interface ActiveService {
    Active getactiveByid(int id);
    List<Active> getactive();
    List<Active> getactiveByopen();
    int insertactive(Active active);
    int delactive(int id);
    int upactive(Active active);
}
