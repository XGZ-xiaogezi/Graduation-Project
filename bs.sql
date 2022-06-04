/*
 Navicat Premium Data Transfer

 Source Server         : local host
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : bs

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 04/06/2022 09:18:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门编号',
  `dname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门名称',
  `loc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门地点',
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('00', '管理部', '总公司');
INSERT INTO `dept` VALUES ('01', '销售部', '葫芦岛大区');
INSERT INTO `dept` VALUES ('02', '研发部', '南京');
INSERT INTO `dept` VALUES ('03', '财务部', '上海');
INSERT INTO `dept` VALUES ('04', '测试部', '沈阳');

-- ----------------------------
-- Table structure for dk
-- ----------------------------
DROP TABLE IF EXISTS `dk`;
CREATE TABLE `dk`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `empno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '员工编号',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '上班打卡',
  `status` int NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dk
-- ----------------------------
INSERT INTO `dk` VALUES (1, '0', '2022-03-18 08:52:26', 1);
INSERT INTO `dk` VALUES (2, '0', '2022-03-17 21:25:06', 1);
INSERT INTO `dk` VALUES (3, '0', '2022-03-16 01:25:29', 0);
INSERT INTO `dk` VALUES (4, '0', '2022-03-20 21:23:22', 1);
INSERT INTO `dk` VALUES (7, '0', '2022-03-21 13:45:12', 1);
INSERT INTO `dk` VALUES (8, '0', '2022-03-22 07:51:06', 1);
INSERT INTO `dk` VALUES (9, '0', '2022-03-28 08:28:05', 1);
INSERT INTO `dk` VALUES (10, '0', '2022-03-29 19:46:44', 1);
INSERT INTO `dk` VALUES (11, '0', '2022-04-05 09:00:37', 1);
INSERT INTO `dk` VALUES (12, '0', '2022-04-06 08:54:13', 1);
INSERT INTO `dk` VALUES (13, '0', '2022-04-11 09:01:44', 1);
INSERT INTO `dk` VALUES (14, '0', '2022-04-12 08:29:35', 1);
INSERT INTO `dk` VALUES (15, '0', '2022-04-14 09:00:14', 1);
INSERT INTO `dk` VALUES (16, '0', '2022-04-15 19:12:28', 1);
INSERT INTO `dk` VALUES (17, '0', '2022-04-18 09:31:09', 1);
INSERT INTO `dk` VALUES (18, '0', '2022-04-19 11:06:55', 1);
INSERT INTO `dk` VALUES (19, '0', '2022-04-23 18:48:24', 1);
INSERT INTO `dk` VALUES (20, '0', '2022-04-25 08:58:43', 1);
INSERT INTO `dk` VALUES (21, '0', '2022-04-27 08:23:01', 1);
INSERT INTO `dk` VALUES (22, '0', '2022-04-28 19:46:36', 1);
INSERT INTO `dk` VALUES (23, '0', '2022-04-29 11:13:45', 1);
INSERT INTO `dk` VALUES (24, '0', '2022-05-01 09:30:05', 1);
INSERT INTO `dk` VALUES (25, '0', '2022-05-02 19:45:16', 1);
INSERT INTO `dk` VALUES (26, '0', '2022-05-09 15:13:21', 1);
INSERT INTO `dk` VALUES (27, '0', '2022-05-10 14:51:24', 1);
INSERT INTO `dk` VALUES (28, '0', '2022-05-12 20:41:09', 1);
INSERT INTO `dk` VALUES (29, '0', '2022-05-13 07:41:52', 1);
INSERT INTO `dk` VALUES (30, '0', '2022-05-14 07:26:26', 1);
INSERT INTO `dk` VALUES (31, '10086', '2022-05-14 07:51:46', 1);
INSERT INTO `dk` VALUES (32, '0101', '2022-05-14 08:55:11', 1);
INSERT INTO `dk` VALUES (33, '0', '2022-05-16 18:07:30', 1);
INSERT INTO `dk` VALUES (34, '0', '2022-05-17 21:12:26', 1);
INSERT INTO `dk` VALUES (35, '0', '2022-05-18 14:07:20', 1);
INSERT INTO `dk` VALUES (36, '0', '2022-05-23 12:23:06', 1);
INSERT INTO `dk` VALUES (37, '0103', '2022-05-23 13:25:18', 1);
INSERT INTO `dk` VALUES (38, '0202', '2022-05-23 21:25:09', 1);
INSERT INTO `dk` VALUES (39, '0101', '2022-05-23 21:33:16', 1);
INSERT INTO `dk` VALUES (40, '0201', '2022-05-23 21:33:52', 1);
INSERT INTO `dk` VALUES (41, '0000', '2022-05-23 21:40:02', 1);
INSERT INTO `dk` VALUES (42, '0303', '2022-05-23 21:40:51', 1);
INSERT INTO `dk` VALUES (43, '0301', '2022-05-23 21:41:58', 1);
INSERT INTO `dk` VALUES (44, '0000', '2022-05-24 06:51:39', 1);
INSERT INTO `dk` VALUES (45, '0000', '2022-05-31 08:27:54', 1);
INSERT INTO `dk` VALUES (46, '0202', '2022-05-31 08:33:00', 1);
INSERT INTO `dk` VALUES (47, '0101', '2022-05-31 15:02:16', 1);
INSERT INTO `dk` VALUES (48, '0102', '2022-06-01 15:37:19', 1);
INSERT INTO `dk` VALUES (49, '0000', '2022-06-02 18:55:19', 1);

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公文是由',
  `ename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发起人姓名',
  `status_mgr` int NULL DEFAULT NULL COMMENT '领导审核状态',
  `status_admin` int NULL DEFAULT NULL COMMENT '高层审核状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deptno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门编号',
  `doc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公文名',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件类型',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '下载链接',
  `size` bigint NULL DEFAULT NULL COMMENT '文件大小kb',
  `md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'md5',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES (1, '线上线下培训说明', '研发部员工1', 1, 0, '2022-05-23 21:36:15', '02', '远程和线下培训说明.doc', 'doc', 'http://localhost:9090/doc/0c058cb9be5747f6856903a19050466a.doc', 6673, '27574c0de9f30c96689a650e2e93eb00');
INSERT INTO `document` VALUES (2, '考试一信息', '研发部员工1', 0, 0, '2022-05-23 21:37:45', '02', '考试一.md', 'md', 'http://localhost:9090/doc/363f920c4f444cc78b18c03cd32446b8.md', 8, '4866ea8484022543517862e52ffd74b1');
INSERT INTO `document` VALUES (3, '线上线下培训说明', '销售部员工1', 0, 0, '2022-06-01 07:32:35', '01', '远程和线下培训说明.doc', 'doc', 'http://localhost:9090/doc/0c058cb9be5747f6856903a19050466a.doc', 6673, '27574c0de9f30c96689a650e2e93eb00');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `empno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '员工编号',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职位',
  `sal` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工资',
  `mgr` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '领导编号',
  `deptno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门编号',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `role` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, '周佳森', '0000', '男', 23, '123456', '管理员', '9999', NULL, '00', 'https://img.gejiba.com/images/56093e6aeec7475f350fa5fb42f9c01f.jpg', 'ROLE_ADMIN', '2570079002@qq.com', '辽宁省鞍山市台安县新开河镇');
INSERT INTO `emp` VALUES (2, '高层1', '0001', '男', 23, '123456', '架构师', '15000', NULL, '00', NULL, 'ROLE_ADMIN', '2570079002@qq.com', '辽宁省鞍山市台安县新开河镇');
INSERT INTO `emp` VALUES (3, '高层2', '0002', '女', 22, '123456', '架构师', '15000', NULL, '00', NULL, 'ROLE_ADMIN', '2570079002@163.com', '辽宁省葫芦岛市龙湾大街188号');
INSERT INTO `emp` VALUES (4, '销售部领导', '0101', '男', 25, '123456', '销售管理', '18000', '', '01', NULL, 'ROLE_MGR', '2570079002@gmail.com', '江苏省南京市怡化中心A座');
INSERT INTO `emp` VALUES (5, '销售部员工1', '0102', '女', 24, '123456', '售前工程师', '9000', '0101', '01', NULL, 'ROLE_EMP', '2570079002@163.com', '江苏省南京市怡化中心A座');
INSERT INTO `emp` VALUES (6, '销售部员工2', '0103', '男', 25, '123456', '售后工程师', '12000', '0101', '01', NULL, 'ROLE_EMP', '2570079002@outlook.com', '江苏省南京市怡化中心A座');
INSERT INTO `emp` VALUES (7, '研发部领导', '0201', '男', 35, '123456', 'Java开发工程师', '20000', NULL, '02', NULL, 'ROLE_MGR', '2570079002@firfox.com', '辽宁省盘锦市兴隆台区');
INSERT INTO `emp` VALUES (8, '研发部员工1', '0202', '男', 28, '123456', 'C开发工程师', '13000', '0201', '02', 'http://localhost:9090/file/7ee1d4988a414a21914c2096586daa1a.jpg', 'ROLE_EMP', '2570079002@88.com', '辽宁省盘锦市兴隆台区');
INSERT INTO `emp` VALUES (9, '研发部员工2', '0203', '女', 18, '123456', '.net开发工程师', '9000', '0201', '02', NULL, 'ROLE_EMP', '2570079002@126.com', '辽宁省盘锦市兴隆台区');
INSERT INTO `emp` VALUES (10, '财务部领导', '0301', '女', 36, '123456', '财务部领导', '15000', NULL, '03', NULL, 'ROLE_MGR', '2570079002@qqicom', '辽宁省盘锦市双台子区');
INSERT INTO `emp` VALUES (11, '财务部员工1', '0302', '女', 22, '123456', '会计', '10000', '0301', '03', NULL, 'ROLE_EMP', '2570079002@gmail.com', '辽宁省盘锦市双台子区');
INSERT INTO `emp` VALUES (12, '财务部员工2', '0303', '女', 26, '123456', '会计', '8000', '0301', '03', 'http://localhost:9090/file/d758cc4e3fd6479fa9b6585e10e8f970.jpg', 'ROLE_EMP', '2570079002@163.com', '辽宁省盘锦市双台子区');
INSERT INTO `emp` VALUES (13, '测试部领导', '0401', '女', 27, '123456', '高级测试工程师', '15000', NULL, '04', NULL, 'ROLE_MGR', '2570079002@126.com', '辽宁省盘锦市盘山县');
INSERT INTO `emp` VALUES (14, '测试部员工1', '0402', '女', 26, '123456', '初级测试工程师', '9000', '0401', '04', NULL, 'ROLE_EMP', '2570079002@gmail.com', '辽宁省盘锦市盘山县');

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件类型',
  `size` bigint NULL DEFAULT NULL COMMENT '文件大小(kb)',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件md5',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `enable` tinyint(1) NULL DEFAULT 1 COMMENT '是否禁用链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES (1, '111.jpg', 'jpg', 38, 'http://localhost:9090/file/d758cc4e3fd6479fa9b6585e10e8f970.jpg', '2c2e71ece79292a0647445e0a3797dfd', 0, 1);
INSERT INTO `files` VALUES (2, 'QQ图片20190410213350.jpg', 'jpg', 60, 'http://localhost:9090/file/572fbf53671f43c082370872a0fad5cf.jpg', '35215ac46f2b0530f507f1d04089b6ee', 0, 1);
INSERT INTO `files` VALUES (3, 'AF组_实验报告模板.doc', 'doc', 14, 'http://localhost:9090/file/ef8b117c05d2437aa8ac58f83120058d.doc', '6a82bc65f273ff9670fc2a99e42c3420', 0, 1);
INSERT INTO `files` VALUES (4, '毕业.jpg', 'jpg', 35, 'http://localhost:9090/file/19d2fddcff224922b17777b8f3652da6.jpg', '84a486c5aab53e7d5d5ca784357ab342', 0, 1);
INSERT INTO `files` VALUES (5, 'QQ浏览器截图20200417072721.png', 'png', 47, 'http://localhost:9090/file/4fb9c49509994df48299a758622dbf70.png', '021a7b7226086b2a048924d0ba5eaff8', 0, 1);
INSERT INTO `files` VALUES (6, '0003134965238350.jpg', 'jpg', 12, 'http://localhost:9090/file/7ee1d4988a414a21914c2096586daa1a.jpg', '6eebac2e65f7e4c2a513ab1e30954900', 0, 1);
INSERT INTO `files` VALUES (7, '111.jpg', 'jpg', 38, 'http://localhost:9090/file/d758cc4e3fd6479fa9b6585e10e8f970.jpg', '2c2e71ece79292a0647445e0a3797dfd', 0, 1);

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会议主题',
  `loc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会议地点',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '会议时间',
  `send_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布人id',
  `receive_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '接收者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (1, '毕业动员大会', '尔雅201', '2022-05-25 09:03:10', '0301', '0301');
INSERT INTO `meeting` VALUES (2, '毕业动员大会', '尔雅201', '2022-05-25 09:03:10', '0301', '0302');
INSERT INTO `meeting` VALUES (3, '毕业动员大会', '尔雅201', '2022-05-25 09:03:10', '0301', '0303');
INSERT INTO `meeting` VALUES (4, '团会', '尔雅101', '2022-06-01 14:31:18', '0101', '0101');
INSERT INTO `meeting` VALUES (5, '团会', '尔雅101', '2022-06-01 14:31:18', '0101', '0102');
INSERT INTO `meeting` VALUES (6, '团会', '尔雅101', '2022-06-01 14:31:18', '0101', '0103');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布时间',
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布人',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '封面',
  `type` int NULL DEFAULT NULL COMMENT '1-简单的公告，2富文本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '6.1-6.3毕业答辩事项', '<p>1.各学院通知学生尽快登录学信网核对毕业照片。请提醒学生如实核对照片，如照片错误，需携带相关身份证明材料到教务科进行更改；照片无错误时，任何情况都不可更改照片。</p><p>2.各学院将已交回的学历证书电子注册图像纸质版和电子版于毕业生照片花名册整理时交回教务处。待照片花名册整理完毕后，教务科将缺照片名单发各学院，学院需督促学生于6月1日前将照片交回。</p>', '2022-05-23 21:06:58', '周佳森', 'http://localhost:9090/file/19d2fddcff224922b17777b8f3652da6.jpg', 2);

-- ----------------------------
-- Table structure for qj
-- ----------------------------
DROP TABLE IF EXISTS `qj`;
CREATE TABLE `qj`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `empno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '员工编号',
  `ename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `deptno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门编号',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '具体描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '请假开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '请假结束时间',
  `is_abled` smallint NULL DEFAULT NULL COMMENT '是否审批 0审批中 1 不通过 2通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qj
-- ----------------------------
INSERT INTO `qj` VALUES (1, '0303', '财务部员工2', '03', '拔牙', '2022-05-24 00:00:00', '2022-05-24 00:00:00', 0);
INSERT INTO `qj` VALUES (2, '0303', '财务部员工2', '03', '看电影', '2022-05-25 00:00:00', '2022-05-26 00:00:00', 0);
INSERT INTO `qj` VALUES (3, '0102', '销售部员工1', '01', '拔牙', '2022-06-02 00:00:00', '2022-06-03 00:00:00', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL COMMENT 'id',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '公司高层', '公司高层', 'ROLE_ADMIN');
INSERT INTO `role` VALUES (2, '部门领导', '部门领导', 'ROLE_MGR');
INSERT INTO `role` VALUES (3, '普通员工', '普通员工', 'ROLE_EMP');

-- ----------------------------
-- Table structure for todo
-- ----------------------------
DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `last_time` datetime(0) NULL DEFAULT NULL COMMENT '截止时间',
  `create_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布人id',
  `receive_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '接收人id',
  `is_abled` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否完成 0工作中 1完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of todo
-- ----------------------------
INSERT INTO `todo` VALUES (1, '学习安卓SystemServer部分', '2022-05-24 08:05:00', '2022-05-26 00:00:00', '0301', '0301', '0');
INSERT INTO `todo` VALUES (2, '学习安卓SystemServer部分', '2022-05-24 08:05:00', '2022-05-26 00:00:00', '0301', '0302', '0');
INSERT INTO `todo` VALUES (3, '学习安卓SystemServer部分', '2022-05-24 08:05:00', '2022-05-26 00:00:00', '0301', '0303', '0');
INSERT INTO `todo` VALUES (4, '完成本周数据报表', '2022-06-01 09:00:00', '2022-06-01 18:30:28', '0101', '0101', '0');
INSERT INTO `todo` VALUES (5, '完成本周数据报表', '2022-06-01 09:00:00', '2022-06-01 18:30:28', '0101', '0102', '0');
INSERT INTO `todo` VALUES (6, '完成本周数据报表', '2022-06-01 09:00:00', '2022-06-01 18:30:28', '0101', '0103', '0');

SET FOREIGN_KEY_CHECKS = 1;
