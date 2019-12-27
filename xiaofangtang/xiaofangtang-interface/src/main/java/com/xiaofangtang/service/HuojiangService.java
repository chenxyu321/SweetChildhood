package com.xiaofangtang.service;

import com.xiaofangtang.model.Huojiang;

import java.util.List;

public interface HuojiangService {
    Huojiang gethuojiangByid(int id);
    List<Huojiang> gethuojiang();
    List<Huojiang> gethuojiangBystudent(int sid);
    int inserthuojiang(Huojiang huojiang);
    int delhuojiang(int id);
    int uphuojiang(Huojiang huojiang);
}
