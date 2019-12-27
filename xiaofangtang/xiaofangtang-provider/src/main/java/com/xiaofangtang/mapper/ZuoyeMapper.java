package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Zuoye;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ZuoyeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zuoye record);

    int insertSelective(Zuoye record);

    Zuoye selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zuoye record);

    int updateByPrimaryKey(Zuoye record);

    List<Zuoye> getzuoye();

    List<Zuoye> getzuoyeBystudent(int sid);
}