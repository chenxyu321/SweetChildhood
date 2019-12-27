package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface TeacherService {
    Teacher getteacherByid(int id);
    boolean login (String username,String password);
    Teacher selectteacherBytname(String tname);
    List<Teacher> getteacher();
    int insertteacher(Teacher teacher);
    int delteacher(int id);
    int upteacher(Teacher teacher);
}
