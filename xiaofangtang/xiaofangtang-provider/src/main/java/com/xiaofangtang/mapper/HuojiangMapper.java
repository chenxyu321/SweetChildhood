package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Huojiang;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface HuojiangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huojiang record);

    int insertSelective(Huojiang record);

    Huojiang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huojiang record);

    int updateByPrimaryKey(Huojiang record);

    List<Huojiang> gethuojiang();

    List<Huojiang> gethuojiangBystudent(int sid);
}