package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Qiandan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface QiandanService {
    Qiandan getqiandanByid(int id);
    List<Qiandan> getqiandan();
    int insertqiandan(Qiandan qiandan);
    int delqiandan(int id);
    int upqiandan(Qiandan qiandan);
}
