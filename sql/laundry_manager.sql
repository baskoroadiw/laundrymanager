-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2018 at 10:34 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `nama_admin` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `username`, `password`) VALUES
(1, 'Baskoro Adi W', 'admin', 'admin'),
(20, 'Dzerowan', 'admin2', 'admin2'),
(21, 'wkwklands', 'wkwk', 'wkwk');

-- --------------------------------------------------------

--
-- Table structure for table `cucian`
--

CREATE TABLE `cucian` (
  `id_cucian` int(11) NOT NULL,
  `berat` int(11) NOT NULL,
  `tanggal_masuk` varchar(20) NOT NULL,
  `harga` int(11) NOT NULL,
  `statuspembayaran` varchar(30) NOT NULL,
  `statustransaksi` varchar(30) NOT NULL,
  `tanggal_keluar` varchar(20) DEFAULT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `id_admin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cucian`
--

INSERT INTO `cucian` (`id_cucian`, `berat`, `tanggal_masuk`, `harga`, `statuspembayaran`, `statustransaksi`, `tanggal_keluar`, `id_pelanggan`, `id_admin`) VALUES
(2, 1, '20/11/2018', 5000, 'Belum Lunas', 'On Process', NULL, 1, 1),
(3, 1, '20/11/2018', 5000, 'Lunas', 'Selesai', '23/11/2018', 2, 1),
(4, 4, '22/11/2018', 20000, 'Lunas', 'Selesai', '25/11/2018', 3, 1),
(5, 3, '27/11/2018', 15000, 'Lunas', 'Selesai', '27/11/2018', 10, 1),
(6, 5, '27/11/2018', 25000, 'Lunas', 'Selesai', '28/11/2018', 11, 1),
(7, 5, '30/11/2018', 25000, 'Lunas', 'Selesai', '30/11/2018', 12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `alamat_pelanggan` varchar(50) NOT NULL,
  `nomer_hp` varchar(20) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat_pelanggan`, `nomer_hp`, `jenis_kelamin`) VALUES
(1, 'first', 'first', '1', 'Laki-Laki'),
(2, 'baskoro', 'kutoarjo', '085325633101', 'Laki-Laki'),
(3, 'Bambang', 'Pinggir kali', '0888', 'Laki-Laki'),
(4, 'baskoro11', 'kutoarjo', '085325633101', 'Laki-Laki'),
(9, 'Dancuk Zaidan', 'Pinggir kali', '0888', 'Laki-Laki'),
(10, 'Putri', 'sukabirus', '0998', 'Perempuan'),
(11, 'ASD', 'PGA', '35839434', 'Laki-Laki'),
(12, 'Final', 'Final', '0000', 'Perempuan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `cucian`
--
ALTER TABLE `cucian`
  ADD PRIMARY KEY (`id_cucian`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `cucian`
--
ALTER TABLE `cucian`
  MODIFY `id_cucian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cucian`
--
ALTER TABLE `cucian`
  ADD CONSTRAINT `cucian_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cucian_ibfk_2` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
