package com.xgz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xgz.entity.Dk;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DkMapper extends BaseMapper<Dk> {

    @Select("select * from dk where empno = #{empno}")
    List<Dk> selectByEmpnoDk(@Param("empno") String empno);
}
