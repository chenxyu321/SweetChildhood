package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.QiandanMapper;
import com.xiaofangtang.model.Qiandan;
import com.xiaofangtang.service.QiandanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class QiandanServiceImpl implements QiandanService {
    @Autowired
    private QiandanMapper qiandanMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Qiandan getqiandanByid(int id) {
        return qiandanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Qiandan> getqiandan() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Qiandan> list = (List<Qiandan>) redisTemplate.opsForValue().get("qiandanList");
        if (list==null){
            synchronized (this){
                list = (List<Qiandan>) redisTemplate.opsForValue().get("qiandanList");
                if (list==null){
                    list = qiandanMapper.getqiandan();
                    redisTemplate.opsForValue().set("qiandanList",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertqiandan(Qiandan qiandan) {
        int i = qiandanMapper.insertSelective(qiandan);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("qiandanList",qiandanMapper.getqiandan());
        }
        return i;
    }

    @Override
    public int delqiandan(int id) {
        int i = qiandanMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("qiandanList",qiandanMapper.getqiandan());
        }
        return i;
    }

    @Override
    public int upqiandan(Qiandan qiandan) {
        int i = qiandanMapper.updateByPrimaryKeySelective(qiandan);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("qiandanList",qiandanMapper.getqiandan());
        }
        return i;
    }
}
