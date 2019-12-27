package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Huodong;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface HuodongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huodong record);

    int insertSelective(Huodong record);

    Huodong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huodong record);

    int updateByPrimaryKey(Huodong record);

    List<Huodong> gethuodong();

    List<Huodong> gethuodongBystudent(int id);
}