package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Bumen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface BumenService {
    List<Bumen> getbumen();
    Bumen getbumenByid(int id);
    int insertbumen(Bumen bumen);
    int delbumen(int id);
    int upbumen(Bumen bumen);
}
