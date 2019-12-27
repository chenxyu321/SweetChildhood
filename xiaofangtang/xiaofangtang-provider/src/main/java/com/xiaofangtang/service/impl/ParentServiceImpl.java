package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ParentMapper;
import com.xiaofangtang.model.Parent;
import com.xiaofangtang.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentMapper parentMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Parent getparentByid(int id) {
        return parentMapper.selectByPrimaryKey(String.valueOf(id));
    }

    @Override
    public List<Parent> getparent() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Parent> list = (List<Parent>) redisTemplate.opsForValue().get("parentList");
        if (list==null){
            synchronized (this){
                list = (List<Parent>) redisTemplate.opsForValue().get("parentList");
                if (list==null){
                    list = parentMapper.getparent();
                    redisTemplate.opsForValue().set("parentList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Parent> getparentBystudent(int sid) {
        return parentMapper.getparentBystudent(sid);
    }

    @Override
    public int insertparent(Parent parent) {
        int i = parentMapper.insertSelective(parent);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("parentList",parentMapper.getparent());
        }
        return i;
    }

    @Override
    public int delparent(int id) {
        int i = parentMapper.deleteByPrimaryKey(String.valueOf(id));
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("parentList",parentMapper.getparent());
        }
        return i;
    }

    @Override
    public int upparent(Parent parent) {
        int i = parentMapper.updateByPrimaryKeySelective(parent);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("parentList",parentMapper.getparent());
        }
        return i;
    }
}
