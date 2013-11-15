-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 15, 2013 at 06:17 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `baggingtool`
--

-- --------------------------------------------------------

--
-- Table structure for table `flows`
--

CREATE TABLE IF NOT EXISTS `flows` (
  `SrcIpAddr` varchar(20) NOT NULL,
  `DstIpAddr` varchar(20) NOT NULL,
  `SrcPort` varchar(10) NOT NULL,
  `DstPort` varchar(10) NOT NULL,
  `Protocol` varchar(10) NOT NULL,
  `FlowDur` double NOT NULL DEFAULT '0',
  `NumOfPkts` int(11) NOT NULL DEFAULT '0',
  `FlowSz` double NOT NULL DEFAULT '0',
  `MinPktSize` double NOT NULL DEFAULT '0',
  `MaxPktSz` double NOT NULL DEFAULT '0',
  `AvgPktSz` double NOT NULL DEFAULT '0',
  `IpMinTTL` double NOT NULL DEFAULT '0',
  `IpMaxTTL` double NOT NULL DEFAULT '0',
  `IPTTLChg` double NOT NULL DEFAULT '0',
  `TcpInitWinSz` double NOT NULL DEFAULT '0',
  `AvgWinSz` double NOT NULL DEFAULT '0',
  `TcpMinWinSz` double NOT NULL DEFAULT '0',
  `TcpMaxWinSz` double NOT NULL DEFAULT '0',
  `MinIAT` double NOT NULL DEFAULT '0',
  `MaxIAT` double NOT NULL DEFAULT '0',
  `MeanIAT` double NOT NULL DEFAULT '0',
  `MedianIAT` double NOT NULL DEFAULT '0',
  `RangeIAT` double NOT NULL DEFAULT '0',
  `StdIAT` double NOT NULL DEFAULT '0',
  `TotalFwdPkts` int(11) NOT NULL DEFAULT '0',
  `TotalFwdSz` double NOT NULL DEFAULT '0',
  `TotalBwdPkts` int(11) NOT NULL DEFAULT '0',
  `TotalBwdSz` double NOT NULL DEFAULT '0',
  `MinFwdPktSz` double NOT NULL DEFAULT '0',
  `MaxFwdPktSz` double NOT NULL DEFAULT '0',
  `MeanFwdPktSz` double NOT NULL DEFAULT '0',
  `StdFwdPktSz` double NOT NULL DEFAULT '0',
  `MinBwdPktSz` double NOT NULL DEFAULT '0',
  `MaxBwdPktSz` double NOT NULL DEFAULT '0',
  `MeanBwdPktSz` double NOT NULL DEFAULT '0',
  `StdBwdPktSz` double NOT NULL DEFAULT '0',
  `MinFIAT` double NOT NULL DEFAULT '0',
  `MeanFIAT` double NOT NULL DEFAULT '0',
  `MaxFIAT` double NOT NULL DEFAULT '0',
  `StdFIAT` double NOT NULL DEFAULT '0',
  `MinBIAT` double NOT NULL DEFAULT '0',
  `MeanBIAT` double NOT NULL DEFAULT '0',
  `MaxBIAT` double NOT NULL DEFAULT '0',
  `StdBIAT` double NOT NULL DEFAULT '0',
  `MinActive` double NOT NULL DEFAULT '0',
  `MaxActive` double NOT NULL DEFAULT '0',
  `MeanActive` double NOT NULL DEFAULT '0',
  `StdActive` double NOT NULL DEFAULT '0',
  `MinIdle` double NOT NULL DEFAULT '0',
  `MaxIdle` double NOT NULL DEFAULT '0',
  `StdIdle` double NOT NULL DEFAULT '0',
  `SubFlowAvgNumFwdPkt` int(11) NOT NULL DEFAULT '0',
  `SubFlowAvgFwdSz` double NOT NULL DEFAULT '0',
  `SubFlowAvgNumBwdPkt` int(11) NOT NULL DEFAULT '0',
  `SubFlowAvgBwdSz` double NOT NULL DEFAULT '0',
  `HeaderTotalFwdSz` double NOT NULL DEFAULT '0',
  `HeaderTotalBwdSz` double NOT NULL DEFAULT '0',
  `BytesPerSec` int(11) NOT NULL DEFAULT '0',
  `PktPerSec` int(11) NOT NULL DEFAULT '0',
  `BytesPerPkt` int(11) NOT NULL DEFAULT '0',
  `ReverseFlowDeltaMiliseconds` double NOT NULL DEFAULT '0',
  `FlowId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`FlowId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
