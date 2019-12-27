package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Parent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface ParentService {
    Parent getparentByid(int id);
    List<Parent> getparent();
    List<Parent> getparentBystudent(int sid);
    int insertparent(Parent parent);
    int delparent(int id);
    int upparent(Parent parent);
}
