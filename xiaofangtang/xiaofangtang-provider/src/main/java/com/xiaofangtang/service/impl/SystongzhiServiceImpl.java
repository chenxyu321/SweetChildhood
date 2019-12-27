package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.SystongzhiMapper;
import com.xiaofangtang.model.Systongzhi;
import com.xiaofangtang.service.SystongzhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class SystongzhiServiceImpl implements SystongzhiService {
    @Autowired
    private SystongzhiMapper systongzhiMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Systongzhi getsystongzhiByid(int id) {
        return systongzhiMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Systongzhi> getsystongzhi() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Systongzhi> list = (List<Systongzhi>) redisTemplate.opsForValue().get("systongzhiList");
        if (list==null){
            synchronized (this){
                list = (List<Systongzhi>) redisTemplate.opsForValue().get("systongzhiList");
                if (list==null){
                    list = systongzhiMapper.getsystongzhi();
                    redisTemplate.opsForValue().set("systongzhiList",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertsystongzhi(Systongzhi systongzhi) {
        int i = systongzhiMapper.updateByPrimaryKeySelective(systongzhi);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("systongzhiList",systongzhiMapper.getsystongzhi());
        }
        return i;
    }


    @Override
    public int delsystongzhi(int id) {
        int i = systongzhiMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("systongzhiList",systongzhiMapper.getsystongzhi());
        }
        return i;
    }


    @Override
    public int upsystongzhi(Systongzhi systongzhi) {
        int i = systongzhiMapper.updateByPrimaryKeySelective(systongzhi);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("systongzhiList",systongzhiMapper.getsystongzhi());
        }
        return i;
    }
}
