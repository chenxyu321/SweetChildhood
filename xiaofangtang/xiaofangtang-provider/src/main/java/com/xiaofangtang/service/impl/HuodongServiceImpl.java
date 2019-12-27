package com.xiaofangtang.service.impl;

import com.xiaofangtang.mapper.HuodongMapper;
import com.xiaofangtang.model.Huodong;
import com.xiaofangtang.service.HuodongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class HuodongServiceImpl implements HuodongService {
    @Autowired
    private HuodongMapper huodongMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Huodong gethuodongByid(int id) {
        return huodongMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Huodong> gethuodong() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Huodong> list = (List<Huodong>) redisTemplate.opsForValue().get("huodongList");
        if (list==null){
            synchronized (this){
                list = (List<Huodong>) redisTemplate.opsForValue().get("huodongList");
                if (list==null){
                    list = huodongMapper.gethuodong();
                    redisTemplate.opsForValue().set("huodongList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Huodong> gethuodongBystudent(int id) {
        return huodongMapper.gethuodongBystudent(id);
    }

    @Override
    public int inserthuodong(Huodong huodong) {
        int i = huodongMapper.insertSelective(huodong);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huodongList",huodongMapper.gethuodong());
        }
        return i;
    }

    @Override
    public int delhuodong(int id) {
        int i = huodongMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huodongList",huodongMapper.gethuodong());
        }
        return i;
    }

    @Override
    public int uphuodong(Huodong huodong) {
        int i = huodongMapper.updateByPrimaryKeySelective(huodong);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huodongList",huodongMapper.gethuodong());
        }
        return i;
    }
}
