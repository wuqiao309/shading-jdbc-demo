/*
 Navicat Premium Data Transfer

 Source Server         : localhost1
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3307
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 29/06/2022 20:39:02
*/
CREATE USER 'read_only'@'%' IDENTIFIED BY '1234';
GRANT SELECT ON *.* TO 'read_only'@'%';
CREATE USER 'read_only1'@'%' IDENTIFIED BY '1234';
GRANT SELECT ON *.* TO 'read_only1'@'%';

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gender
-- ----------------------------
DROP TABLE IF EXISTS `gender`;
CREATE TABLE `gender` (
  `id` bigint NOT NULL,
  `value` tinyint NOT NULL,
  `desc` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_1
-- ----------------------------
DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1` (
  `uid` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `gender` tinyint NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_3
-- ----------------------------
DROP TABLE IF EXISTS `user_3`;
CREATE TABLE `user_3` (
  `uid` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `gender` tinyint NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_history_1
-- ----------------------------
DROP TABLE IF EXISTS `user_history_1`;
CREATE TABLE `user_history_1` (
  `id` bigint NOT NULL,
  `uid` bigint DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_history_3
-- ----------------------------
DROP TABLE IF EXISTS `user_history_3`;
CREATE TABLE `user_history_3` (
  `id` bigint NOT NULL,
  `uid` bigint DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
