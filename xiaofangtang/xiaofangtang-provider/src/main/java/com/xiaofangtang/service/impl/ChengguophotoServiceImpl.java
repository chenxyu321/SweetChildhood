package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ChengguophotoMapper;
import com.xiaofangtang.model.Chengguophoto;
import com.xiaofangtang.service.ChengguophotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ChengguophotoServiceImpl implements ChengguophotoService {
    @Autowired
    private ChengguophotoMapper chengguophotoMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Chengguophoto getchengguophotoByid(int id) {
        return chengguophotoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Chengguophoto> getchengguophoto() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Chengguophoto> list = (List<Chengguophoto>) redisTemplate.opsForValue().get("chengguophotoList");
        if (list==null){
            synchronized (this){
                list = (List<Chengguophoto>) redisTemplate.opsForValue().get("chengguophotoList");
                if (list==null){
                    list = chengguophotoMapper.getchengguophoto();
                    redisTemplate.opsForValue().set("chengguophotoList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Chengguophoto> getchengguophotoBychengguo(String chengguoid) {
        return chengguophotoMapper.getchengguophotoBychengguo(chengguoid);
    }

    @Override
    public int insertchengguophoto(Chengguophoto chengguophoto) {
        int i = chengguophotoMapper.insertSelective(chengguophoto);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengguophotoList",chengguophotoMapper.getchengguophoto());
        }
        return i;
    }

    @Override
    public int delchengguophoto(int id) {
        int i = chengguophotoMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengguophotoList",chengguophotoMapper.getchengguophoto());
        }
        return i;
    }

    @Override
    public int upchengguophoto(Chengguophoto chengguophoto) {
        int i = chengguophotoMapper.updateByPrimaryKeySelective(chengguophoto);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengguophotoList",chengguophotoMapper.getchengguophoto());
        }
        return i;
    }
}
