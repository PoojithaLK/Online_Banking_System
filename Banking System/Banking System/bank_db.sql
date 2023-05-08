-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2023 at 10:52 AM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `acc_no` int(111) NOT NULL,
  `balance` varchar(111) NOT NULL,
  `int_rate` varchar(111) NOT NULL,
  `type` varchar(111) NOT NULL,
  `b_code` int(111) NOT NULL,
  `branch_no` int(111) NOT NULL,
  `cus_ssn` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`acc_no`, `balance`, `int_rate`, `type`, `b_code`, `branch_no`, `cus_ssn`) VALUES
(11102854, '257', '15', 'Salary', 1001, 101, 111),
(11103104, '234', '12', 'Savings', 1002, 102, 112),
(11105015, '488', '14', 'Money Market', 1001, 101, 112),
(11105261, '100', '15', 'Savings', 1001, 101, 111);

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `code` int(111) NOT NULL,
  `name` varchar(111) NOT NULL,
  `address` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`code`, `name`, `address`) VALUES
(1001, 'COMMERCIAL BANK OF AFRICA', '111 JOHANESBERG'),
(1002, 'KCB', '222 ELDORET');

-- --------------------------------------------------------

--
-- Table structure for table `bank_branch`
--

CREATE TABLE `bank_branch` (
  `code` int(111) NOT NULL,
  `branch_no` int(111) NOT NULL,
  `branch_name` varchar(111) NOT NULL,
  `address` varchar(111) NOT NULL,
  `grade` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank_branch`
--

INSERT INTO `bank_branch` (`code`, `branch_no`, `branch_name`, `address`, `grade`) VALUES
(1001, 101, 'KOIG', '3443 KOIG', 'GD'),
(1002, 102, 'KISUMAYU', '321 KISUMAYU', 'DG'),
(1001, 103, 'CAIRO BRANCH', '33  CARIRO', '34D');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ssn` int(111) NOT NULL,
  `name` varchar(111) NOT NULL,
  `address` varchar(111) NOT NULL,
  `phone` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ssn`, `name`, `address`, `phone`) VALUES
(111, 'TONNY CHROME', '111 SWEDEN', '1234567891'),
(112, 'GILBERT WHITE', '233 MINNESOTA', '502434232'),
(113, 'MESHACK CHRIS', '1212 NY', '502 34342'),
(114, 'APPOLO JAY', '2323 WDC', '502 34342'),
(115, 'CHROM APOLO', '334 NAIRR', '07344233');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Name` varchar(111) NOT NULL,
  `UserName` varchar(111) NOT NULL,
  `Password` varchar(111) NOT NULL,
  `AccountType` varchar(111) NOT NULL,
  `position` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Name`, `UserName`, `Password`, `AccountType`, `position`) VALUES
('ADMIN ADMIN', 'Admin', 'Admin', 'Admin', 'Chairman');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`acc_no`),
  ADD KEY `b_code` (`b_code`,`branch_no`),
  ADD KEY `cus_ssn` (`cus_ssn`),
  ADD KEY `branch_no` (`branch_no`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `bank_branch`
--
ALTER TABLE `bank_branch`
  ADD PRIMARY KEY (`branch_no`),
  ADD KEY `code` (`code`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ssn`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `UserName` (`UserName`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`b_code`) REFERENCES `bank` (`code`),
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`cus_ssn`) REFERENCES `customer` (`ssn`),
  ADD CONSTRAINT `account_ibfk_3` FOREIGN KEY (`branch_no`) REFERENCES `bank_branch` (`branch_no`);

--
-- Constraints for table `bank_branch`
--
ALTER TABLE `bank_branch`
  ADD CONSTRAINT `bank_branch_ibfk_1` FOREIGN KEY (`code`) REFERENCES `bank` (`code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
