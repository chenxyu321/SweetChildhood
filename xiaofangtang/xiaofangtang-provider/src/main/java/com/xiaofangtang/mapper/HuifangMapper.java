package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Huifang;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface HuifangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huifang record);

    int insertSelective(Huifang record);

    Huifang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huifang record);

    int updateByPrimaryKey(Huifang record);

    List<Huifang> gethuifang();

    List<Huifang> gethuifangByyaoyueid(int yid);
}