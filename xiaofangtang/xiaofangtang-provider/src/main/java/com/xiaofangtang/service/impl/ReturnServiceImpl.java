package com.xiaofangtang.service.impl;

import com.xiaofangtang.mapper.ReturnMapper;
import com.xiaofangtang.model.Return;
import com.xiaofangtang.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnMapper returnMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Return getreturnByid(int id) {
        return returnMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Return> getreturn() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Return> list = (List<Return>) redisTemplate.opsForValue().get("returnList");
        if (list==null){
            synchronized (this){
                list = (List<Return>) redisTemplate.opsForValue().get("returnList");
                if (list==null){
                    list = returnMapper.getreturn();
                    redisTemplate.opsForValue().set("returnList",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertreturn(Return re) {
        int i = returnMapper.insertSelective(re);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("returnList",returnMapper.getreturn());
        }
        return i;
    }

    @Override
    public int delreturn(int id) {
        int i = returnMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("returnList",returnMapper.getreturn());
        }
        return i;
    }

    @Override
    public int upreturn(Return re) {
        int i = returnMapper.updateByPrimaryKeySelective(re);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("returnList",returnMapper.getreturn());
        }
        return i;
    }
}
