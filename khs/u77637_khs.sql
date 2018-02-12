-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 17, 2018 at 12:53 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u7763703_khs`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE `tb_admin` (
  `recid` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`recid`, `username`, `password`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3'),
(2, 'admin1', 'e00cf25ad42683b3df678c61f42c6bda');

-- --------------------------------------------------------

--
-- Table structure for table `tb_dosen`
--

CREATE TABLE `tb_dosen` (
  `recid` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nip` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `no_hp` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_dosen`
--

INSERT INTO `tb_dosen` (`recid`, `nama`, `nip`, `password`, `no_hp`) VALUES
(4, 'Munandar', '012', 'd2490f048dc3b77a457e3e450ab4eb38', '0874566874'),
(5, 'Doni', '013', '441954d29ad2a375cef8ea524a2c7e73', '0874566874'),
(9, 'hartoni', '009988', '69b4fa3be19bdf400df34e41b93636a4', '0812856999'),
(10, 'eko', '1400', 'aab3238922bcc25a6f606eb525ffdc56', '0815085800');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kelas`
--

CREATE TABLE `tb_kelas` (
  `recid` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `semester` varchar(5) NOT NULL,
  `kategori` varchar(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kelas`
--

INSERT INTO `tb_kelas` (`recid`, `nama`, `semester`, `kategori`) VALUES
(27, 'A.K.14', '6', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kelas_group`
--

CREATE TABLE `tb_kelas_group` (
  `recid` int(11) NOT NULL,
  `id_kelas` varchar(5) NOT NULL,
  `id_matkul` varchar(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kelas_group`
--

INSERT INTO `tb_kelas_group` (`recid`, `id_kelas`, `id_matkul`) VALUES
(22, '26', '8'),
(21, '26', '7'),
(20, '26', '9'),
(19, '25', '8'),
(18, '25', '7'),
(17, '25', '9'),
(23, '27', '9'),
(24, '27', '8'),
(25, '27', '7'),
(26, '28', '9'),
(27, '28', '8');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kelas_mahasiswa`
--

CREATE TABLE `tb_kelas_mahasiswa` (
  `recid` int(11) NOT NULL,
  `id_kelas` varchar(5) NOT NULL,
  `id_mahasiswa` varchar(5) NOT NULL,
  `id_matkul` varchar(5) NOT NULL,
  `nilai_absen` int(5) NOT NULL,
  `nilai_tugas` int(5) NOT NULL,
  `nilai_uts` int(5) NOT NULL,
  `nilai_uas` int(5) NOT NULL,
  `range_nilai` varchar(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kelas_mahasiswa`
--

INSERT INTO `tb_kelas_mahasiswa` (`recid`, `id_kelas`, `id_mahasiswa`, `id_matkul`, `nilai_absen`, `nilai_tugas`, `nilai_uts`, `nilai_uas`, `range_nilai`) VALUES
(28, '26', '10', '7', 80, 85, 75, 75, 'B'),
(27, '26', '2', '7', 60, 96, 52, 63, 'C'),
(26, '26', '8', '7', 60, 70, 40, 90, 'C'),
(22, '25', '8', '9', 60, 50, 10, 50, 'E'),
(21, '25', '2', '7', 95, 50, 60, 25, 'D'),
(19, '25', '3', '8', 100, 15, 100, 100, 'A'),
(20, '25', '8', '7', 85, 65, 68, 88, 'B'),
(18, '25', '2', '8', 10, 50, 90, 100, 'B'),
(29, '26', '10', '8', 90, 58, 65, 63, 'C'),
(30, '26', '8', '8', 60, 60, 40, 90, 'C'),
(31, '26', '10', '9', 70, 90, 100, 40, 'B'),
(32, '26', '8', '9', 90, 60, 70, 90, 'B'),
(33, '27', '8', '9', 90, 80, 70, 90, 'A'),
(34, '27', '8', '8', 65, 60, 80, 90, 'B'),
(35, '27', '8', '7', 90, 66, 88, 85, 'A'),
(36, '27', '12', '8', 80, 90, 50, 60, 'C'),
(37, '27', '9', '8', 90, 80, 70, 50, 'C'),
(38, '27', '2', '7', 15, 60, 90, 100, 'A');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mahasiswa`
--

CREATE TABLE `tb_mahasiswa` (
  `recid` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nim` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jurusan` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mahasiswa`
--

INSERT INTO `tb_mahasiswa` (`recid`, `nama`, `nim`, `password`, `no_hp`, `alamat`, `jurusan`) VALUES
(2, 'Mahasiswa', '0789', '350c2900ac4b9042ba82f1ce0d5a5150', '0874566874', 'Gresik', 'Teknik Informatika'),
(3, 'Zakky Mahasiswa 2', '0790', '0111ce77801c36b76b07263f4dda44ca', '0874566874', 'Bekasi', 'Teknik Informatika'),
(8, 'andy', '1430057', '903ce9225fca3e988c2af215d4e544d3', '088556998', 'bekasi', 'Teknik Informatika'),
(9, 'roni', '1437799', 'd78b154c99fe7f06ebc02ebd63d1c87c', '085522664', 'bekasi', 'Teknik Informatika'),
(14, 'Sari', '1655', 'cc42acc8ce334185e0193753adb6cb77', '08455', 'Bekasi', 'Teknik Informatika'),
(12, 'abro', '0888', '0a113ef6b61820daa5611c870ed8d5ee', '0855555', 'bogor', 'Teknik Informatika'),
(15, 'Susi', '1111', '77963b7a931377ad4ab5ad6a9cd718aa', '222', 'Ddd', 'Teknik Informatika');

-- --------------------------------------------------------

--
-- Table structure for table `tb_matkul`
--

CREATE TABLE `tb_matkul` (
  `recid` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `sks` varchar(5) NOT NULL,
  `dosen` varchar(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_matkul`
--

INSERT INTO `tb_matkul` (`recid`, `nama`, `sks`, `dosen`) VALUES
(9, 'Linux', '4', '9'),
(8, 'UML', '4', '5'),
(7, 'OOP', '4', '4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`recid`);

--
-- Indexes for table `tb_dosen`
--
ALTER TABLE `tb_dosen`
  ADD PRIMARY KEY (`recid`),
  ADD UNIQUE KEY `nip` (`nip`);

--
-- Indexes for table `tb_kelas`
--
ALTER TABLE `tb_kelas`
  ADD PRIMARY KEY (`recid`);

--
-- Indexes for table `tb_kelas_group`
--
ALTER TABLE `tb_kelas_group`
  ADD PRIMARY KEY (`recid`);

--
-- Indexes for table `tb_kelas_mahasiswa`
--
ALTER TABLE `tb_kelas_mahasiswa`
  ADD PRIMARY KEY (`recid`);

--
-- Indexes for table `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  ADD PRIMARY KEY (`recid`),
  ADD UNIQUE KEY `nim` (`nim`);

--
-- Indexes for table `tb_matkul`
--
ALTER TABLE `tb_matkul`
  ADD PRIMARY KEY (`recid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `recid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tb_dosen`
--
ALTER TABLE `tb_dosen`
  MODIFY `recid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tb_kelas`
--
ALTER TABLE `tb_kelas`
  MODIFY `recid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `tb_kelas_group`
--
ALTER TABLE `tb_kelas_group`
  MODIFY `recid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `tb_kelas_mahasiswa`
--
ALTER TABLE `tb_kelas_mahasiswa`
  MODIFY `recid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  MODIFY `recid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `tb_matkul`
--
ALTER TABLE `tb_matkul`
  MODIFY `recid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
