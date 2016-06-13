-- phpMyAdmin SQL Dump
-- version 3.3.10
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2016 at 02:43 PM
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
(1, 20160601, '小张', '男', '1991-12-20', '25', '成人', '2016-05-05', '射手座', 'AB型', '张先生', '1967-02-13', '1522039334', '张梅', NULL, '18301756331', '程序员', '浦东', '18302756336', '563335441', NULL, NULL, NULL, NULL, 1, 'admin', '2016-05-18', 1, 'ceb', '2016-05-28'),
(2, 20160520, '小王', '女', '1980-01-16', '36', '成人', '2016-5-5', '天瓶座', 'B型', '王先生', '1960-02-18', '123456789', '李梅', NULL, '18701756443', '老师', '浦东', '1345666777', '123467', NULL, NULL, NULL, NULL, 2, 'admin', '2016-05-18', 1, 'ceb', '2016-05-23');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tempimage`
--


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
  `R4Ttemp` varchar(50) DEFAULT NULL,
  `R4RCL` int(11) DEFAULT NULL,
  `R4RCR` int(11) DEFAULT NULL,
  `R5temp` varchar(50) DEFAULT NULL,
  `R5RCL` int(11) DEFAULT NULL,
  `R5RCR` int(11) DEFAULT NULL,
  PRIMARY KEY (`Inter_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tempinter`
--

INSERT INTO `tempinter` (`Inter_id`, `userid`, `name`, `L1temp`, `L1RCL`, `L1RCR`, `L2temp`, `L2RCL`, `L2RCR`, `L3temp`, `L3RCL`, `L3RCR`, `L4temp`, `L4RCL`, `L4RCR`, `L5temp`, `L5RCL`, `L5RCR`, `R1temp`, `R1RCL`, `R1RCR`, `R2temp`, `R2RCL`, `R2RCR`, `R3temp`, `R3RCL`, `R3RCR`, `R4Ttemp`, `R4RCL`, `R4RCR`, `R5temp`, `R5RCL`, `R5RCR`) VALUES
(1, 2, 'ss', 'cc', 1, 0, '8', 9, 0, '2', 0, 5, '2', 7, 1, '4', 5, 5, '4', 2, 4, '4', 2, 2, '1', 3, 3, '1', 1, 1, '3', 3, 3),
(2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
