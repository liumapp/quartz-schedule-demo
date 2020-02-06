SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `quartz_job`
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job`;
CREATE TABLE `quartz_job` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) NULL COMMENT '任务名称',
  `group_id` varchar(255) NULL COMMENT 'job组',
  `trigger_id` varchar(255) NULL COMMENT '调度id',
  `params_json` varchar(11845) NULL COMMENT '参数',
  `status` tinyint(1) UNSIGNED DEFAULT 0 COMMENT '状态 0.待执行 1.执行完成 2.执行失败',
  `job_class` varchar(255) NULL COMMENT 'job类',
  `job_params_class` varchar(255) NULL COMMENT 'job参数类',
  `exec_time` datetime NULL,
  `create_time` datetime NULL,
  `is_delete` tinyint(1) UNSIGNED DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
