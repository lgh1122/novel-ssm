/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.22 : Database - db_novel4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_novel4` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_novel4`;

/*Table structure for table `tb_chapter` */

DROP TABLE IF EXISTS `tb_chapter`;

CREATE TABLE `tb_chapter` (
  `id` bigint(10) NOT NULL COMMENT '章节编号',
  `novelid` bigint(15) NOT NULL COMMENT '书籍编号',
  `netid` bigint(10) NOT NULL COMMENT '网站ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `chapterpath` varchar(100) DEFAULT NULL COMMENT '章节本地路径',
  `previd` bigint(10) DEFAULT NULL COMMENT '上一章',
  `nextid` bigint(10) DEFAULT NULL COMMENT '下一张',
  PRIMARY KEY (`id`,`novelid`,`netid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_chapter` */

/*Table structure for table `tb_net` */

DROP TABLE IF EXISTS `tb_net`;

CREATE TABLE `tb_net` (
  `id` bigint(10) NOT NULL COMMENT '网站ID',
  `netname` varchar(100) DEFAULT NULL COMMENT '网站名',
  `baseurl` varchar(50) DEFAULT NULL COMMENT '网站域名',
  `fullurl` varchar(100) DEFAULT NULL COMMENT '网站全网址',
  `charset` varchar(20) DEFAULT NULL COMMENT '编码',
  `novelurl` varchar(150) DEFAULT NULL COMMENT '书籍详情页URL',
  `chapterurl` varchar(150) DEFAULT NULL COMMENT '章节目录页URL',
  `chapterinfourl` varchar(150) DEFAULT NULL COMMENT '章节阅读页URL',
  `imageurl` varchar(150) DEFAULT NULL COMMENT '图片URL',
  `paramdata` text COMMENT '参数数据，格式为json格式',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_net` */

insert  into `tb_net`(`id`,`netname`,`baseurl`,`fullurl`,`charset`,`novelurl`,`chapterurl`,`chapterinfourl`,`imageurl`,`paramdata`,`addtime`) values (3,'看书中','kanshuzhong.com','http://www.kanshuzhong.com','gbk','http://www.kanshuzhong.com/book/${novelurl}/','http://www.kanshuzhong.com/book/${novelurl}/','http://www.kanshuzhong.com/book/${novelurl}/${chapterurl}.html','http://www.kanshuzhong.com',NULL,NULL);

/*Table structure for table `tb_novel` */

DROP TABLE IF EXISTS `tb_novel`;

CREATE TABLE `tb_novel` (
  `id` bigint(10) NOT NULL COMMENT '书籍编号',
  `netid` bigint(10) NOT NULL COMMENT '所属网站',
  `title` varchar(100) DEFAULT NULL COMMENT '书名',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `tid` bigint(11) DEFAULT NULL COMMENT '类型ID',
  `tname` varchar(20) DEFAULT NULL COMMENT '类型名称',
  `introduction` varchar(1800) DEFAULT NULL COMMENT '简介',
  `imgpath` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `latestchaptername` varchar(100) DEFAULT NULL COMMENT '最新章节名',
  `latestchapterid` bigint(10) DEFAULT NULL COMMENT '最新章节ID',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(1 连载 2 完结)',
  `vaild` tinyint(4) DEFAULT '0' COMMENT '0 有效 1 无效',
  `ishaschapter` tinyint(4) DEFAULT '0' COMMENT '是否已获取章节0 否 1 是',
  `clicknum` int(11) DEFAULT NULL COMMENT '点击量',
  `downnum` int(11) DEFAULT NULL COMMENT '下载量',
  `chapteroldid` bigint(10) DEFAULT NULL COMMENT '章节表最新章节ID',
  PRIMARY KEY (`id`,`netid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_novel` */

/*Table structure for table `tb_quartz_config` */

DROP TABLE IF EXISTS `tb_quartz_config`;

CREATE TABLE `tb_quartz_config` (
  `id` bigint(10) NOT NULL COMMENT 'ID',
  `job_code` varchar(80) NOT NULL COMMENT '任务编号',
  `job_description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `cron_expression` varchar(255) NOT NULL COMMENT '执行时间表达式',
  `cron_expression_desc` varchar(255) NOT NULL COMMENT '执行时间表达式描述',
  `target_object` varchar(255) NOT NULL COMMENT '任务实现类',
  `target_method` varchar(255) NOT NULL COMMENT '任务执行方法',
  `con_current` varchar(1) NOT NULL COMMENT '是否并发执行  1 并发 0 不并发推迟执行',
  `valid_status` varchar(1) NOT NULL COMMENT '是否有效  1 有效 0 无效',
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `SECOND` varchar(80) DEFAULT NULL,
  `MINUTE` varchar(80) DEFAULT NULL,
  `HOUR` varchar(80) DEFAULT NULL,
  `DAY` varchar(80) DEFAULT NULL,
  `MONTH` varchar(80) DEFAULT NULL,
  `WEEK` varchar(80) DEFAULT NULL,
  `YEAR` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_quartz_config` */

insert  into `tb_quartz_config`(`id`,`job_code`,`job_description`,`cron_expression`,`cron_expression_desc`,`target_object`,`target_method`,`con_current`,`valid_status`,`insert_time`,`update_time`,`SECOND`,`MINUTE`,`HOUR`,`DAY`,`MONTH`,`WEEK`,`YEAR`) values (1,'insertNovel','初始化小说数据','','只执行一次','com.novel.manage.scheduler.TaskJob','insertKanShuZhongNovel','0','0','2018-05-03 23:01:46','2018-05-03 23:09:45',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'updateKSZNovel','更新网站小说数据','0 40 5 * * ? *','每天5点40分执行','com.novel.manage.scheduler.TaskJob','updateKanShuZhongNovel','0','1','2018-05-03 23:09:17','2018-05-03 23:09:21',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_type` */

DROP TABLE IF EXISTS `tb_type`;

CREATE TABLE `tb_type` (
  `id` bigint(10) NOT NULL,
  `netid` bigint(10) DEFAULT NULL,
  `typename` varchar(50) NOT NULL,
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_type` */

insert  into `tb_type`(`id`,`netid`,`typename`,`addtime`) values (1,3,'玄幻奇幻','2018-01-12 14:03:58'),(2,3,'历史穿越','2018-01-12 14:04:27'),(3,3,'都市言情','2018-01-12 14:04:23'),(4,3,'武侠修真','2018-01-12 14:04:29'),(5,3,'网游小说','2018-01-12 14:05:03'),(6,3,'恐怖灵异','2018-01-12 14:05:17'),(7,3,'科幻小说','2018-01-12 14:05:28'),(8,3,'其他类型','2018-01-12 14:05:39');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
