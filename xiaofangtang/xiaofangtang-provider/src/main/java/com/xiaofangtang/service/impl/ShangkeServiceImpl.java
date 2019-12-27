package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ShangkeMapper;
import com.xiaofangtang.model.Shangke;
import com.xiaofangtang.service.ShangkeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ShangkeServiceImpl implements ShangkeService {
    @Autowired
    private ShangkeMapper shangkeMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Shangke getshangkeByid(int id) {
        return shangkeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Shangke> getshangke() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Shangke> list = (List<Shangke>) redisTemplate.opsForValue().get("shangkeList");
        if (list==null){
            synchronized (this){
                list = (List<Shangke>) redisTemplate.opsForValue().get("shangkeList");
                if (list==null){
                    list = shangkeMapper.getshangke();
                    redisTemplate.opsForValue().set("shangkeList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Shangke> getshangkeBystudent(int id) {
        return shangkeMapper.getshangkeBystudent(id);
    }

    @Override
    public int insertshangke(Shangke shangke) {
        int i = shangkeMapper.insertSelective(shangke);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("shangkeList",shangkeMapper.getshangke());
        }
        return i;
    }

    @Override
    public int delshangke(int id) {
        int i = shangkeMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("shangkeList",shangkeMapper.getshangke());
        }
        return i;
    }

    @Override
    public int upshangke(Shangke shangke) {
        int i = shangkeMapper.updateByPrimaryKeySelective(shangke);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("shangkeList",shangkeMapper.getshangke());
        }
        return i;
    }
}
