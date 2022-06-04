package com.xgz.entity.dto;

import lombok.Data;

/**
 * 前端登录辅助类
 */
@Data
public class EmpDto {
    private String ename;
    private String empno;
    private String password;
    private String avatarUrl;
    private String deptno;
    private String token;
    private String role;
}
