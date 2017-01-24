-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` varchar(255) NOT NULL,
  `bookName` varchar(255) DEFAULT NULL COMMENT '书名',
  `bookPress` varchar(255) DEFAULT NULL COMMENT '出版社',
  `bookIntroduction` varchar(255) DEFAULT NULL COMMENT '简介',
  `bookClassId` varchar(255) DEFAULT NULL COMMENT '书类id',
  `bookPice` varchar(255) DEFAULT NULL COMMENT '价格',
  `bookWriter` varchar(255) DEFAULT NULL COMMENT '作者',
  `bookState` varchar(255) DEFAULT NULL COMMENT '0表示可借阅，1表示已被借阅，2表示不可借阅',
  `borrowNum` varchar(255) DEFAULT NULL COMMENT '借阅次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('1','dfas','asf',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookclass`
--

DROP TABLE IF EXISTS `bookclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookclass` (
  `id` varchar(255) NOT NULL,
  `className` varchar(255) DEFAULT NULL COMMENT '类别名称',
  `classInforduction` varchar(255) DEFAULT NULL COMMENT '类别信息',
  `classCreatTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookclass`
--

LOCK TABLES `bookclass` WRITE;
/*!40000 ALTER TABLE `bookclass` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `id` varchar(255) NOT NULL,
  `bookId` varchar(255) NOT NULL COMMENT '书id',
  `userId` varchar(255) NOT NULL COMMENT '借阅者id',
  `borrowTime` varchar(255) NOT NULL COMMENT '借阅开始时间',
  `mangerId` varchar(255) NOT NULL COMMENT '管理员id',
  `stillTime` varchar(255) DEFAULT NULL COMMENT '还书时间',
  `borrowState` varchar(255) DEFAULT NULL COMMENT '借阅状态',
  `borrowOverPrice` varchar(255) DEFAULT NULL COMMENT '超市金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` varchar(255) NOT NULL,
  `menuRoot` varchar(255) DEFAULT NULL COMMENT '菜单级数',
  `menuName` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menuFatherId` varchar(255) DEFAULT NULL COMMENT '父级菜单',
  `menuPageDo` varchar(255) DEFAULT NULL COMMENT '对应页面do',
  `menuTarget` varchar(255) DEFAULT NULL COMMENT '页面呈现方式',
  `createId` varchar(255) DEFAULT NULL COMMENT '创建人',
  `createTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `sort` (`sort`),
  KEY `父菜单` (`menuRoot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('1','0','系统管理','0',NULL,NULL,'admin','1','1'),('10','2','图书借出','12','bookborrowout.do','navtab','admin','1','1'),('11','2','图书种类','21','bookclass.do','navtab','admin','1','2'),('12','1','图书借阅','16',NULL,NULL,'admin','1','1'),('13','1','图书归还','16',NULL,NULL,'admin','1','2'),('14','2','还书管理','13','bookback.do','navtab','admin','1','1'),('15','2','借阅记录','13','bookhistroy.do','navtab','admin','1','2'),('16','0','借阅管理','0','','','admin','','3'),('17','1','权限管理','1','','','admin','','3'),('18','2','工作人员权限','17','powerinfo.do','navtab','admin','','1'),('19','2','其他权限','17','otherpower.do','navtab','admin','','2'),('2','0','图书管理','0',NULL,NULL,'admin','1','2'),('20','2','工作人员','5','workerinfo.do','navtab','admin','2017-01-18 21:40:57','3'),('21','1','图书信息','2','','','admin','2017-01-20 19:03:35','1'),('22','1','图书种类信息','2','','','admin','2017-01-20 19:03:35','2'),('23','2','图书录入','21','bookin.do','navtab','admin','2017-01-20 19:13:55','1'),('24','2','图书维护','21','bookinfo.do','navtab','admin','2017-01-20 19:15:21','2'),('3','0','用户信息','0',NULL,NULL,'userdo','1','4'),('4','1','菜单管理','1',NULL,NULL,'admin','1','1'),('5','1','人员管理','1',NULL,NULL,'admin','1','2'),('6','2','菜单模板','4','menumanger.do','navtab','admin','1','1'),('7','2','我的菜单','4','menupage.do','navtab','admin','1','2'),('8','2','个人中心','5','personmsg.do','navtab','admin','1','1'),('9','2','关于我们','5','about.do','navtab','admin','1','2'),('aos4fc15a','1','图书信息','pxmed2ef4','','','w1','2017-01-20 19:15:50','1'),('awy2ba511','0','系统管理','0',NULL,NULL,'w1','2017-01-20 19:15:50','1'),('bjsee7adb','0','借阅管理','0','','','w1','2017-01-20 19:15:50','3'),('chace01e7','2','借阅记录','nhjfda7df','bookhistroy.do','navtab','w1','2017-01-20 19:15:50','2'),('cmvda2834','1','人员管理','awy2ba511',NULL,NULL,'w1','2017-01-20 19:15:50','2'),('del02fcae','2','还书管理','nhjfda7df','bookback.do','navtab','w1','2017-01-20 19:15:50','1'),('exg9cdd3c','2','图书种类','aos4fc15a','bookclass.do','navtab','w1','2017-01-20 19:15:50','2'),('fwlf05075','1','图书种类信息','pxmed2ef4','','','w1','2017-01-20 19:15:50','2'),('hjt1753eb','2','图书录入','aos4fc15a','bookin.do','navtab','w1','2017-01-20 19:15:50','1'),('iel29f974','1','菜单管理','awy2ba511',NULL,NULL,'w1','2017-01-20 19:15:50','1'),('isp70dcc3','2','工作人员','cmvda2834','workerinfo.do','navtab','w1','2017-01-20 19:15:50','3'),('ixl4539b4','2','工作人员权限','nus62a39b','powerinfo.do','navtab','w1','2017-01-20 19:15:50','1'),('jsdiojfoisd','2','测试延时登录','iel29f974','timeout.do','dialog','w1','2017-01-20 19:44:00','3'),('nhjfda7df','1','图书归还','bjsee7adb',NULL,NULL,'w1','2017-01-20 19:15:50','2'),('nus62a39b','1','权限管理','awy2ba511','','','w1','2017-01-20 19:15:50','3'),('owwda683b','2','个人中心','cmvda2834','personmsg.do','navtab','w1','2017-01-20 19:15:50','1'),('pxmed2ef4','0','图书管理','0',NULL,NULL,'w1','2017-01-20 19:15:50','2'),('uaxab31e5','2','图书借出','xdj58de11','bookborrowout.do','navtab','w1','2017-01-20 19:15:50','1'),('udg951e08','2','关于我们','cmvda2834','about.do','navtab','w1','2017-01-20 19:15:50','2'),('vlk246658','2','菜单模板','iel29f974','menumanger.do','navtab','w1','2017-01-20 19:15:50','1'),('vxqa9136b','2','我的菜单','iel29f974','mymenu.do','navtab','w1','2017-01-20 19:15:50','2'),('xdj58de11','1','图书借阅','bjsee7adb',NULL,NULL,'w1','2017-01-20 19:15:50','1'),('xkh1879f5','0','用户信息','0',NULL,NULL,'hkt2e049c','2017-01-18 22:10:22','3'),('yir3c8e45','2','其他权限','nus62a39b','otherpower.do','navtab','w1','2017-01-20 19:15:50','2'),('ysk1b431b','2','图书维护','aos4fc15a','bookinfo.do','navtab','w1','2017-01-20 19:15:50','2');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pager`
--

DROP TABLE IF EXISTS `pager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pager` (
  `id` varchar(255) NOT NULL,
  `menuName` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menuAbout` varchar(255) DEFAULT NULL COMMENT '菜单描述',
  `createId` varchar(255) DEFAULT NULL COMMENT '创建人id ',
  `menuUrl` varchar(255) DEFAULT NULL COMMENT '菜单路径',
  `pageTarget` varchar(255) DEFAULT NULL COMMENT '呈现方式',
  `createTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pager`
--

LOCK TABLES `pager` WRITE;
/*!40000 ALTER TABLE `pager` DISABLE KEYS */;
INSERT INTO `pager` VALUES ('1','书籍录入','录入书籍','1','bookinfo.do',NULL,NULL);
/*!40000 ALTER TABLE `pager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power`
--

DROP TABLE IF EXISTS `power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power` (
  `id` varchar(255) NOT NULL,
  `powerName` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `pageIds` varchar(255) DEFAULT NULL COMMENT '权限页面',
  `createId` varchar(255) DEFAULT NULL COMMENT '创建id',
  `createTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `startMod` varchar(255) DEFAULT NULL COMMENT '初始化菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power`
--

LOCK TABLES `power` WRITE;
/*!40000 ALTER TABLE `power` DISABLE KEYS */;
INSERT INTO `power` VALUES ('1','管理员权限','1,2,3,4,5,6','w1',NULL,'1','admin'),('2','操作员权限','1,2,3,4,5','w1',NULL,'1','userdo'),('3','测试员权限','1,3,4,5','w1','2017-01-18 20:54:53',NULL,'admin');
/*!40000 ALTER TABLE `power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `id` varchar(255) NOT NULL,
  `ruleName` varchar(255) DEFAULT NULL COMMENT '规则名称',
  `ruleContext` varchar(255) DEFAULT NULL COMMENT '规则简介',
  `ruleNum` varchar(255) DEFAULT NULL COMMENT '借阅数',
  `ruleTime` varchar(255) DEFAULT NULL COMMENT '借阅时长',
  `ruleOverPrice` varchar(10) DEFAULT NULL COMMENT '超时价格比率',
  `ruleState` varchar(2) DEFAULT NULL COMMENT '状态',
  `createId` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `startTime` varchar(255) DEFAULT NULL COMMENT '开始时间',
  `endTime` varchar(255) DEFAULT NULL COMMENT '停用时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `userCode` varchar(255) DEFAULT NULL COMMENT '用户编码',
  `userBorrowCode` varchar(255) DEFAULT NULL COMMENT '借阅证号',
  `userIdentityId` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `userAccount` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `userMail` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `userPhone` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `userPasswd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `userAge` varchar(255) DEFAULT NULL COMMENT '年龄',
  `userBirthday` varchar(255) DEFAULT NULL COMMENT '生日',
  `userState` varchar(255) DEFAULT NULL COMMENT '状态',
  `userCompany` varchar(255) DEFAULT NULL COMMENT '单位',
  `ruleId` varchar(2) DEFAULT NULL COMMENT '用户借阅权限',
  `userClass` varchar(255) DEFAULT NULL COMMENT '用户组',
  `userPic` varchar(255) DEFAULT NULL COMMENT '用户图片',
  `userRole` varchar(2) DEFAULT NULL COMMENT '用户角色',
  `userNum` varchar(255) DEFAULT NULL COMMENT '个人借阅本数（默认为0）',
  `userTime` varchar(255) DEFAULT NULL COMMENT '个人借阅时长（默认为0）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1',NULL,NULL,NULL,NULL,'test',NULL,NULL,'test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker` (
  `id` varchar(255) NOT NULL,
  `userCode` varchar(255) DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `userAccount` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `userMail` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `userPhone` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `userPasswd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `userAge` varchar(255) DEFAULT NULL COMMENT '年龄',
  `userBirthday` varchar(255) DEFAULT NULL COMMENT '生日',
  `userState` varchar(255) DEFAULT NULL COMMENT '状态',
  `userPowerId` varchar(255) DEFAULT NULL COMMENT '权限',
  `userCompany` varchar(255) DEFAULT NULL COMMENT '单位',
  `userPic` varchar(255) DEFAULT NULL COMMENT '照片',
  `createTime` varchar(255) DEFAULT NULL,
  `createId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES ('hkt2e049c','0002','李四','lisi','215146565@qq.com','13655698856','1234','23','1334','1','2','八队','b.jpg','2017-01-18 22:07:14','w1'),('w1','0001','管理员','admin','1021640745@qq.com','15617696583','12341234','20','1223','1','1','九队','a.jpg',NULL,NULL);
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-20 22:29:02
