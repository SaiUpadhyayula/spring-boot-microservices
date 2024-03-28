CREATE TABLE `t_orders`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `order_number` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `t_order_line_items`
(
    `id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `sku_code`  varchar(255),
    `price`    decimal(19, 2),
    `quantity` int(11),
    `order_id` bigint(20),
    PRIMARY KEY (`id`),
    KEY `fk_order` (`order_id`),
    CONSTRAINT `fk_order` FOREIGN KEY (`order_id`) REFERENCES `t_orders` (`id`)
);