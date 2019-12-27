package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Chengguophoto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ChengguophotoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chengguophoto record);

    int insertSelective(Chengguophoto record);

    Chengguophoto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chengguophoto record);

    int updateByPrimaryKey(Chengguophoto record);

    List<Chengguophoto> getchengguophoto();

    public List<Chengguophoto> getchengguophotoBychengguo(String chengguoid);
}