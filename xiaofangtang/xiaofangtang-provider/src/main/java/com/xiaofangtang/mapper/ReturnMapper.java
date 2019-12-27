package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Return;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    List<Return> getreturn();
}