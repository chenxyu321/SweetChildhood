package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Ruxuetest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RuxuetestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ruxuetest record);

    int insertSelective(Ruxuetest record);

    Ruxuetest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ruxuetest record);

    int updateByPrimaryKey(Ruxuetest record);

    List<Ruxuetest> getruxuetest();

    List<Ruxuetest> getruxuetestBystudent(int sid);

    List<Ruxuetest> getruxuetestBystudentandclass(int sid, String classes);
}