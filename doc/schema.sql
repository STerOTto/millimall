ALTER TABLE `milli_brand` DROP FOREIGN KEY `milli_brand_ibfk_1`;
ALTER TABLE `milli_category_attribute` DROP FOREIGN KEY `fk_milli_category_attribute_milli_category_attribute_template_1`;
ALTER TABLE `milli_category_attribute_option` DROP FOREIGN KEY `milli_category_attribute_option_ibfk_1`;
ALTER TABLE `milli_category_attribute_template` DROP FOREIGN KEY `fk_milli_category_attribute_template_milli_category_1`;
ALTER TABLE `milli_goods` DROP FOREIGN KEY `milli_goods_ibfk_1`;
ALTER TABLE `milli_goods_attribute` DROP FOREIGN KEY `fk_milli_attribute_milli_goods_1`;
ALTER TABLE `milli_goods_attribute_value` DROP FOREIGN KEY `milli_goods_attribute_value_ibfk_2`;
ALTER TABLE `milli_goods_attribute_value` DROP FOREIGN KEY `milli_goods_attribute_value_ibfk_3`;
ALTER TABLE `milli_mall_category` DROP FOREIGN KEY `fk_milli_mall_category_milli_category_1`;
ALTER TABLE `milli_product` DROP FOREIGN KEY `milli_product_ibfk_1`;
ALTER TABLE `milli_product_attribute_value` DROP FOREIGN KEY `fk_milli_product_attribute_value_milli_product_attribute_1`;
ALTER TABLE `milli_product_attribute_value` DROP FOREIGN KEY `milli_product_attribute_value_ibfk_1`;
ALTER TABLE `milli_sku` DROP FOREIGN KEY `milli_sku_ibfk_1`;

DROP INDEX `category_id` ON `milli_brand`;
DROP INDEX `fk_milli_category_attribute_milli_category_attribute_template_1` ON `milli_category_attribute`;
DROP INDEX `attribute_id` ON `milli_category_attribute_option`;
DROP INDEX `category_id` ON `milli_category_attribute_template`;
DROP INDEX `product_id` ON `milli_goods`;
DROP INDEX `goods_id` ON `milli_goods_attribute`;
DROP INDEX `goods_id` ON `milli_goods_attribute_value`;
DROP INDEX `attribute_id` ON `milli_goods_attribute_value`;
DROP INDEX `fk_milli_mall_category_milli_category_1` ON `milli_mall_category`;
DROP INDEX `brand_id` ON `milli_product`;
DROP INDEX `product_id` ON `milli_product_attribute`;
DROP INDEX `product_id` ON `milli_product_attribute_value`;
DROP INDEX `attribute_id` ON `milli_product_attribute_value`;
DROP INDEX `product_id` ON `milli_sku`;

DROP TABLE `milli_brand`;
DROP TABLE `milli_category`;
DROP TABLE `milli_category_attribute`;
DROP TABLE `milli_category_attribute_option`;
DROP TABLE `milli_category_attribute_template`;
DROP TABLE `milli_goods`;
DROP TABLE `milli_goods_attribute`;
DROP TABLE `milli_goods_attribute_value`;
DROP TABLE `milli_mall_category`;
DROP TABLE `milli_product`;
DROP TABLE `milli_product_attribute`;
DROP TABLE `milli_product_attribute_value`;
DROP TABLE `milli_sku`;

CREATE TABLE `milli_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `category_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `category_id` (`category_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `ordinal` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_category_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `template_id` bigint(20) NULL DEFAULT NULL,
  `attribute_type` int(11) NULL DEFAULT NULL,
  `input_type` int(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) ,
  INDEX `fk_milli_category_attribute_milli_category_attribute_template_1` (`template_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_category_attribute_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_id` bigint(20) NULL DEFAULT NULL,
  `option` varchar(255) NULL DEFAULT NULL,
  `option_image` varchar(255) NULL DEFAULT NULL,
  `initial` varchar(1) NULL DEFAULT NULL,
  `ordinal` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `attribute_id` (`attribute_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_category_attribute_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `category_id` bigint(20) NULL DEFAULT NULL,
  `attribute_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `category_id` (`category_id` ASC, `attribute_type` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(100) NULL DEFAULT NULL,
  `store_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `product_id` (`product_id` ASC, `name` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 100001
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_goods_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `goods_id` (`goods_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_goods_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NULL DEFAULT NULL,
  `code` int(11) NULL DEFAULT 1 COMMENT 'a unique code that represents one goods\' attribute value',
  `attribute_id` bigint(20) NOT NULL,
  `value` varchar(255) NULL DEFAULT NULL,
  `value_image` varchar(255) NULL DEFAULT NULL,
  `initial` varchar(1) NULL DEFAULT NULL,
  `ordinal` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `goods_id` (`goods_id` ASC) USING BTREE,
  INDEX `attribute_id` (`attribute_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_mall_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(255) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_milli_mall_category_milli_category_1` (`category_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NULL DEFAULT NULL,
  `brand_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `brand_id` (`brand_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_product_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `product_id` (`product_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_product_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `attribute_id` bigint(20) NULL DEFAULT NULL,
  `value` varchar(255) NULL DEFAULT NULL,
  `value_image` varchar(255) NULL DEFAULT NULL,
  `initial` varchar(1) NULL DEFAULT NULL,
  `ordinal` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `product_id` (`product_id` ASC) USING BTREE,
  INDEX `attribute_id` (`attribute_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;

CREATE TABLE `milli_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `store_id` bigint(20) NULL DEFAULT NULL COMMENT '店铺ID',
  `goods_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(255) NULL DEFAULT NULL,
  `attribute_codes` varchar(255) NULL DEFAULT NULL COMMENT '`each` sku composed of attributes and values',
  `sku` varchar(255) NULL DEFAULT NULL,
  `price` decimal(10,2) NULL DEFAULT NULL,
  `stock` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `product_id` (`goods_id` ASC) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10001
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = dynamic;


ALTER TABLE `milli_brand` ADD CONSTRAINT `milli_brand_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `milli_category` (`id`);
ALTER TABLE `milli_category_attribute` ADD CONSTRAINT `fk_milli_category_attribute_milli_category_attribute_template_1` FOREIGN KEY (`template_id`) REFERENCES `milli_category_attribute_template` (`id`);
ALTER TABLE `milli_category_attribute_option` ADD CONSTRAINT `milli_category_attribute_option_ibfk_1` FOREIGN KEY (`attribute_id`) REFERENCES `milli_category_attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `milli_category_attribute_template` ADD CONSTRAINT `fk_milli_category_attribute_template_milli_category_1` FOREIGN KEY (`category_id`) REFERENCES `milli_category` (`id`);
ALTER TABLE `milli_goods` ADD CONSTRAINT `milli_goods_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `milli_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `milli_goods_attribute` ADD CONSTRAINT `fk_milli_attribute_milli_goods_1` FOREIGN KEY (`goods_id`) REFERENCES `milli_goods` (`id`);
ALTER TABLE `milli_goods_attribute_value` ADD CONSTRAINT `milli_goods_attribute_value_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `milli_goods` (`id`);
ALTER TABLE `milli_goods_attribute_value` ADD CONSTRAINT `milli_goods_attribute_value_ibfk_3` FOREIGN KEY (`attribute_id`) REFERENCES `milli_goods_attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `milli_mall_category` ADD CONSTRAINT `fk_milli_mall_category_milli_category_1` FOREIGN KEY (`category_id`) REFERENCES `milli_category` (`id`);
ALTER TABLE `milli_product` ADD CONSTRAINT `milli_product_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `milli_brand` (`id`);
ALTER TABLE `milli_product_attribute_value` ADD CONSTRAINT `fk_milli_product_attribute_value_milli_product_attribute_1` FOREIGN KEY (`attribute_id`) REFERENCES `milli_product_attribute` (`id`);
ALTER TABLE `milli_product_attribute_value` ADD CONSTRAINT `milli_product_attribute_value_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `milli_product` (`id`);
ALTER TABLE `milli_sku` ADD CONSTRAINT `milli_sku_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `milli_goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

