package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Shangke;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ShangkeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shangke record);

    int insertSelective(Shangke record);

    Shangke selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shangke record);

    int updateByPrimaryKey(Shangke record);

    List<Shangke> getshangke();

    List<Shangke> getshangkeBystudent(int id);
}