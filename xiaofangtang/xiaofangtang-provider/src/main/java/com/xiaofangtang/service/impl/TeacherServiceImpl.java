package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.TeacherMapper;
import com.xiaofangtang.model.Teacher;
import com.xiaofangtang.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Teacher getteacherByid(int id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean login(String username, String password) {
        if(username==null||password==null)
            return false;
        else
        {
            Teacher teacher = new Teacher();
            Map<String,Object> teachermap = new ConcurrentHashMap<>();
            teachermap.put("username",username);
            teachermap.put("password",password);
            teacher = teacherMapper.login(teachermap);
            if (teacher == null)
                return false;
            return true;
        }
    }

    @Override
    public Teacher selectteacherBytname(String tname) {
        return teacherMapper.selectteacherBytname(tname);
    }

    @Override
    public List<Teacher> getteacher() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Teacher> list = (List<Teacher>) redisTemplate.opsForValue().get("teacherList");
        if (list==null){
            synchronized (this){
                list = (List<Teacher>) redisTemplate.opsForValue().get("teacherList");
                if (list==null){
                    list = teacherMapper.getteacher();
                    redisTemplate.opsForValue().set("teacherList",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertteacher(Teacher teacher) {
        int i = teacherMapper.insert(teacher);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("teacherList",teacherMapper.getteacher());
        }
        return i;
    }

    @Override
    public int delteacher(int id) {
        int i = teacherMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("teacherList",teacherMapper.getteacher());
        }
        return i;
    }

    @Override
    public int upteacher(Teacher teacher) {
        int i = teacherMapper.updateByPrimaryKeySelective(teacher);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("teacherList",teacherMapper.getteacher());
        }
        return i;
    }
}
