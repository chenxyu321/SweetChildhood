package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.BumenMapper;
import com.xiaofangtang.model.Bumen;
import com.xiaofangtang.service.BumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class BumenServiceImpl implements BumenService {
    @Autowired
    private BumenMapper bumenMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public List<Bumen> getbumen() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Bumen> list = (List<Bumen>) redisTemplate.opsForValue().get("bumenList");
        if (list==null){
            synchronized (this){
                list=(List<Bumen>) redisTemplate.opsForValue().get("bumenList");
                if (list==null){
                    list = bumenMapper.getbumen();
                    redisTemplate.opsForValue().set("bumenList",list);
                }
            }
        }
        return list;
    }

    @Override
    public Bumen getbumenByid(int id) {
        return bumenMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertbumen(Bumen bumen) {
        int i = bumenMapper.insertSelective(bumen);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("bumenList",bumenMapper.getbumen());
        }
        return i;
    }

    @Override
    public int delbumen(int id) {
        int i = bumenMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("bumenList",bumenMapper.getbumen());
        }
        return i;
    }

    @Override
    public int upbumen(Bumen bumen) {
        int i = bumenMapper.updateByPrimaryKeySelective(bumen);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("bumenList",bumenMapper.getbumen());
        }
        return i;
    }
}
