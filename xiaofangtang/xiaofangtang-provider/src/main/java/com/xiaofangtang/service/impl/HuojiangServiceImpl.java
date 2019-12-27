package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.HuodongMapper;
import com.xiaofangtang.mapper.HuojiangMapper;
import com.xiaofangtang.model.Huojiang;
import com.xiaofangtang.service.HuojiangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class HuojiangServiceImpl implements HuojiangService {
    @Autowired
    private HuojiangMapper huojiangMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Huojiang gethuojiangByid(int id) {
        return huojiangMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Huojiang> gethuojiang() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Huojiang> list = (List<Huojiang>) redisTemplate.opsForValue().get("huojiangList");
        if (list==null){
            synchronized (this){
                list = (List<Huojiang>) redisTemplate.opsForValue().get("huojiangList");
                if (list==null){
                    list = huojiangMapper.gethuojiang();
                    redisTemplate.opsForValue().set("huojiangList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Huojiang> gethuojiangBystudent(int sid) {
        return huojiangMapper.gethuojiangBystudent(sid);
    }

    @Override
    public int inserthuojiang(Huojiang huojiang) {
        int i = huojiangMapper.insertSelective(huojiang);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huojiangList",huojiangMapper.gethuojiang());
        }
        return i;
    }

    @Override
    public int delhuojiang(int id) {
        int i = huojiangMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huojiangList",huojiangMapper.gethuojiang());
        }
        return i;
    }

    @Override
    public int uphuojiang(Huojiang huojiang) {
        int i = huojiangMapper.updateByPrimaryKeySelective(huojiang);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("huojiangList",huojiangMapper.gethuojiang());
        }
        return i;
    }
}
