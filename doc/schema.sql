ALTER TABLE `brand` DROP FOREIGN KEY `fk_brand_category`;
ALTER TABLE `goods` DROP FOREIGN KEY `fk_goods_brand`;

DROP TABLE `goods`;
DROP TABLE `brand`;
DROP TABLE `category`;

CREATE TABLE `goods` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`title` varchar(255) NULL COMMENT '标题',
`price` decimal(10,2) NULL COMMENT '售价',
`purchase_price` decimal(10,2) NULL COMMENT '进货价',
`brand_id` bigint(11) NULL COMMENT '所属品牌',
`inventory` int(8) NULL COMMENT '库存量',
`inventory_type` varchar(255) NULL,
`sold_amount` int(8) NULL,
`seo_keywords` varchar(1000) NULL,
`seo_description` varchar(1000) NULL,
`weight` bigint(11) NULL,
PRIMARY KEY (`id`) 
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


ALTER TABLE `brand` ADD CONSTRAINT `fk_brand_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
ALTER TABLE `goods` ADD CONSTRAINT `fk_goods_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

