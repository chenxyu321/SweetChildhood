package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.KetangbiaoxianMapper;
import com.xiaofangtang.model.Ketangbiaoxian;
import com.xiaofangtang.service.KetangbiaoxianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class KetangbiaoxianServiceImpl implements KetangbiaoxianService {
    @Autowired
    private KetangbiaoxianMapper ketangbiaoxianMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Ketangbiaoxian getketangbiaoxianByid(int id) {
        return ketangbiaoxianMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ketangbiaoxian> getketangbiaoxian() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Ketangbiaoxian> list = (List<Ketangbiaoxian>) redisTemplate.opsForValue().get("ketangbiaoxianList");
        if (list==null){
            synchronized (this){
                list = (List<Ketangbiaoxian>) redisTemplate.opsForValue().get("ketangbiaoxianList");
                if (list==null){
                    list = ketangbiaoxianMapper.getketangbiaoxian();
                    redisTemplate.opsForValue().set("ketangbiaoxianList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Ketangbiaoxian> getketangbiaoxianBystudent(int sid) {
        return ketangbiaoxianMapper.getketangbiaoxianBystudent(sid);
    }

    @Override
    public List<Ketangbiaoxian> getketangbiaoxianBystudentandclass(int sid, String classes) {
        return ketangbiaoxianMapper.getketangbiaoxianBystudentandclass(sid,classes);
    }

    @Override
    public int insertketangbiaoxian(Ketangbiaoxian ketangbiaoxian) {
        int i = ketangbiaoxianMapper.insertSelective(ketangbiaoxian);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("ketangbiaoxianList",ketangbiaoxianMapper.getketangbiaoxian());
        }
        return i;
    }

    @Override
    public int delketangbiaoxian(int id) {
        int i = ketangbiaoxianMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("ketangbiaoxianList",ketangbiaoxianMapper.getketangbiaoxian());
        }
        return i;
    }

    @Override
    public int upketangbiaoxian(Ketangbiaoxian ketangbiaoxian) {
        int i = ketangbiaoxianMapper.updateByPrimaryKeySelective(ketangbiaoxian);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("ketangbiaoxianList",ketangbiaoxianMapper.getketangbiaoxian());
        }
        return i;
    }
}
