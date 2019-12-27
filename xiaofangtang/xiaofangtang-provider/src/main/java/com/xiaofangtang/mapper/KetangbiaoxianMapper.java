package com.xiaofangtang.mapper;

import com.xiaofangtang.model.Ketangbiaoxian;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface KetangbiaoxianMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ketangbiaoxian record);

    int insertSelective(Ketangbiaoxian record);

    Ketangbiaoxian selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ketangbiaoxian record);

    int updateByPrimaryKey(Ketangbiaoxian record);

    List<Ketangbiaoxian> getketangbiaoxian();

    List<Ketangbiaoxian> getketangbiaoxianBystudent(int sid);

    List<Ketangbiaoxian> getketangbiaoxianBystudentandclass(int sid, String classes);

}