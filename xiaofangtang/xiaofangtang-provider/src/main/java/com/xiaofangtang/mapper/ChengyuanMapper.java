package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Chengyuan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ChengyuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chengyuan record);

    int insertSelective(Chengyuan record);

    Chengyuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chengyuan record);

    int updateByPrimaryKey(Chengyuan record);

    List<Chengyuan> getchengyuan();

    List<Chengyuan> getchengyuanBystudent(int sid);
}