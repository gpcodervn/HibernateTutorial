DROP TABLE IF EXISTS `category` CASCADE;
DROP TABLE IF EXISTS `post` CASCADE;
DROP TABLE IF EXISTS `role` CASCADE;
DROP TABLE IF EXISTS `user` CASCADE;
DROP TABLE IF EXISTS `user_profile` CASCADE;
DROP TABLE IF EXISTS `user_roles` CASCADE;

CREATE TABLE `category` (
`id` bigint(20) NOT NULL,
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `post` (
`id` bigint(20) NOT NULL,
`title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`user_id` bigint(20) NULL,
`category_id` bigint(20) NULL,
PRIMARY KEY (`id`) ,
INDEX `idx_user` (`user_id`),
INDEX `idx_category` (`category_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `role` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=2;

CREATE TABLE `user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`fullname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '',
`username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '',
`created_at` datetime NULL,
`modified_at` datetime NULL,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `unique_user_username` (`username`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=5;

CREATE TABLE `user_profile` (
`id` bigint(20) NOT NULL,
`user_id` bigint(20) NULL,
`address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`gender` tinyint(4) NULL DEFAULT 1,
PRIMARY KEY (`id`) ,
INDEX `fk_user_profile` (`user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `user_roles` (
`user_id` bigint(20) NOT NULL,
`role_id` bigint(20) NOT NULL,
PRIMARY KEY (`user_id`, `role_id`) ,
INDEX `fk_role` (`role_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `post` ADD CONSTRAINT `fk_post_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
ALTER TABLE `post` ADD CONSTRAINT `fk_post_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `user_profile` ADD CONSTRAINT `fk_user_profile` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `user_roles` ADD CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
ALTER TABLE `user_roles` ADD CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

