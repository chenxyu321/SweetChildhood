package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.News;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface NewsService {
    News getnewsByid(int id);
    List<News> getnews();
    int insertnews(News news);
    int delnews(int id);
    int upnews(News news);
}
