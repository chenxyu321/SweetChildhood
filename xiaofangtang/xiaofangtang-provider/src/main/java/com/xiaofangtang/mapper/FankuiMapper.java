package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Fankui;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FankuiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fankui record);

    int insertSelective(Fankui record);

    Fankui selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fankui record);

    int updateByPrimaryKey(Fankui record);

    List<Fankui> getfankui();
}