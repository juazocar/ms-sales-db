CREATE DATABASE ecommerce;
use ecommerce;

CREATE TABLE `ecommerce`.`product` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(45) NULL,
 `price` INT NULL,
 PRIMARY KEY (`id`));

CREATE TABLE `ecommerce`.`sales` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `amount` INT NOT NULL,
 `sales_date` VARCHAR(45) NULL,
 `customer_id` INT NULL,
 PRIMARY KEY (`id`));

CREATE TABLE `ecommerce`.`sales_detail` (
 `id` INT NOT NULL,
 `product_id` INT NULL,
 `quantity` INT NULL,
 `sales_id` INT NULL,
 PRIMARY KEY (`id`),
 INDEX `sales_detail_product_idx` (`product_id` ASC) VISIBLE,
 INDEX `sales_detail_sales_idx` (`sales_id` ASC) VISIBLE,
 CONSTRAINT `sales_detail_product`
  FOREIGN KEY (`product_id`)
  REFERENCES `ecommerce`.`product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
 CONSTRAINT `sales_detail_sales`
  FOREIGN KEY (`sales_id`)
  REFERENCES `ecommerce`.`sales` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);


INSERT INTO `ecommerce`.`product` (`name`, `price`) VALUES ('producto 1', '150000');
INSERT INTO `ecommerce`.`product` (`name`, `price`) VALUES ('productos 2', '10000');

INSERT INTO `ecommerce`.`sales` (`amount`, `sales_date`, `customer_id`) VALUES ('250000', '26-05-2025', '1');
INSERT INTO `ecommerce`.`sales` (`amount`, `sales_date`, `customer_id`) VALUES ('500000', '26-05-2025', '1');

INSERT INTO `ecommerce`.`sales_detail` (`id`, `product_id`, `quantity`, `sales_id`) VALUES ('1', '1', '1', '1');
INSERT INTO `ecommerce`.`sales_detail` (`id`, `product_id`, `quantity`, `sales_id`) VALUES ('2', '1', '2', '1');
INSERT INTO `ecommerce`.`sales_detail` (`id`, `product_id`, `quantity`, `sales_id`) VALUES ('3', '2', '3', '2');
