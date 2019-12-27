package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.SmininfoMapper;
import com.xiaofangtang.model.Smininfo;
import com.xiaofangtang.service.SmininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class SmininfoServiceImpl implements SmininfoService {
    @Autowired
    private SmininfoMapper smininfoMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Smininfo getsmininfoByid(int id) {
        return smininfoMapper.selectByPrimaryKey(String.valueOf(id));
    }

    @Override
    public List<Smininfo> getsmininfo() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Smininfo> list = (List<Smininfo>) redisTemplate.opsForValue().get("smininfoList");
        if (list==null){
            synchronized (this){
                list = (List<Smininfo>) redisTemplate.opsForValue().get("smininfoList");
                if (list==null){
                    list = smininfoMapper.getsmininfo();
                    redisTemplate.opsForValue().set("smininfoList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Smininfo> getsmininfoBystudent(int sid) {
        return smininfoMapper.getsmininfoBystudent(sid);
    }

    @Override
    public int insertsmininfo(Smininfo smininfo) {
        int i = smininfoMapper.insertSelective(smininfo);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("smininfoList",smininfoMapper.getsmininfo());
        }
        return i;
    }

    @Override
    public int delsmininfo(int id) {
        int i = smininfoMapper.deleteByPrimaryKey(String.valueOf(id));
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("smininfoList",smininfoMapper.getsmininfo());
        }
        return i;
    }

    @Override
    public int upsmininfo(Smininfo smininfo) {
        int i = smininfoMapper.updateByPrimaryKeySelective(smininfo);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("smininfoList",smininfoMapper.getsmininfo());
        }
        return i;
    }
}
