package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Active;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ActiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Active record);

    int insertSelective(Active record);

    Active selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Active record);

    int updateByPrimaryKey(Active record);

    List<Active> getactive();

    List<Active> getactiveByopen();

}