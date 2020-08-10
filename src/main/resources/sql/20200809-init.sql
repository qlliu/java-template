USE test;
# example
CREATE TABLE `feed_config` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
     `config_type` int(8) NOT NULL DEFAULT '0' COMMENT '配置类型，详见pb：service/sp/feed.proto/FeedConfigType',
     `key_code` varchar(16) NOT NULL DEFAULT '' COMMENT 'key键',
     `key_name` varchar(32) NOT NULL DEFAULT '' COMMENT 'key名称',
     `value_code` varchar(32) NOT NULL DEFAULT '' COMMENT 'value值，自定义，统一用字符串表示',

     `deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否被删除, 0-no, 1-yes',
     `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
     `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
     PRIMARY KEY (`id`),
     UNIQUE KEY `uniq_key` (`config_type`,`key_code`),
     KEY `idx_type` (`config_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='feed可扩展中立配置表';
