package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.RuxuetestMapper;
import com.xiaofangtang.model.Ruxuetest;
import com.xiaofangtang.service.RuxuetestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class RuxuetestServiceImpl implements RuxuetestService {
    @Autowired
    private RuxuetestMapper ruxuetestMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Ruxuetest getruxuetestByid(int id) {
        return ruxuetestMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ruxuetest> getruxuetest() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Ruxuetest> list = (List<Ruxuetest>) redisTemplate.opsForValue().get("ruxuetestList");
        if (list==null){
            synchronized (this){
                list = (List<Ruxuetest>) redisTemplate.opsForValue().get("ruxuetestList");
                if (list==null){
                    list = ruxuetestMapper.getruxuetest();
                    redisTemplate.opsForValue().set("ruxuetestList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Ruxuetest> getruxuetestBystudent(int sid) {
        return ruxuetestMapper.getruxuetestBystudent(sid);
    }

    @Override
    public List<Ruxuetest> getruxuetestBystudentandclass(int sid, String classes) {
        return ruxuetestMapper.getruxuetestBystudentandclass(sid,classes);
    }

    @Override
    public int insertruxuetest(Ruxuetest ruxuetest) {
        int i = ruxuetestMapper.insertSelective(ruxuetest);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("ruxuetestList",ruxuetestMapper.getruxuetest());
        }
        return i;
    }

    @Override
    public int delruxuetest(int id) {
        int i = ruxuetestMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("ruxuetestList",ruxuetestMapper.getruxuetest());
        }
        return i;
    }

    @Override
    public int upruxuetest(Ruxuetest ruxuetest) {
        int i = ruxuetestMapper.updateByPrimaryKeySelective(ruxuetest);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("ruxuetestList",ruxuetestMapper.getruxuetest());
        }
        return i;
    }
}
