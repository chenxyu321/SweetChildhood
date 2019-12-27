package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.YaoyueMapper;
import com.xiaofangtang.model.Yaoyue;
import com.xiaofangtang.service.YaoyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class YaoyueServiceImpl implements YaoyueService {
    @Autowired
    private YaoyueMapper yaoyueMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Yaoyue getyaoyueByid(int id) {
        return yaoyueMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Yaoyue> getyaoyue() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Yaoyue> list = (List<Yaoyue>) redisTemplate.opsForValue().get("yaoyueList");
        if (list==null){
            synchronized (this){
                list = (List<Yaoyue>) redisTemplate.opsForValue().get("yaoyueList");
                if (list==null){
                    list = yaoyueMapper.getyaoyue();
                    redisTemplate.opsForValue().set("yaoyueList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Yaoyue> getyaoyueByteacher(String teacher) {
        return yaoyueMapper.getyaoyueByteacher(teacher);
    }

    @Override
    public int insertyaoyue(Yaoyue yaoyue) {
        int i = yaoyueMapper.insert(yaoyue);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("yaoyueList",yaoyueMapper.getyaoyue());
        }
        return i;
    }

    @Override
    public int delyaoyue(int id) {
        int i = yaoyueMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("yaoyueList",yaoyueMapper.getyaoyue());
        }
        return i;
    }

    @Override
    public int upyaoyue(Yaoyue yaoyue) {
        int i = yaoyueMapper.updateByPrimaryKeySelective(yaoyue);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("yaoyueList",yaoyueMapper.getyaoyue());
        }
        return i;
    }
}
