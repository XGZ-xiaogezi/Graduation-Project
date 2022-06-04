package com.xgz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgz.entity.Meeting;
import com.xgz.mapper.MeetingMapper;
import com.xgz.service.MeetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, Meeting> implements MeetingService {

    @Resource
    private MeetingMapper meetingMapper;

    @Override
    public List<Meeting> getMeetingsAndSendName(String empno) {
        return meetingMapper.getMeetingsAndSendName(empno);
    }
}
