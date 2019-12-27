package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PictureMapper {
    int deleteByPrimaryKey(Integer picid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer picid);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

    List<Picture> getpicture();

    List<Picture> getpictureByclass(String classes);
}