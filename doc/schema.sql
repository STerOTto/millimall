ALTER TABLE `brand` DROP FOREIGN KEY `fk_brand_category`;
ALTER TABLE `goods` DROP FOREIGN KEY `fk_goods_brand`;
ALTER TABLE `sku_value` DROP FOREIGN KEY `fk_goods_attribute`;
ALTER TABLE `goods` DROP FOREIGN KEY `fk_goods_product`;
ALTER TABLE `sku` DROP FOREIGN KEY `fk_sku_goods`;
ALTER TABLE `sku` DROP FOREIGN KEY `fk_sku_attribute`;
ALTER TABLE `sku_value` DROP FOREIGN KEY `fk_sku_value`;

DROP TABLE `goods`;
DROP TABLE `brand`;
DROP TABLE `category`;
DROP TABLE `attribute`;
DROP TABLE `sku_value`;
DROP TABLE `sku`;
DROP TABLE `product`;

CREATE TABLE `goods` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(11) NOT NULL,
  `name` varchar(255) NULL COMMENT '标题',
  `price` decimal(10,2) NULL COMMENT '售价',
  `brand_id` bigint(11) NULL COMMENT '所属品牌',
  PRIMARY KEY (`id`, `product_id`)
);

CREATE TABLE `brand` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL,
  `parent_id` bigint(11) NULL DEFAULT -1,
  `category_id` bigint(11) NULL,
  PRIMARY KEY (`id`)
)
  COMMENT = '品牌';

CREATE TABLE `category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL,
  `parent_id` bigint(11) NULL DEFAULT -1,
  PRIMARY KEY (`id`)
);

CREATE TABLE `attribute` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sku_value` (
  `product_id` bigint(11) NOT NULL,
  `goods_id` bigint(11) NOT NULL,
  `attribute_id` varchar(255) NULL,
  `value` varchar(255) NULL,
  PRIMARY KEY (`product_id`, `goods_id`)
);

CREATE TABLE `sku` (
  `product_id` bigint(11) NULL,
  `goods_id` bigint(11) NOT NULL,
  `attribute_id` bigint(11) NULL,
  `sku` varchar(255) NULL,
  `price` decimal(10,2) NULL,
  `value_id` bigint(11) NULL,
  PRIMARY KEY (`goods_id`)
)
  COMMENT = 'stock keeping unit';

CREATE TABLE `product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL,
  PRIMARY KEY (`id`)
);


ALTER TABLE `brand` ADD CONSTRAINT `fk_brand_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
ALTER TABLE `goods` ADD CONSTRAINT `fk_goods_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);
ALTER TABLE `sku_value` ADD CONSTRAINT `fk_goods_attribute` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`id`);
ALTER TABLE `goods` ADD CONSTRAINT `fk_goods_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);
ALTER TABLE `sku` ADD CONSTRAINT `fk_sku_goods` FOREIGN KEY (`goods_id`, `product_id`) REFERENCES `goods` (`id`, `product_id`);
ALTER TABLE `sku` ADD CONSTRAINT `fk_sku_attribute` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`id`);
ALTER TABLE `sku_value` ADD CONSTRAINT `fk_sku_value` FOREIGN KEY (`goods_id`, `product_id`) REFERENCES `goods` (`id`, `product_id`);

