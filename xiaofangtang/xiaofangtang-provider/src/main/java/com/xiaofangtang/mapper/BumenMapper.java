package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Bumen;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BumenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bumen record);

    int insertSelective(Bumen record);

    Bumen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bumen record);

    int updateByPrimaryKey(Bumen record);

    List<Bumen> getbumen();
}