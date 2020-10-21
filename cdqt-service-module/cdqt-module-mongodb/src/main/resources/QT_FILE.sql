/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库(MySQL)
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 192.168.1.4:3306
 Source Schema         : cdqt

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 21/10/2020 23:41:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for QT_FILE
-- ----------------------------
DROP TABLE IF EXISTS `QT_FILE`;
CREATE TABLE `QT_FILE`  (
  `FILE_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件ID',
  `FULL_NAME` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件全名',
  `FILE_NAME` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名',
  `FILE_SUFFIX` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件后缀',
  `FILE_SIZE` bigint(0) NOT NULL COMMENT '文件大小',
  `CONTENT_TYPE` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件类型',
  `MD5` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'MD5',
  `UPDATE_TIME` timestamp(0) NOT NULL COMMENT '修改时间',
  `CREATE_TIME` timestamp(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`FILE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
