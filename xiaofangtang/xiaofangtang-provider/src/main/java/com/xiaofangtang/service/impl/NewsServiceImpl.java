package com.xiaofangtang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.mapper.NewsMapper;
import com.xiaofangtang.model.News;
import com.xiaofangtang.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public News getnewsByid(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<News> getnews() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<News> list = (List<News>) redisTemplate.opsForValue().get("newsList");
        if (list==null){
            synchronized (this){
                list = (List<News>) redisTemplate.opsForValue().get("newsList");
                if (list==null){
                    list = newsMapper.getnews();
                    redisTemplate.opsForValue().set("newsList",list);
                }
            }
        }
        return list;
    }

    @Override
    public int insertnews(News news) {
        int i = newsMapper.insertSelective(news);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("newsList",newsMapper.getnews());
        }
        return i;
    }

    @Override
    public int delnews(int id) {
        int i = newsMapper.deleteByPrimaryKey(id);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("newsList",newsMapper.getnews());
        }
        return i;
    }

    @Override
    public int upnews(News news) {
        int i = newsMapper.updateByPrimaryKeySelective(news);
        if (i!=0){
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForValue().set("newsList",newsMapper.getnews());
        }
        return i;
    }
}
