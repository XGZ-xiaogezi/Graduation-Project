package com.xgz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgz.entity.Notice;
import com.xgz.mapper.NoticeMapper;
import com.xgz.service.NoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
}
