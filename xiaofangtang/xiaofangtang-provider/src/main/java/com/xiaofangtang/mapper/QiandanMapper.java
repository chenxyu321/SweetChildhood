package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Qiandan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QiandanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qiandan record);

    int insertSelective(Qiandan record);

    Qiandan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qiandan record);

    int updateByPrimaryKey(Qiandan record);

    List<Qiandan> getqiandan();
}