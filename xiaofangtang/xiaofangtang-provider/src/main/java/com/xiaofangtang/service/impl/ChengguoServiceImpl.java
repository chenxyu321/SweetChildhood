package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.ChengguoMapper;
import com.xiaofangtang.model.Chengguo;
import com.xiaofangtang.service.ChengguoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class ChengguoServiceImpl implements ChengguoService {
    @Autowired
    private ChengguoMapper chengguoMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Chengguo getchengguoByid(int id) {
        return chengguoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Chengguo> getchengguo() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Chengguo> list = (List<Chengguo>) redisTemplate.opsForValue().get("chengguoList");
        if (list==null){
            synchronized (this){
                list = (List<Chengguo>) redisTemplate.opsForValue().get("chengguoList");
                if (list==null){
                    list = chengguoMapper.getchengguo();
                    redisTemplate.opsForValue().set("chengguoList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Chengguo> getchengguoBystudent(int sid) {
        return chengguoMapper.getchengguoBystudent(sid);
    }

    @Override
    public int insertchengguo(Chengguo chengguo) {
        int i = chengguoMapper.insertSelective(chengguo);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengguoList",chengguoMapper.getchengguo());
        }
        return i;
    }

    @Override
    public int delchengguo(int id) {
        int i = chengguoMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengguoList",chengguoMapper.getchengguo());
        }
        return i;
    }

    @Override
    public int upchengguo(Chengguo chengguo) {
        int i = chengguoMapper.updateByPrimaryKeySelective(chengguo);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("chengguoList",chengguoMapper.getchengguo());
        }
        return i;
    }
}
