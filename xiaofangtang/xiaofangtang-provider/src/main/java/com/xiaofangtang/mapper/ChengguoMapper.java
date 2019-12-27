package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Chengguo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ChengguoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chengguo record);

    int insertSelective(Chengguo record);

    Chengguo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chengguo record);

    int updateByPrimaryKey(Chengguo record);

    List<Chengguo> getchengguo();

    List<Chengguo> getchengguoBystudent(int sid);
}