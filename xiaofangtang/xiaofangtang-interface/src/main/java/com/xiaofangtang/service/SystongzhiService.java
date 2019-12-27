package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Systongzhi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface SystongzhiService {
    Systongzhi getsystongzhiByid(int id);
    List<Systongzhi> getsystongzhi();
    int insertsystongzhi(Systongzhi systongzhi);
    int delsystongzhi(int id);
    int upsystongzhi(Systongzhi systongzhi);
}
