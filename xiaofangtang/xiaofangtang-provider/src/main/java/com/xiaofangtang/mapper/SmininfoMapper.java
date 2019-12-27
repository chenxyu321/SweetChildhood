package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Smininfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SmininfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Smininfo record);

    int insertSelective(Smininfo record);

    Smininfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Smininfo record);

    int updateByPrimaryKey(Smininfo record);

    List<Smininfo> getsmininfo();

    List<Smininfo> getsmininfoBystudent(int sid);
}