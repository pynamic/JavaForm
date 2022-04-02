-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2021 at 01:37 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banhang`
--

-- --------------------------------------------------------

--
-- Table structure for table `khach`
--

CREATE TABLE `khach` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `sodu` int(11) NOT NULL,
  `tienno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khach`
--

INSERT INTO `khach` (`id`, `ten`, `sodu`, `tienno`) VALUES
(1, 'Tran Nguyen Tuan', 10301600, 0),
(2, 'Tran Thanh Minh', 4444555, 0);

-- --------------------------------------------------------

--
-- Table structure for table `lichbanhang`
--

CREATE TABLE `lichbanhang` (
  `id` int(11) DEFAULT NULL,
  `ten` varchar(100) DEFAULT NULL,
  `ngay` datetime DEFAULT current_timestamp(),
  `tien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lichbanhang`
--

INSERT INTO `lichbanhang` (`id`, `ten`, `ngay`, `tien`) VALUES
(1, NULL, '2021-05-09 18:35:36', 444),
(1, NULL, '2021-05-09 18:37:06', 1111);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `sanpham` varchar(100) NOT NULL,
  `quycach` int(20) NOT NULL,
  `giamgia` int(11) NOT NULL,
  `gia` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `sanpham`, `quycach`, `giamgia`, `gia`) VALUES
(3, 'Phan Bon D', 1003, 2, 100000),
(7, 'Phan bon ddddd', 233, 56, 344444),
(8, 'Phan Bon eee', 1444, 3, 100044);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `khach`
--
ALTER TABLE `khach`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khach`
--
ALTER TABLE `khach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
