package com.xiaofangtang.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofangtang.model.Picture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public interface PictureService {
    Picture getpictureByid(int id);
    List<Picture> getpicture();
    List<Picture> getpictureByclass(String classes);
    int insertpicture(Picture picture);
    int delpicture(int id);
    int uppicture(Picture picture);
}
