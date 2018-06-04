CREATE TABLE `t_sys_user_habit` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `habitKey` varchar(255) NOT NULL,
  `habit` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `habit_location` (`contact_id`,`habitKey`) USING BTREE,
  KEY `habitKey` (`habitKey`),
  CONSTRAINT `contact_id` FOREIGN KEY (`contact_id`) REFERENCES `t_crm_customer_contact` (`CONTACT_ID`),
  CONSTRAINT `habitKey` FOREIGN KEY (`habitKey`) REFERENCES `t_sys_user_habit_keys` (`habitKey`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;