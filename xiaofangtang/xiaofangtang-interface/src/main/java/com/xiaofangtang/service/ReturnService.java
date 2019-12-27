package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Return;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ReturnService {
    Return getreturnByid(int id);
    List<Return> getreturn();
    int insertreturn(Return re);
    int delreturn(int id);
    int upreturn(Return re);
}
