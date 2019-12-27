package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ZuoyeMapper;
import com.xiaofangtang.model.Zuoye;
import com.xiaofangtang.service.ZuoyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ZuoyeServiceImpl implements ZuoyeService {
    @Autowired
    private ZuoyeMapper zuoyeMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Zuoye getzuoyeByid(int id) {
        return zuoyeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Zuoye> getzuoye() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Zuoye> list = (List<Zuoye>) redisTemplate.opsForValue().get("zuoyeList");
        if (list==null){
            synchronized (this){
                list = (List<Zuoye>) redisTemplate.opsForValue().get("zuoyeList");
                if (list==null){
                    list = zuoyeMapper.getzuoye();
                    redisTemplate.opsForValue().set("zuoyeList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Zuoye> getzuoyeBystudent(int sid) {
        return zuoyeMapper.getzuoyeBystudent(sid);
    }

    @Override
    public int insertzuoye(Zuoye zuoye) {
        int i = zuoyeMapper.insert(zuoye);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("zuoyeList",zuoyeMapper.getzuoye());
        }
        return i;
    }

    @Override
    public int delzuoye(int id) {
        int i = zuoyeMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("zuoyeList",zuoyeMapper.getzuoye());
        }
        return i;
    }

    @Override
    public int upzuoye(Zuoye zuoye) {
        int i = zuoyeMapper.updateByPrimaryKeySelective(zuoye);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("zuoyeList",zuoyeMapper.getzuoye());
        }
        return i;
    }
}
