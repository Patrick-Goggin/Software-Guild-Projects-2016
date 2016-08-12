-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 11, 2016 at 03:35 PM
-- Server version: 5.7.13-0ubuntu0.16.04.2
-- PHP Version: 7.0.8-0ubuntu0.16.04.2
DROP DATABASE CapstoneBlog;
CREATE DATABASE CapstoneBlog;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CapstoneBlog`
--

-- --------------------------------------------------------

--
-- Table structure for table `Article`
--

CREATE TABLE `Article` (
  `articleID` int(11) NOT NULL,
  `articleHead` varchar(50) DEFAULT NULL,
  `articleBody` mediumtext,
  `postingDate` date DEFAULT NULL,
  `takeDownDate` date DEFAULT NULL,
  `activeStatus` tinyint(3) NOT NULL DEFAULT '3',
  `staticPage` tinyint(1) DEFAULT NULL,
  `hashtag` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Article`
--

INSERT INTO `Article` (`articleID`, `articleHead`, `articleBody`, `postingDate`, `takeDownDate`, `activeStatus`, `staticPage`, `hashtag`) VALUES
(7, 'DON\'T DIE IN ', '', '2016-08-01', '2016-08-30', 1, 0, NULL),
(35, 'DON\'T DIE IN A TRENCH', 'jahgkjdsfghkjafadhsgkjsdfahgkjahfkgjhsdfkjhsdkjf', '2016-07-31', '2016-09-21', 1, 0, NULL),
(37, 'COMMON TRENCH MISTAKES', '<p>gfdhfh</p>\n', '2016-08-08', NULL, 1, 0, NULL),
(39, 'TRENCHESSSSSS', '<p>ddasfdsfd</p>\n', '2016-08-02', NULL, 1, 0, NULL),
(40, 'JJJJJ', '<p>jkh</p>\n', '2016-08-09', '2016-08-09', 1, 1, NULL),
(41, 'nnnnnnnnnnn', '<p>jjjj</p>\n', '2016-08-09', '2016-08-09', 1, 1, NULL),
(42, 'TRENCHES CAN BE DANGEROUS!', '<p>zLorem ipsum dolor sit amet, sagittis ut nulla ut euismod, donec quis rhoncus non pulvinar, eros nisl ipsum libero porta commodo. Arcu egestas bibendum consectetuer mauris, voluptas mauris sollicitudin aliquet pellentesque cursus aliquam. Orci justo taciti amet phasellus duis non. Eget erat tellus est, nec in, nulla lacus dictum cras sit, fusce in, lectus mi pede euismodcxvcxvx cx. Sit vel quvisque cursuxc z. Nec ac ultrices, nibh dui lectus. Ultricies nibh pede ipsum labore consectetuer, penatibus ac sed dolor mauris malesuada, penatibus consectetuer lobortis, id aenean nascetur dictum maecenas pede. Vestibulum dictumst arcu interdum vel nulla morbi. Elit parturient ac sodales magna, ipsum neque, ac augue orci leo lacus nulla ornare, nam sed erat, dolores odio eget ultricies nunc duis. Neque etiam id interdum sit, ultricies duis et suspendisse. Amet praesent ipsum, morbi urna dapibus amet, luctus blandit torquent, facilisis pellentesque id enim. Suscipit vitae suscipit, donec est turpis sapien, risus nunc. Morbi in volutpat, vestibulum eu mauris erat, tristique at aenean non, nam pulvinar fusce non, mauris felis neque molestie sed sed praesent.</p>\n', '2016-08-09', '2016-09-29', 1, 1, NULL),
(43, 'TRENCHES = DEATH', '<p>loadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;adloadadsjlk dsfi jddspoaf ldsj &nbsp;d adslj ds da&#39;sf asdlifjfd &nbsp;ad</p>\n', '2016-08-09', '2016-08-31', 1, 1, NULL),
(44, 'STATIC PAGE', '<p>egestas bibendum consectetuer mauris, voluptas mauris sollicitudin aliquet pellentesque cursus aliquam. Orci justo taciti amet phasellus duis non. Eget erat tellus est, nec in, nulla lacus dictum cras sit, fusce in, lectus mi pede euismod. Sit vel quisque cursus. Nec ac ultrices, nibh dui lectus. Ultricies nibh pede ipsum labore consectetuer, penatibus ac sed dolor mauris malesuada, penatibus consectetuer lobortis, id aenean nascetur dictum maecenas pede. Vestibulum dictumst arcu interdum vel nulla morbi. Elit parturient ac sodales magna, ipsum neque, ac augue orci leo lacus nulla ornare, nam sed erat, dolores odio eget ultricies nunc duis. Neque etiam id interdum sit, ultricies duis et suspendisse. Amet praesent ipsum, morbi urna dapibus amet, luctus blandit torquent, facilisis pellentesque id enim. Suscipit vitae suscipit, donec est turpis sapien, risus nunc. Morbi in volutpat, vestibulum eu mauris erat, tristique at aenean non, nam pulvinar fusc</p>\n', '2016-08-10', '2016-08-10', 1, 1, NULL),
(45, 'LOVE, DEATH, AND TRENCHES', '', '2016-07-11', '2016-08-31', 1, 0, NULL),
(46, 'cxvzcxvcxz', '<p>fcbzcvzcx</p>\n', '2016-08-10', '2016-08-10', 1, 0, NULL),
(47, 'dafdsdf', '<p>dsafdasfd</p>\n', '2016-08-10', '2016-08-10', 1, 0, NULL),
(48, 'dsafdsdsaf', '<p>dasfdssafdsaff</p>\n', '2016-08-10', '2016-08-10', 1, 0, NULL),
(49, 'asdfda', '<p>ZXCxZCXZ</p>\n', '2016-08-08', '2016-08-30', 1, 1, NULL),
(50, 'dsfdasf', '<p>dasfdsfdas</p>\n', '2016-08-01', '2016-08-30', 1, 0, NULL),
(58, 'dsfgfdsgsdf', '<p>fsdgfdgfdsg</p>\n', '2016-08-02', '2016-08-30', 1, 0, NULL),
(59, 'BBBBBBBBBBB', '<p>kldajsfldsk</p>\n', '2016-07-31', '2016-08-30', 1, 0, NULL),
(60, 'XXXXXXXXXXXXXX', '<p>dasfdas</p>\n', '2016-08-02', '2016-08-30', 1, 0, NULL),
(61, 'PPPPPPPPP', '<p>ldskjafdlskf</p>\n', '2016-08-01', '2016-08-30', 1, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Authorities`
--

CREATE TABLE `Authorities` (
  `username` varchar(20) NOT NULL,
  `authority` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Authorities`
--

INSERT INTO `Authorities` (`username`, `authority`) VALUES
('test', 'ROLE_ADMIN'),
('test', 'ROLE_USER'),
('test2', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'test', 'password', 1),
(2, 'test2', 'password', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Article`
--
ALTER TABLE `Article`
  ADD PRIMARY KEY (`articleID`);

--
-- Indexes for table `Authorities`
--
ALTER TABLE `Authorities`
  ADD KEY `username` (`username`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Article`
--
ALTER TABLE `Article`
  MODIFY `articleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Authorities`
--
ALTER TABLE `Authorities`
  ADD CONSTRAINT `Authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `Users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
