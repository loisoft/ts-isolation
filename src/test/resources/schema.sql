CREATE TABLE `emails` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `recipient_id` bigint(20) DEFAULT NULL,
  `body` varchar(45) DEFAULT NULL,
  `unread_flag` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

CREATE TABLE `mailboxes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unread` bigint(20) DEFAULT NULL,
  `recipient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;