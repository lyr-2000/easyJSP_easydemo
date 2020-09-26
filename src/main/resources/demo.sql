/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 26/09/2020 22:21:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `student_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `student_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `student_password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `student_id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` int(10) NULL DEFAULT 0,
  `is_deleted` tinyint(1) NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '林东', '123', NULL, 1, NULL, '2020-09-14 16:33:24', '2020-09-14 16:33:24');
INSERT INTO `t_student` VALUES (2, '林东2', '123', NULL, 0, NULL, '2020-09-14 16:22:35', '2020-09-14 16:22:35');
INSERT INTO `t_student` VALUES (3, '白白', 'sss', NULL, 0, NULL, '2020-09-14 09:21:37', '2020-09-14 09:21:39');
INSERT INTO `t_student` VALUES (4, '毛毛', NULL, NULL, 0, NULL, '2020-09-14 09:21:49', '2020-09-14 09:21:53');
INSERT INTO `t_student` VALUES (5, 'aa', 'aaaaa', NULL, 1, NULL, '2020-09-14 18:33:14', '2020-09-14 18:33:14');
INSERT INTO `t_student` VALUES (6, '小猪', '', NULL, 0, NULL, '2020-09-14 21:28:56', '2020-09-14 21:28:56');
INSERT INTO `t_student` VALUES (7, '阿毛', NULL, NULL, 0, NULL, '2020-09-14 09:22:27', '2020-09-14 09:22:28');
INSERT INTO `t_student` VALUES (8, 'dog', NULL, NULL, 0, NULL, '2020-09-14 09:22:23', '2020-09-14 09:22:25');
INSERT INTO `t_student` VALUES (9, 'admin', 'admin', NULL, NULL, NULL, '2020-09-14 18:45:51', '2020-09-14 18:45:51');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `teacher_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `teacher_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` tinyint(1) NULL DEFAULT NULL,
  `is_deleted` tinyint(1) NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, 'sss', '66', 1, 0, '2020-09-13 18:19:55', '2020-09-13 18:19:55');
INSERT INTO `t_teacher` VALUES (2, '小红', 'sss', 1, 0, '2020-09-14 18:19:59', '2020-09-14 18:20:03');
INSERT INTO `t_teacher` VALUES (3, '小明', 'ssfas', 0, 0, '2020-09-13 18:20:21', '2020-09-13 18:20:24');
INSERT INTO `t_teacher` VALUES (4, '效率', 'safa', NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (5, 'aa', 'aa', 0, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (6, 'bb', 'bb', NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (7, 'cc', 'cc', NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (8, 'dd', 'dd', NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (9, 'hello world', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (10, 'hello world', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (11, 'hello world', NULL, NULL, NULL, '2020-09-13 00:00:00', '2020-09-13 00:00:00');
INSERT INTO `t_teacher` VALUES (12, 'hello world', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (13, 'hello world', NULL, NULL, NULL, '2020-09-13 00:00:00', '2020-09-13 00:00:00');
INSERT INTO `t_teacher` VALUES (14, 'hello world', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (15, 'hello world', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
