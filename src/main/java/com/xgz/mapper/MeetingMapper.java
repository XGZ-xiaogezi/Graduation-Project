package com.xgz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xgz.entity.Emp;
import com.xgz.entity.Meeting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetingMapper extends BaseMapper<Meeting> {

    List<Meeting> getMeetingsAndSendName(@Param("receive_id") String empno);

}
