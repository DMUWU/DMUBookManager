DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `author` varchar(256) DEFAULT NULL,
  `price` varchar(256) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;

INSERT INTO `book` (`id`, `name`, `author`, `price`, `status`)
VALUES
	(1,'枪毙任老道','大英雄王思文','100￥',0),
	(2,'论一个演员的自我修养','斯坦尼斯拉夫斯基','20.40￥',0);

/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

