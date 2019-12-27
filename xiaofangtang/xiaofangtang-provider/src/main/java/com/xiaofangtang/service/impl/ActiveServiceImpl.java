package com.xiaofangtang.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ActiveMapper;
import com.xiaofangtang.model.Active;
import com.xiaofangtang.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    private ActiveMapper activeMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Active getactiveByid(int id) {
        return activeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Active> getactive() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Active> list = (List<Active>) redisTemplate.opsForValue().get("activeList");
        if (list==null){
            synchronized (this){
                list = (List<Active>) redisTemplate.opsForValue().get("activeList");
                if (list==null){
                    list=activeMapper.getactive();
                    redisTemplate.opsForValue().set("activeList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Active> getactiveByopen() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Active> list = (List<Active>) redisTemplate.opsForValue().get("activeList1");
        if (list==null){
            synchronized (this){
                list = (List<Active>) redisTemplate.opsForValue().get("activeList1");
                if (list!=null){
                    list=activeMapper.getactiveByopen();
                    redisTemplate.opsForValue().set("activeList1",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertactive(Active active) {
        int i = activeMapper.insertSelective(active);
        if (i!=0)
        {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("activeList",activeMapper.getactive());
            redisTemplate.opsForValue().set("activeList1",activeMapper.getactiveByopen());
        }
        return i;
    }

    @Override
    public int delactive(int id) {
        int i = activeMapper.deleteByPrimaryKey(id);
        if (i!=0)
        {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("activeList",activeMapper.getactive());
            redisTemplate.opsForValue().set("activeList1",activeMapper.getactiveByopen());
        }
        return i;
    }

    @Override
    public int upactive(Active active) {
        int i = activeMapper.updateByPrimaryKeySelective(active);
        if (i!=0)
        {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("activeList",activeMapper.getactive());
            redisTemplate.opsForValue().set("activeList1",activeMapper.getactiveByopen());
        }
        return i;
    }
}
