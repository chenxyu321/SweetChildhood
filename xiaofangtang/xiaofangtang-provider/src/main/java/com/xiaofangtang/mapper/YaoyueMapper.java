package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Yaoyue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface YaoyueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yaoyue record);

    int insertSelective(Yaoyue record);

    Yaoyue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yaoyue record);

    int updateByPrimaryKey(Yaoyue record);

    List<Yaoyue> getyaoyue();

    List<Yaoyue> getyaoyueByteacher(String teacher);
}