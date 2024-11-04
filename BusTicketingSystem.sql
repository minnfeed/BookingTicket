-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th9 27, 2024 lúc 07:44 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `BusTicketingSystemDemo`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Bus`
--

CREATE TABLE `Bus` (
  `BusID` int(11) NOT NULL,
  `BusCompanyID` int(11) NOT NULL,
  `LicensePlate` varchar(20) NOT NULL,
  `SeatCount` int(11) NOT NULL,
  `BusType` enum('Giường nằm','Ghế ngồi') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Bus`
--

INSERT INTO `Bus` (`BusID`, `BusCompanyID`, `LicensePlate`, `SeatCount`, `BusType`) VALUES
(1, 1, '29A-12345', 34, 'Giường nằm'),
(2, 1, '29B-67890', 29, 'Ghế ngồi'),
(3, 2, '30C-11122', 16, 'Ghế ngồi'),
(4, 2, '31D-33344', 45, 'Ghế ngồi'),
(5, 3, '32E-55566', 34, 'Giường nằm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `BusCompany`
--

CREATE TABLE `BusCompany` (
  `BusCompanyID` int(11) NOT NULL,
  `BusCompanyName` varchar(100) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `PhoneNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `BusCompany`
--

INSERT INTO `BusCompany` (`BusCompanyID`, `BusCompanyName`, `Address`, `PhoneNumber`) VALUES
(1, 'Nhà Xe ABC', '123 Đường Lê Lợi, Hà Nội', '0123456789'),
(2, 'Nhà Xe Mai Linh', '456 Đường Nguyễn Huệ, Hồ Chí Minh', '0987654321'),
(3, 'Nhà Xe Thành Bưởi', '789 Đường Trần Hưng Đạo, Đà Nẵng', '0912345678');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Customer`
--

CREATE TABLE `Customer` (
  `CustomerID` int(11) NOT NULL,
  `CustomerName` varchar(100) NOT NULL,
  `PhoneNumber` varchar(20) NOT NULL,
  `Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Customer`
--

INSERT INTO `Customer` (`CustomerID`, `CustomerName`, `PhoneNumber`, `Email`) VALUES
(1, 'Nguyễn Văn A', '0901234567', 'nguyenvana@gmail.com'),
(2, 'Trần Thị B', '0907654321', 'tranthib@gmail.com'),
(3, 'Lê Văn C', '0912345678', 'levanc@gmail.com'),
(4, 'Phạm Thị D', '0918765432', 'phamthid@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Payment`
--

CREATE TABLE `Payment` (
  `PaymentID` int(11) NOT NULL,
  `TicketID` int(11) NOT NULL,
  `PaymentMethod` varchar(50) NOT NULL,
  `AmountPaid` decimal(10,2) NOT NULL,
  `PaymentDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Payment`
--

INSERT INTO `Payment` (`PaymentID`, `TicketID`, `PaymentMethod`, `AmountPaid`, `PaymentDate`) VALUES
(1, 1, 'CreditCard', 500000.00, '2024-09-26 14:00:00'),
(2, 3, 'BankTransfer', 200000.00, '2024-09-25 10:30:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Seat`
--

CREATE TABLE `Seat` (
  `SeatID` int(11) NOT NULL,
  `BusID` int(11) NOT NULL,
  `SeatNumber` varchar(5) NOT NULL,
  `SeatStatus` enum('Available','Booked','Reserved') DEFAULT 'Available'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Seat`
--

INSERT INTO `Seat` (`SeatID`, `BusID`, `SeatNumber`, `SeatStatus`) VALUES
(1, 1, 'A1', 'Available'),
(2, 1, 'A2', 'Available'),
(3, 1, 'A3', 'Available'),
(4, 1, 'A4', 'Available'),
(5, 1, 'A5', 'Available'),
(6, 1, 'A6', 'Available'),
(7, 1, 'A7', 'Available'),
(8, 1, 'A8', 'Available'),
(9, 1, 'A9', 'Available'),
(10, 1, 'A10', 'Available'),
(11, 1, 'A11', 'Available'),
(12, 1, 'A12', 'Available'),
(13, 1, 'A13', 'Available'),
(14, 1, 'A14', 'Available'),
(15, 1, 'A15', 'Available'),
(16, 1, 'A16', 'Available'),
(17, 1, 'B1', 'Available'),
(18, 1, 'B2', 'Available'),
(19, 1, 'B3', 'Available'),
(20, 1, 'B4', 'Available'),
(21, 1, 'B5', 'Available'),
(22, 1, 'B6', 'Available'),
(23, 1, 'B7', 'Available'),
(24, 1, 'B8', 'Available'),
(25, 1, 'B9', 'Available'),
(26, 1, 'B10', 'Available'),
(27, 1, 'B11', 'Available'),
(28, 1, 'B12', 'Available'),
(29, 1, 'B13', 'Available'),
(30, 1, 'B14', 'Available'),
(31, 1, 'B15', 'Available'),
(32, 1, 'B16', 'Available'),
(33, 2, '1', 'Available'),
(34, 2, '2', 'Available'),
(35, 2, '3', 'Available'),
(36, 2, '4', 'Available'),
(37, 2, '5', 'Available'),
(38, 2, '6', 'Available'),
(39, 2, '7', 'Available'),
(40, 2, '8', 'Available'),
(41, 2, '9', 'Available'),
(42, 2, '10', 'Available'),
(43, 2, '11', 'Available'),
(44, 2, '12', 'Available'),
(45, 2, '13', 'Available'),
(46, 2, '14', 'Available'),
(47, 2, '15', 'Available'),
(48, 2, '16', 'Available'),
(49, 2, '17', 'Available'),
(50, 2, '18', 'Available'),
(51, 2, '19', 'Available'),
(52, 2, '20', 'Available'),
(53, 2, '21', 'Available'),
(54, 2, '22', 'Available'),
(55, 2, '23', 'Available'),
(56, 2, '24', 'Available'),
(57, 2, '25', 'Available'),
(58, 2, '26', 'Available'),
(59, 2, '27', 'Available'),
(60, 2, '28', 'Available'),
(61, 2, '29', 'Available');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Ticket`
--

CREATE TABLE `Ticket` (
  `TicketID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `TripID` int(11) NOT NULL,
  `SeatID` int(11) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `PaymentStatus` enum('Paid','Pending','Cancelled') DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Ticket`
--

INSERT INTO `Ticket` (`TicketID`, `CustomerID`, `TripID`, `SeatID`, `Price`, `PaymentStatus`) VALUES
(1, 1, 1, 1, 500000.00, 'Paid'),
(2, 2, 2, 2, 300000.00, 'Pending'),
(3, 3, 3, 3, 200000.00, 'Paid'),
(4, 4, 4, 4, 450000.00, 'Cancelled'),
(5, 1, 1, 1, 500000.00, 'Paid'),
(6, 2, 2, 2, 300000.00, 'Pending'),
(7, 3, 3, 3, 200000.00, 'Paid'),
(8, 4, 4, 4, 450000.00, 'Cancelled');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Trip`
--

CREATE TABLE `Trip` (
  `TripID` int(11) NOT NULL,
  `BusID` int(11) NOT NULL,
  `DepartureLocation` varchar(100) NOT NULL,
  `ArrivalLocation` varchar(100) NOT NULL,
  `DepartureTime` datetime NOT NULL,
  `ArrivalTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Trip`
--

INSERT INTO `Trip` (`TripID`, `BusID`, `DepartureLocation`, `ArrivalLocation`, `DepartureTime`, `ArrivalTime`) VALUES
(1, 1, 'Hà Nội', 'Hồ Chí Minh', '2024-10-01 08:00:00', '2024-10-02 10:00:00'),
(2, 1, 'Hà Nội', 'Đà Nẵng', '2024-10-03 07:00:00', '2024-10-03 19:00:00'),
(3, 2, 'Hồ Chí Minh', 'Cần Thơ', '2024-10-04 09:00:00', '2024-10-04 13:00:00'),
(4, 2, 'Cần Thơ', 'Đà Nẵng', '2024-10-05 10:00:00', '2024-10-05 15:00:00'),
(5, 3, 'Đà Nẵng', 'Huế', '2024-10-06 08:00:00', '2024-10-06 10:30:00'),
(6, 3, 'Huế', 'Hà Nội', '2024-10-07 09:00:00', '2024-10-07 13:00:00'),
(7, 1, 'Hà Nội', 'Nha Trang', '2024-10-08 07:30:00', '2024-10-09 10:30:00');

--
-- Cấu trúc bảng 'UserAccount'

CREATE TABLE `UserAccount` (
  `PhoneNumber` varchar(50) NOT NULL PRIMARY KEY, 
  `Password` varchar(255) NOT NULL,
  `Role` enum('Customer', 'Admin') DEFAULT 'Customer'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `UserAccount` (`PhoneNumber`, `Password`,`Role`) VALUES
('0901234567', 'password1', 'Customer'),
('0907654321', 'password2', 'Customer'),
('0912345678', 'password3', 'Customer'),
('0918765432', 'password4', 'Customer');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `Bus`
--
ALTER TABLE `Bus`
  ADD PRIMARY KEY (`BusID`),
  ADD UNIQUE KEY `LicensePlate` (`LicensePlate`),
  ADD KEY `BusCompanyID` (`BusCompanyID`);

--
-- Chỉ mục cho bảng `BusCompany`
--
ALTER TABLE `BusCompany`
  ADD PRIMARY KEY (`BusCompanyID`),
  ADD UNIQUE KEY `PhoneNumber` (`PhoneNumber`);

--
-- Chỉ mục cho bảng `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`CustomerID`),
  ADD UNIQUE KEY `PhoneNumber` (`PhoneNumber`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Chỉ mục cho bảng `Payment`
--
ALTER TABLE `Payment`
  ADD PRIMARY KEY (`PaymentID`),
  ADD KEY `TicketID` (`TicketID`);

--
-- Chỉ mục cho bảng `Seat`
--
ALTER TABLE `Seat`
  ADD PRIMARY KEY (`SeatID`),
  ADD UNIQUE KEY `BusID` (`BusID`,`SeatNumber`);

--
-- Chỉ mục cho bảng `Ticket`
--
ALTER TABLE `Ticket`
  ADD PRIMARY KEY (`TicketID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `TripID` (`TripID`),
  ADD KEY `SeatID` (`SeatID`);

--
-- Chỉ mục cho bảng `Trip`
--
ALTER TABLE `Trip`
  ADD PRIMARY KEY (`TripID`),
  ADD KEY `BusID` (`BusID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `Bus`
--
ALTER TABLE `Bus`
  MODIFY `BusID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `BusCompany`
--
ALTER TABLE `BusCompany`
  MODIFY `BusCompanyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `Customer`
--
ALTER TABLE `Customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `Payment`
--
ALTER TABLE `Payment`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `Seat`
--
ALTER TABLE `Seat`
  MODIFY `SeatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT cho bảng `Ticket`
--
ALTER TABLE `Ticket`
  MODIFY `TicketID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `Trip`
--
ALTER TABLE `Trip`
  MODIFY `TripID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `Bus`
--
ALTER TABLE `Bus`
  ADD CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`BusCompanyID`) REFERENCES `BusCompany` (`BusCompanyID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Payment`
--
ALTER TABLE `Payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`TicketID`) REFERENCES `Ticket` (`TicketID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Seat`
--
ALTER TABLE `Seat`
  ADD CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`BusID`) REFERENCES `Bus` (`BusID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Ticket`
--
ALTER TABLE `Ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`TripID`) REFERENCES `Trip` (`TripID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`SeatID`) REFERENCES `Seat` (`SeatID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Trip`
--
ALTER TABLE `Trip`
  ADD CONSTRAINT `trip_ibfk_1` FOREIGN KEY (`BusID`) REFERENCES `Bus` (`BusID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

--
-- Các ràng buộc cho bảng `Customer`
ALTER TABLE `Customer`
ADD CONSTRAINT `fk_customer_user` FOREIGN KEY (`PhoneNumber`) REFERENCES `UserAccount`(`PhoneNumber`) 
ON DELETE NO ACTION ON UPDATE CASCADE;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
