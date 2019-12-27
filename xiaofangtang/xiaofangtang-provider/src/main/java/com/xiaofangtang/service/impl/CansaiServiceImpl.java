package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.CansaiMapper;
import com.xiaofangtang.model.Cansai;
import com.xiaofangtang.service.CansaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class CansaiServiceImpl implements CansaiService {

    @Autowired
    private CansaiMapper cansaiMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Cansai getcansaiByid(int id) {
        return cansaiMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Cansai> getcansai() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Cansai> list = (List<Cansai>) redisTemplate.opsForValue().get("cansaiList");
        if (list==null){
            synchronized (this){
                list = (List<Cansai>) redisTemplate.opsForValue().get("cansaiList");
                if (list==null){
                    list = cansaiMapper.getcansai();
                    redisTemplate.opsForValue().set("cansaiList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Cansai> getcansaiBystudent(int sid) {
        return cansaiMapper.getcansaiBystudent(sid);
    }

    @Override
    public int insertcansai(Cansai cansai) {
        int i = cansaiMapper.insertSelective(cansai);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("cansaiList",cansaiMapper.getcansai());
        }
        return i;
    }

    @Override
    public int delcansai(int id) {
        int i = cansaiMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("cansaiList",cansaiMapper.getcansai());
        }
        return i;
    }

    @Override
    public int upcansai(Cansai cansai) {
        int i = cansaiMapper.updateByPrimaryKey(cansai);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("cansaiList",cansaiMapper.getcansai());
        }
        return i;
    }
}
