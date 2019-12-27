package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Fankui;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface FankuiService {
    Fankui getfankuiByid(int id);
    List<Fankui> getfankui();
    int insertfankui(Fankui fankui);
    int delfankui(int id);
    int upfankui(Fankui fankui);
}
