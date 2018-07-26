DROP DATABASE if exists `backgroundmanage`;
CREATE DATABASE backgroundmanage;
USE backgroundmanage;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alerts
-- ----------------------------
DROP TABLE IF EXISTS `alerts`;
CREATE TABLE `alerts`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `point` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '点位',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '联系类型(1.邮箱联系 2.短信联系)',
  `rank` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '报警等级(1.一般 10.严重 100.紧急)',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alerts
-- ----------------------------
INSERT INTO `alerts` VALUES (1, 'd245', '171378535@qq.com', '1', '1', '1808822922', 'ffhg');
INSERT INTO `alerts` VALUES (2, 'd245', '17612715250', '2', '1', '1808822922', 'hkjhht');
INSERT INTO `alerts` VALUES (3, 'd245', '17666543351', '2', '1', '1808822922', 'uuk');
INSERT INTO `alerts` VALUES (5, 'M0', '15956587446@qq.com', '1', '10', '15556871457', 'sdfs');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `salerecord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (1, 'tom', '18326891234', 'abc', '上海', '027-874213', '大客户');
INSERT INTO `client` VALUES (2, 'jim', '15956581458', 'bcde', '北京', '027-874213', '小客户');
INSERT INTO `client` VALUES (3, 'zhoujielun', '12546892542', 'goods', '南京', '027-874212', '重要客户');
INSERT INTO `client` VALUES (5, 'hhjj', '18325681479', '25567', '武汉', '027-874213', '重要客户');
INSERT INTO `client` VALUES (6, 'hello', '14556782358', 'hellowords', '武汉', '027-874213', 'jjhj');
INSERT INTO `client` VALUES (8, 'xiamingjun', '18326891255', 'helloo', '合肥', '027-874213', '12');
INSERT INTO `client` VALUES (9, 'daihang', '18525681254', 'jhgggg', '上海', '027-874213', '25');
INSERT INTO `client` VALUES (10, 'halibot', '12565871459', '4545', '合肥', '028-874213', 'aaa');

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DeviceId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DeviceName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for device_type
-- ----------------------------
DROP TABLE IF EXISTS `device_type`;
CREATE TABLE `device_type`  (
  `TypeId` bigint(20) NOT NULL COMMENT '设备类型id',
  `TypeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备类型名称',
  `TypeDescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备类型描述',
  `TypeDBName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备类型对应数据表名',
  `TypeTableName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DBIP` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `type_db_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type_table_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_type
-- ----------------------------
INSERT INTO `device_type` VALUES (1, 'GYRXJ', '高压绕线机', 'dlkdata', 'dlk', '192.168.0.113', '', NULL, NULL, NULL, NULL, 5);
INSERT INTO `device_type` VALUES (3, 'asdf', 'asdf', 'asdf', 'adsf', 'adsf', '', NULL, NULL, NULL, NULL, 6);
INSERT INTO `device_type` VALUES (4, 'fff', 'ddd', 'ddd', 'dddd', 'dddd', '', NULL, NULL, NULL, NULL, 7);

-- ----------------------------
-- Table structure for factory
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FactoryId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `FactoryName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `FactoryUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of factory
-- ----------------------------
INSERT INTO `factory` VALUES (1, '1000', 'dlk', '192.168.1.100:8080/dlk/index.htm');

-- ----------------------------
-- Table structure for factroy_device
-- ----------------------------
DROP TABLE IF EXISTS `factroy_device`;
CREATE TABLE `factroy_device`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FactoryId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DeviceId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);
INSERT INTO `hibernate_sequence` VALUES (1);
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for plane
-- ----------------------------
DROP TABLE IF EXISTS `plane`;
CREATE TABLE `plane`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `plane_url` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `factory_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plane
-- ----------------------------
INSERT INTO `plane` VALUES (1, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531896216249&di=bb3b7c2cb59deac78e0963d549b976de&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fc2cec3fdfc0392452beb1eb08194a4c27d1e2537.jpg', '1');

-- ----------------------------
-- Table structure for point
-- ----------------------------
DROP TABLE IF EXISTS `point`;
CREATE TABLE `point`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '0| url热点操作\r\n1| 其他操作',
  `point` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of point
-- ----------------------------
INSERT INTO `point` VALUES (1, '10,20', '0');

-- ----------------------------
-- Table structure for resource_manage
-- ----------------------------
DROP TABLE IF EXISTS `resource_manage`;
CREATE TABLE `resource_manage`  (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ParentId` bigint(20) DEFAULT NULL,
  `Url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Time` datetime(0) DEFAULT NULL,
  `Index` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Level` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_manage
-- ----------------------------
INSERT INTO `resource_manage` VALUES (1, 0, 'http://www.baidu.com', '0', '厂区总览', '2018-07-17 17:15:57', '1', 1);
INSERT INTO `resource_manage` VALUES (2, 0, 'http://www.baidu.com', '0', '设备总览', '2018-07-16 17:16:24', '2', 1);
INSERT INTO `resource_manage` VALUES (3, 2, 'http://www.baidu.com', '0', '设备运行状态', '2018-07-18 10:16:27', '1', 2);
INSERT INTO `resource_manage` VALUES (4, 2, 'http://www.baidu.com', '0', '刀具管理', '2018-07-18 14:29:54', '2', 2);
INSERT INTO `resource_manage` VALUES (5, 2, 'http://www.baidu.com', '0', '能耗管理', '2018-07-18 14:30:20', '3', 2);
INSERT INTO `resource_manage` VALUES (6, 2, 'http://www.baidu.com', '0', '设备OEE', '2018-07-18 14:30:49', '4', 2);
INSERT INTO `resource_manage` VALUES (7, 2, 'http://www.baidu.com', '0', '数据录入', '2018-07-18 14:31:07', '5', 2);
INSERT INTO `resource_manage` VALUES (8, 0, 'http://www.baidu.com', '0', '数据采集', '2018-07-18 14:31:42', '3', 1);
INSERT INTO `resource_manage` VALUES (9, 8, 'http://www.baidu.com', '0', '设备类型管理', '2018-07-18 14:32:14', '1', 2);
INSERT INTO `resource_manage` VALUES (10, 8, 'http://www.baidu.com', '0', '设备厂商管理', '2018-07-18 14:32:35', '2', 2);
INSERT INTO `resource_manage` VALUES (11, 8, 'http://www.baidu.com', '0', '设备区域管理', '2018-07-18 14:32:58', '3', 2);
INSERT INTO `resource_manage` VALUES (12, 8, 'http://www.baidu.com', '0', '设备管理', '2018-07-18 14:33:16', '4', 2);
INSERT INTO `resource_manage` VALUES (13, 0, 'http://www.baidu.com', '0', '系统管理', '2018-07-18 14:33:59', '4', 1);
INSERT INTO `resource_manage` VALUES (14, 13, 'http://www.baidu.com', '0', '资源管理', '2018-07-18 14:34:26', '1', 2);
INSERT INTO `resource_manage` VALUES (15, 13, 'http://www.baidu.com', '0', '模块管理', '2018-07-18 14:34:45', '2', 2);
INSERT INTO `resource_manage` VALUES (16, 13, 'http://www.baidu.com', '0', '用户管理', '2018-07-18 14:35:05', '3', 2);
INSERT INTO `resource_manage` VALUES (17, 13, 'http://www.baidu.com', '0', '日志管理', '2018-07-18 14:35:19', '4', 2);
INSERT INTO `resource_manage` VALUES (18, 14, 'http://www.baidu.com', '0', 'ff', '2018-07-18 16:16:23', '1', 3);

-- ----------------------------
-- Table structure for s_resource
-- ----------------------------
DROP TABLE IF EXISTS `s_resource`;
CREATE TABLE `s_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `resourceid` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `resourcename` varchar(400) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `resourcestring` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `resourceurl` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_resource
-- ----------------------------
INSERT INTO `s_resource` VALUES (1, NULL, NULL, 'ROLE_ADMIN', NULL, 'http://192.168.0.100:8080/dlk/138888888888/index.do');
INSERT INTO `s_resource` VALUES (2, NULL, NULL, 'ROLE_USER', NULL, NULL);

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES (1, 'ADMIN');
INSERT INTO `s_role` VALUES (2, 'USER');

-- ----------------------------
-- Table structure for s_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `s_role_resource`;
CREATE TABLE `s_role_resource`  (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `rosource_id` int(11) NOT NULL,
  INDEX `FKern811dk7e5488wd9ts174t67`(`resource_id`) USING BTREE,
  INDEX `FKiqucll5kq6g7y2ee0phjs4bgs`(`rosource_id`) USING BTREE,
  INDEX `FKrnsx549if8qsvj3khsja0tylu`(`role_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of s_role_resource
-- ----------------------------
INSERT INTO `s_role_resource` VALUES (1, 1, 0);
INSERT INTO `s_role_resource` VALUES (2, 2, 0);

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` date DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `factory_id` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES (1, NULL, NULL, NULL, NULL, 'admin', 'admin');
INSERT INTO `s_user` VALUES (2, NULL, NULL, NULL, NULL, 'shiyue', 'shiyue');

-- ----------------------------
-- Table structure for s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  INDEX `FKmi8o2ld5s3di95yfp7hwmlvab`(`role_id`) USING BTREE,
  INDEX `FK73hg6eioqf8til8u4luq2hu76`(`user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES (1, 1);
INSERT INTO `s_user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for sales
-- ----------------------------
DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `equipment_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `client_id` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sales
-- ----------------------------
INSERT INTO `sales` VALUES (1, 'gaoyaraoxianji', '21156', '高压绕线机', '02', '迪镭凯生产');
INSERT INTO `sales` VALUES (2, 'agv', '25858', '智能小车', '03', 'bb');
INSERT INTO `sales` VALUES (4, 'jixiebi', '25554', '机械臂', '05', 'cc');

-- ----------------------------
-- Table structure for taizhang
-- ----------------------------
DROP TABLE IF EXISTS `taizhang`;
CREATE TABLE `taizhang`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `equipment_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `control_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `responsible` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `protect_cycle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `equipment_vendor` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `current_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1表示可在前端页面展示，0表示不可以',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of taizhang
-- ----------------------------
INSERT INTO `taizhang` VALUES (1, 'tom', 'hjjj', 'dcsd', '2017', 'A', 'jay', '46', 'dlk', '运转', '1', 'gg');
INSERT INTO `taizhang` VALUES (2, 'jack', 'gffd', 'fgfggf', '2016', 'B', 'adas', '58', 'sdff', '停止', '1', 'ttttt');
INSERT INTO `taizhang` VALUES (4, 'hhh', 'dlks', 'jjhj', '2015', 'C', 'hello', '58', 'kkjf', '停止', '1', 'hh');
INSERT INTO `taizhang` VALUES (5, 'hgghhg', 'dd', 'sddd', '2014', 'D', 'tred', '69', 'dcv', '停止', '0', 'frg');
INSERT INTO `taizhang` VALUES (6, 'sd', 'fsd', 'sdfsfd', 'gfg', 'fdfg', 'gd', 'fdg', 'dff', 'df', '0', 'gf');

-- ----------------------------
-- Table structure for user_factory
-- ----------------------------
DROP TABLE IF EXISTS `user_factory`;
CREATE TABLE `user_factory`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `FactoryId` varchar(0) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `UserId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
