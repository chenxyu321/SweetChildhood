package com.xiaofangtang.service.impl;

import com.xiaofangtang.mapper.FankuiMapper;
import com.xiaofangtang.model.Fankui;
import com.xiaofangtang.service.FankuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class FankuiServiceImpl implements FankuiService {
    @Autowired
    private FankuiMapper fankuiMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Fankui getfankuiByid(int id) {
        return fankuiMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Fankui> getfankui() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Fankui> list = (List<Fankui>) redisTemplate.opsForValue().get("fankuiList");
        if (list==null){
            synchronized (this){
                list = (List<Fankui>) redisTemplate.opsForValue().get("fankuiList");
                if (list==null){
                    list = fankuiMapper.getfankui();
                    redisTemplate.opsForValue().set("fankuiList",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertfankui(Fankui fankui) {
        int i = fankuiMapper.insertSelective(fankui);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("fankuiList",fankuiMapper.getfankui());
        }
        return i;
    }

    @Override
    public int delfankui(int id) {
        int i = fankuiMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("fankuiList",fankuiMapper.getfankui());
        }
        return i;
    }

    @Override
    public int upfankui(Fankui fankui) {
        int i = fankuiMapper.updateByPrimaryKeySelective(fankui);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("fankuiList",fankuiMapper.getfankui());
        }
        return i;
    }
}
