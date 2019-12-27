package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ParentfankuiMapper;
import com.xiaofangtang.model.Parentfankui;
import com.xiaofangtang.service.ParentfankuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ParentfankuiServiceImpl implements ParentfankuiService {
    @Autowired
    private ParentfankuiMapper parentfankuiMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Parentfankui getparentfankuiByid(int id) {
        return parentfankuiMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Parentfankui> getparentfankui() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Parentfankui> list = (List<Parentfankui>) redisTemplate.opsForValue().get("parentfankuiList");
        if (list==null){
            synchronized (this){
                list = (List<Parentfankui>) redisTemplate.opsForValue().get("parentfankuiList");
                if (list==null){
                    list = parentfankuiMapper.getparentfankui();
                    redisTemplate.opsForValue().set("parentfankuiList",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertparentfankui(Parentfankui parentfankui) {
        int i = parentfankuiMapper.insertSelective(parentfankui);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("parentfankuiList",parentfankuiMapper.getparentfankui());
        }
        return i;
    }

    @Override
    public int delparentfankui(int id) {
        int i = parentfankuiMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("parentfankuiList",parentfankuiMapper.getparentfankui());
        }
        return i;
    }

    @Override
    public int upparentfankui(Parentfankui parentfankui) {
        int i = parentfankuiMapper.updateByPrimaryKeySelective(parentfankui);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("parentfankuiList",parentfankuiMapper.getparentfankui());
        }
        return i;
    }
}
