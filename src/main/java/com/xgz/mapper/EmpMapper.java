package com.xgz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xgz.entity.Emp;
import com.xgz.entity.dto.PasswordDto;
import org.apache.ibatis.annotations.Update;

public interface EmpMapper extends BaseMapper<Emp> {

    @Update("update emp set password = #{newPassword} where empno = #{empno} and password = #{password}")
    int updatePassword(PasswordDto passwordDto);
}
