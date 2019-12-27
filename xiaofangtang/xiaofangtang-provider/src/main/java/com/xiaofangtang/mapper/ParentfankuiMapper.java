package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Parentfankui;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ParentfankuiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parentfankui record);

    int insertSelective(Parentfankui record);

    Parentfankui selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parentfankui record);

    int updateByPrimaryKey(Parentfankui record);

    List<Parentfankui> getparentfankui();
}