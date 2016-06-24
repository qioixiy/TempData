-- phpMyAdmin SQL Dump
-- version 3.3.10
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 24, 2016 at 02:30 PM
-- Server version: 5.1.56
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tempdata`
--
CREATE DATABASE `tempdata` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tempdata`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` varchar(100) CHARACTER SET utf8 NOT NULL,
  `fullname` varchar(100) CHARACTER SET utf8 NOT NULL,
  `username` varchar(100) CHARACTER SET utf8 NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 NOT NULL,
  `privilege` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `accountId`, `fullname`, `username`, `password`, `privilege`) VALUES
(1, '001', '管理员', 'admin', 'password', '4'),
(2, '002', '李四', 'lisi', 'p', '3'),
(3, '003', '王五', 'wangwu', 'p', '2'),
(4, '004', '麻子', 'mazi', 'p', '1'),
(5, 'test', '你好', 'test', 'password', '4');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `birthday` varchar(30) NOT NULL,
  `age` varchar(10) DEFAULT NULL,
  `version` varchar(10) NOT NULL,
  `collectDate` varchar(50) DEFAULT NULL,
  `constellation` varchar(100) NOT NULL,
  `bloodtype` varchar(50) DEFAULT NULL,
  `fatherName` varchar(50) NOT NULL,
  `farBirthday` varchar(30) DEFAULT NULL,
  `fphone` varchar(50) DEFAULT NULL,
  `matherName` varchar(50) NOT NULL,
  `marBirthday` varchar(30) DEFAULT NULL,
  `mphone` varchar(50) DEFAULT NULL,
  `career` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(50) NOT NULL,
  `QQ` varchar(50) DEFAULT NULL,
  `MSN` varchar(100) DEFAULT NULL,
  `leftATD` varchar(50) DEFAULT NULL,
  `rightATD` varchar(50) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `collId` int(11) DEFAULT NULL,
  `collName` varchar(50) DEFAULT NULL,
  `colldate` varchar(50) DEFAULT NULL,
  `disId` int(11) DEFAULT NULL,
  `disName` varchar(50) DEFAULT NULL,
  `disdate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `userid`, `name`, `gender`, `birthday`, `age`, `version`, `collectDate`, `constellation`, `bloodtype`, `fatherName`, `farBirthday`, `fphone`, `matherName`, `marBirthday`, `mphone`, `career`, `address`, `phone`, `QQ`, `MSN`, `leftATD`, `rightATD`, `note`, `collId`, `collName`, `colldate`, `disId`, `disName`, `disdate`) VALUES
(1, 20160601, '小张', '男', '1991-12-20', '25', '成人', '2016-05-05', '射手座', 'AB型', '张先生', '1967-02-13', '1522039334', '张梅', '1967-02-13', '18301756331', '程序员', '浦东', '18302756336', '563335441', 'a@b.c', '1', '2', '3', 1, 'admin', '2016-05-18', 1, 'ceb', '2016-05-28'),
(2, 20160601, '小张', '男', '1991-12-20', '25', '成人', '2016-05-05', '射手座', 'AB型', '张先生', '1967-02-13', '1522039334', '张梅', '1967-02-13', '18301756331', '程序员', '浦东', '18302756336', '563335441', 'a@b.c', '1', '2', '3', 1, 'admin', '2016-05-18', 1, 'ceb', '2016-05-28');

-- --------------------------------------------------------

--
-- Table structure for table `tempimage`
--

CREATE TABLE IF NOT EXISTS `tempimage` (
  `Image_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `L1post` varchar(100) DEFAULT NULL,
  `L1left` varchar(100) DEFAULT NULL,
  `L1right` varchar(100) DEFAULT NULL,
  `L2post` varchar(100) DEFAULT NULL,
  `L2left` varchar(100) DEFAULT NULL,
  `L2right` varchar(100) DEFAULT NULL,
  `L3post` varchar(100) DEFAULT NULL,
  `L3left` varchar(100) DEFAULT NULL,
  `L3right` varchar(100) DEFAULT NULL,
  `L4post` varchar(100) DEFAULT NULL,
  `L4left` varchar(100) DEFAULT NULL,
  `L4right` varchar(100) DEFAULT NULL,
  `L5post` varchar(100) DEFAULT NULL,
  `L5left` varchar(100) DEFAULT NULL,
  `L5right` varchar(100) DEFAULT NULL,
  `R1post` varchar(100) DEFAULT NULL,
  `R1left` varchar(100) DEFAULT NULL,
  `R1right` varchar(100) DEFAULT NULL,
  `R2post` varchar(100) DEFAULT NULL,
  `R2left` varchar(100) DEFAULT NULL,
  `R2right` varchar(100) DEFAULT NULL,
  `R3post` varchar(100) DEFAULT NULL,
  `R3left` varchar(100) DEFAULT NULL,
  `R3right` varchar(100) DEFAULT NULL,
  `R4post` varchar(100) DEFAULT NULL,
  `R4left` varchar(100) DEFAULT NULL,
  `R4right` varchar(100) DEFAULT NULL,
  `R5post` varchar(100) DEFAULT NULL,
  `R5left` varchar(100) DEFAULT NULL,
  `R5right` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Image_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tempimage`
--

INSERT INTO `tempimage` (`Image_id`, `userid`, `L1post`, `L1left`, `L1right`, `L2post`, `L2left`, `L2right`, `L3post`, `L3left`, `L3right`, `L4post`, `L4left`, `L4right`, `L5post`, `L5left`, `L5right`, `R1post`, `R1left`, `R1right`, `R2post`, `R2left`, `R2right`, `R3post`, `R3left`, `R3right`, `R4post`, `R4left`, `R4right`, `R5post`, `R5left`, `R5right`) VALUES
(1, 20160601, '/20160601/L1C_20160618_230901.bmp', '/20160601/L1L_20160618_225551.bmp', '/20160601/L1R_20160619_230358.bmp', '/20160601/L2C_20160618_231300.bmp', '/20160601/L2L_20160618_230908.bmp', '/20160601/L2R_20160618_230912.bmp', '/20160601/L3C_20160618_230916.bmp', '/20160601/L3L_20160618_230919.bmp', '/20160601/L3R_20160618_230922.bmp', '/20160601/L4C_20160618_230926.bmp', '/20160601/L4L_20160618_230931.bmp', '/20160601/L4R_20160618_230935.bmp', '/20160601/L5C_20160618_230940.bmp', '/20160601/L5L_20160618_230943.bmp', '/20160601/L5R_20160618_230945.bmp', '/20160601/R1C_20160618_230948.bmp', '/20160601/R1L_20160618_230950.bmp', '/20160601/R1R_20160618_230954.bmp', '/20160601/R2C_20160618_230957.bmp', '/20160601/R2L_20160618_231000.bmp', '/20160601/R2R_20160618_231002.bmp', '/20160601/R3C_20160618_231004.bmp', '/20160601/R3L_20160618_231006.bmp', '/20160601/R3R_20160618_231008.bmp', '/20160601/R4C_20160618_231010.bmp', '/20160601/R4L_20160618_231013.bmp', '/20160601/R4R_20160618_231015.bmp', '/20160601/R5C_20160618_231017.bmp', '/20160601/R5L_20160618_231020.bmp', '/20160601/R5R_20160618_231022.bmp'),
(4, 20160601, '/20160601/L1C_20160618_230901.bmp', '/20160601/L1L_20160618_225551.bmp', '/20160601/L1R_20160619_230358.bmp', '/20160601/L2C_20160618_231300.bmp', '/20160601/L2L_20160618_230908.bmp', '/20160601/L2R_20160618_230912.bmp', '/20160601/L3C_20160618_230916.bmp', '/20160601/L3L_20160618_230919.bmp', '/20160601/L3R_20160618_230922.bmp', '/20160601/L4C_20160618_230926.bmp', '/20160601/L4L_20160618_230931.bmp', '/20160601/L4R_20160618_230935.bmp', '/20160601/L5C_20160618_230940.bmp', '/20160601/L5L_20160618_230943.bmp', '/20160601/L5R_20160618_230945.bmp', '/20160601/R1C_20160618_230948.bmp', '/20160601/R1L_20160618_230950.bmp', '/20160601/R1R_20160618_230954.bmp', '/20160601/R2C_20160618_230957.bmp', '/20160601/R2L_20160618_231000.bmp', '/20160601/R2R_20160618_231002.bmp', '/20160601/R3C_20160618_231004.bmp', '/20160601/R3L_20160618_231006.bmp', '/20160601/R3R_20160618_231008.bmp', '/20160601/R4C_20160618_231010.bmp', '/20160601/R4L_20160618_231013.bmp', '/20160601/R4R_20160618_231015.bmp', '/20160601/R5C_20160618_231017.bmp', '/20160601/R5L_20160618_231020.bmp', '/20160601/R5R_20160618_231022.bmp');

-- --------------------------------------------------------

--
-- Table structure for table `tempinter`
--

CREATE TABLE IF NOT EXISTS `tempinter` (
  `Inter_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `L1temp` varchar(50) DEFAULT NULL,
  `L1RCL` int(11) DEFAULT NULL,
  `L1RCR` int(11) DEFAULT NULL,
  `L2temp` varchar(50) DEFAULT NULL,
  `L2RCL` int(11) DEFAULT NULL,
  `L2RCR` int(11) DEFAULT NULL,
  `L3temp` varchar(50) DEFAULT NULL,
  `L3RCL` int(11) DEFAULT NULL,
  `L3RCR` int(11) DEFAULT NULL,
  `L4temp` varchar(50) DEFAULT NULL,
  `L4RCL` int(11) DEFAULT NULL,
  `L4RCR` int(11) DEFAULT NULL,
  `L5temp` varchar(50) DEFAULT NULL,
  `L5RCL` int(11) DEFAULT NULL,
  `L5RCR` int(11) DEFAULT NULL,
  `R1temp` varchar(50) DEFAULT NULL,
  `R1RCL` int(11) DEFAULT NULL,
  `R1RCR` int(11) DEFAULT NULL,
  `R2temp` varchar(50) DEFAULT NULL,
  `R2RCL` int(11) DEFAULT NULL,
  `R2RCR` int(11) DEFAULT NULL,
  `R3temp` varchar(50) DEFAULT NULL,
  `R3RCL` int(11) DEFAULT NULL,
  `R3RCR` int(11) DEFAULT NULL,
  `R4temp` varchar(50) DEFAULT NULL,
  `R4RCL` int(11) DEFAULT NULL,
  `R4RCR` int(11) DEFAULT NULL,
  `R5temp` varchar(50) DEFAULT NULL,
  `R5RCL` int(11) DEFAULT NULL,
  `R5RCR` int(11) DEFAULT NULL,
  PRIMARY KEY (`Inter_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tempinter`
--

INSERT INTO `tempinter` (`Inter_id`, `userid`, `name`, `L1temp`, `L1RCL`, `L1RCR`, `L2temp`, `L2RCL`, `L2RCR`, `L3temp`, `L3RCL`, `L3RCR`, `L4temp`, `L4RCL`, `L4RCR`, `L5temp`, `L5RCL`, `L5RCR`, `R1temp`, `R1RCL`, `R1RCR`, `R2temp`, `R2RCL`, `R2RCR`, `R3temp`, `R3RCL`, `R3RCR`, `R4temp`, `R4RCL`, `R4RCR`, `R5temp`, `R5RCL`, `R5RCR`) VALUES
(1, 20160601, 'ss', '1', 2, 2, '1', 11, 22, '1', 2, 3, '1', 12, 34, '4', 5, 5, '1', 3, 3, '4', 2, 2, '1', 3, 3, '1', 1, 1, '3', 3, 3),
(4, 20160601, 'ss', '1', 2, 2, '1', 11, 22, '1', 2, 3, '1', 12, 34, '4', 5, 5, '1', 3, 3, '4', 2, 2, '1', 3, 3, '1', 1, 1, '3', 3, 3);
