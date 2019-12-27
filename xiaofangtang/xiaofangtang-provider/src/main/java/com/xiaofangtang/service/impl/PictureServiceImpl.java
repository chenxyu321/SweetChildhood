package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.PictureMapper;
import com.xiaofangtang.model.Picture;
import com.xiaofangtang.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Picture getpictureByid(int id) {
        return pictureMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Picture> getpicture() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Picture> list = (List<Picture>) redisTemplate.opsForValue().get("pictureList");
        if (list==null){
            synchronized (this){
                list = (List<Picture>) redisTemplate.opsForValue().get("pictureList");
                if (list==null){
                    list = pictureMapper.getpicture();
                    redisTemplate.opsForValue().set("pictureList",list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Picture> getpictureByclass(String classes) {
        return pictureMapper.getpictureByclass(classes);
    }

    @Override
    public int insertpicture(Picture picture) {
        int i = pictureMapper.insertSelective(picture);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("pictureList",pictureMapper.getpicture());
        }
        return i;
    }

    @Override
    public int delpicture(int id) {
        int i = pictureMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("pictureList",pictureMapper.getpicture());
        }
        return i;
    }

    @Override
    public int uppicture(Picture picture) {
        int i = pictureMapper.updateByPrimaryKeySelective(picture);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("pictureList",pictureMapper.getpicture());
        }
        return i;
    }
}
