package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Chengguophoto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ChengguophotoService {
    Chengguophoto getchengguophotoByid(int id);
    List<Chengguophoto> getchengguophoto();
    List<Chengguophoto> getchengguophotoBychengguo(String chengguoid);
    int insertchengguophoto(Chengguophoto chengguophoto);
    int delchengguophoto(int id);
    int upchengguophoto(Chengguophoto chengguophoto);
}
