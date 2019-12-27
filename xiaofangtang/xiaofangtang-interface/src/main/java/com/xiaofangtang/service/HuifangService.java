package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Huifang;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface HuifangService {
    Huifang gethuifangByid(int id);
    List<Huifang> gethuifang();
    List<Huifang> gethuifangByyaoyueid(int yid);
    int inserthuifang(Huifang huifang);
    int delhuifang(int id);
    int uphuifang(Huifang huifang);
}
