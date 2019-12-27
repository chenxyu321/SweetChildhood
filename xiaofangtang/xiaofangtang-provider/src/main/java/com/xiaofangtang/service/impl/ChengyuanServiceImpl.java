package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ChengyuanMapper;
import com.xiaofangtang.model.Chengyuan;
import com.xiaofangtang.service.ChengyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ChengyuanServiceImpl implements ChengyuanService {
    @Autowired
    private ChengyuanMapper chengyuanMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Chengyuan getchengyuanByid(int id) {
        return chengyuanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Chengyuan> getchengyuan() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Chengyuan> list = (List<Chengyuan>) redisTemplate.opsForValue().get("chengyuanList");
        if (list==null){
            synchronized (this){
                list = (List<Chengyuan>) redisTemplate.opsForValue().get("chengyuanList");
                if (list==null){
                    list = chengyuanMapper.getchengyuan();
                    redisTemplate.opsForValue().set("chengyuanList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Chengyuan> getchengyuanBystudent(int sid) {
        return chengyuanMapper.getchengyuanBystudent(sid);
    }

    @Override
    public int insertchengyuan(Chengyuan chengyuan) {
        int i = chengyuanMapper.insertSelective(chengyuan);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengyuanList",chengyuanMapper.getchengyuan());
        }
        return i;
    }

    @Override
    public int delchengyuan(int id) {
        int i = chengyuanMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengyuanList",chengyuanMapper.getchengyuan());
        }
        return i;
    }

    @Override
    public int upchengyuan(Chengyuan chengyuan) {
        int i = chengyuanMapper.updateByPrimaryKeySelective(chengyuan);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengyuanList",chengyuanMapper.getchengyuan());
        }
        return i;
    }
}
