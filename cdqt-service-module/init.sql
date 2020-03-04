CREATE TABLE `base_operational_menu`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `pid` varchar(20) NULL DEFAULT NULL COMMENT '父级ID',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单编码',
  `type` int NOT NULL COMMENT '类型 0：菜单 1：按钮',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_operational_menu_1`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构菜单表' ROW_FORMAT = Compact;

CREATE TABLE `base_operational_operation`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '操作名',
  `code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '操作码',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_operational_operation_1`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构操作表' ROW_FORMAT = Compact;

CREATE TABLE `base_operational_permission`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限编码',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_operational_permission_1`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构权限表' ROW_FORMAT = Compact;

CREATE TABLE `base_operational_permission_menu`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `operational_permission_id` varchar(20) NOT NULL COMMENT '权限ID',
  `operational_menu_id` varchar(20) NOT NULL COMMENT '菜单ID',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限菜单关联表' ROW_FORMAT = Compact;

CREATE TABLE `base_operational_permission_operation`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `operational_permission_id` varchar(20) NOT NULL COMMENT '权限ID',
  `operational_operation_id` varchar(20) NOT NULL COMMENT '操作ID',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限操作关联表' ROW_FORMAT = Compact;

CREATE TABLE `base_organization_info`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '机构名',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构编码 唯一',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_organization_info_1`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构信息' ROW_FORMAT = Compact;

CREATE TABLE `base_role_operational_permission`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `role_id` varchar(20) NOT NULL COMMENT '角色ID',
  `operational_permission_id` varchar(20) NOT NULL COMMENT '权限ID',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Compact;

CREATE TABLE `base_user_info`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电话号码',
  `id_card` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
  `address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_info_1`(`id_card`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息' ROW_FORMAT = Compact STATS_AUTO_RECALC = 0 STATS_PERSISTENT = 0;

CREATE TABLE `base_user_organization_role`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `user_info_id` varchar(20) NOT NULL COMMENT '用户ID',
  `organization_info_id` varchar(20) NOT NULL COMMENT '机构ID',
  `role_id` varchar(20) NOT NULL COMMENT '角色ID',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户机构权限关联表' ROW_FORMAT = Compact;

CREATE TABLE `base_user_role`  (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编码',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_base_user_role_1`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色信息' ROW_FORMAT = Compact;

