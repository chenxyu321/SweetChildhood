package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.HuifangMapper;
import com.xiaofangtang.model.Huifang;
import com.xiaofangtang.service.HuifangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class HuifangServiceImpl implements HuifangService {
    @Autowired
    private HuifangMapper huifangMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Huifang gethuifangByid(int id) {
        return huifangMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Huifang> gethuifang() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Huifang> list = (List<Huifang>) redisTemplate.opsForValue().get("huifangList");
        if (list==null){
            synchronized (this){
                list = (List<Huifang>) redisTemplate.opsForValue().get("huifangList");
                if (list==null)
                {
                    list = huifangMapper.gethuifang();
                    redisTemplate.opsForValue().set("huifangList",list);
                }

            }
        }
        return list;
    }

    @Override
    public List<Huifang> gethuifangByyaoyueid(int yid) {
        return huifangMapper.gethuifangByyaoyueid(yid);
    }

    @Override
    public int inserthuifang(Huifang huifang) {
        int i = huifangMapper.insertSelective(huifang);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huifangList",huifangMapper.gethuifang());
        }
        return i;
    }

    @Override
    public int delhuifang(int id) {
        int i = huifangMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huifangList",huifangMapper.gethuifang());
        }
        return i;
    }

    @Override
    public int uphuifang(Huifang huifang) {
        int i = huifangMapper.updateByPrimaryKeySelective(huifang);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huifangList",huifangMapper.gethuifang());
        }
        return i;
    }
}
