package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Systongzhi;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SystongzhiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Systongzhi record);

    int insertSelective(Systongzhi record);

    Systongzhi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Systongzhi record);

    int updateByPrimaryKey(Systongzhi record);

    List<Systongzhi> getsystongzhi();
}