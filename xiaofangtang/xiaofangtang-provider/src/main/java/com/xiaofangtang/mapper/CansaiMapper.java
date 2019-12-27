package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Cansai;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CansaiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cansai record);

    int insertSelective(Cansai record);

    Cansai selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cansai record);

    int updateByPrimaryKey(Cansai record);

    List<Cansai> getcansai();

    List<Cansai> getcansaiBystudent(int sid);
}