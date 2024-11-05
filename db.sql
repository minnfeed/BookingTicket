CREATE TABLE `BusCompany` (
                              `BusCompanyID` INT(11) NOT NULL AUTO_INCREMENT,
                              `BusCompanyName` VARCHAR(100) NOT NULL,
                              `Address` VARCHAR(255) NOT NULL,
                              `PhoneNumber` VARCHAR(20) NOT NULL UNIQUE,
                              PRIMARY KEY (`BusCompanyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Bus` (
                       `BusID` INT(11) NOT NULL AUTO_INCREMENT,
                       `BusCompanyID` INT(11) NOT NULL,
                       `LicensePlate` VARCHAR(20) NOT NULL UNIQUE,
                       `SeatCount` INT(11) NOT NULL,
                       `BusType` ENUM('Giường nằm', 'Ghế ngồi') NOT NULL,
                       PRIMARY KEY (`BusID`),
                       FOREIGN KEY (`BusCompanyID`) REFERENCES `BusCompany` (`BusCompanyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Customer` (
                            `CustomerID` INT(11) NOT NULL AUTO_INCREMENT,
                            `CustomerName` VARCHAR(100) NOT NULL,
                            `PhoneNumber` VARCHAR(20) NOT NULL UNIQUE,
                            `Email` VARCHAR(100) NOT NULL UNIQUE,
                            PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `UserAccount` (
                               `PhoneNumber` VARCHAR(50) NOT NULL PRIMARY KEY,
                               `Password` VARCHAR(255) NOT NULL,
                               `Role` ENUM('Customer', 'Admin') DEFAULT 'Customer',
                               FOREIGN KEY (`PhoneNumber`) REFERENCES `Customer`(`PhoneNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Trip` (
                        `TripID` INT(11) NOT NULL AUTO_INCREMENT,
                        `BusID` INT(11) NOT NULL,
                        `DepartureLocation` VARCHAR(100) NOT NULL,
                        `ArrivalLocation` VARCHAR(100) NOT NULL,
                        `DepartureTime` DATETIME NOT NULL,
                        `ArrivalTime` DATETIME NOT NULL,
                        PRIMARY KEY (`TripID`),
                        FOREIGN KEY (`BusID`) REFERENCES `Bus` (`BusID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Seat` (
                        `SeatID` INT(11) NOT NULL AUTO_INCREMENT,
                        `BusID` INT(11) NOT NULL,
                        `SeatNumber` VARCHAR(5) NOT NULL,
                        `SeatStatus` ENUM('Available', 'Booked', 'Reserved') DEFAULT 'Available',
                        PRIMARY KEY (`SeatID`),
                        UNIQUE KEY (`BusID`, `SeatNumber`),
                        FOREIGN KEY (`BusID`) REFERENCES `Bus` (`BusID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Ticket` (
                          `TicketID` INT(11) NOT NULL AUTO_INCREMENT,
                          `CustomerID` INT(11) NOT NULL,
                          `TripID` INT(11) NOT NULL,
                          `SeatID` INT(11) NOT NULL,
                          `Price` DECIMAL(10,2) NOT NULL,
                          `PaymentStatus` ENUM('Paid', 'Pending', 'Cancelled') DEFAULT 'Pending',
                          PRIMARY KEY (`TicketID`),
                          FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE,
                          FOREIGN KEY (`TripID`) REFERENCES `Trip` (`TripID`) ON DELETE CASCADE ON UPDATE CASCADE,
                          FOREIGN KEY (`SeatID`) REFERENCES `Seat` (`SeatID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Payment` (
                           `PaymentID` INT(11) NOT NULL AUTO_INCREMENT,
                           `TicketID` INT(11) NOT NULL,
                           `PaymentMethod` VARCHAR(50) NOT NULL,
                           `AmountPaid` DECIMAL(10,2) NOT NULL,
                           `PaymentDate` DATETIME NOT NULL,
                           PRIMARY KEY (`PaymentID`),
                           FOREIGN KEY (`TicketID`) REFERENCES `Ticket` (`TicketID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insert sample data
INSERT INTO `BusCompany` (`BusCompanyID`, `BusCompanyName`, `Address`, `PhoneNumber`) VALUES
                                                                                          (1, 'Nhà Xe ABC', '123 Đường Lê Lợi, Hà Nội', '0123456789'),
                                                                                          (2, 'Nhà Xe Mai Linh', '456 Đường Nguyễn Huệ, Hồ Chí Minh', '0987654321'),
                                                                                          (3, 'Nhà Xe Thành Bưởi', '789 Đường Trần Hưng Đạo, Đà Nẵng', '0912345678');

INSERT INTO `Bus` (`BusID`, `BusCompanyID`, `LicensePlate`, `SeatCount`, `BusType`) VALUES
                                                                                        (1, 1, '29A-12345', 34, 'Giường nằm'),
                                                                                        (2, 1, '29B-67890', 29, 'Ghế ngồi'),
                                                                                        (3, 2, '30C-11122', 16, 'Ghế ngồi'),
                                                                                        (4, 2, '31D-33344', 45, 'Ghế ngồi'),
                                                                                        (5, 3, '32E-55566', 34, 'Giường nằm');

INSERT INTO `Customer` (`CustomerID`, `CustomerName`, `PhoneNumber`, `Email`) VALUES
                                                                                  (1, 'Nguyễn Văn A', '0901234567', 'nguyenvana@gmail.com'),
                                                                                  (2, 'Trần Thị B', '0907654321', 'tranthib@gmail.com'),
                                                                                  (3, 'Lê Văn C', '0912345678', 'levanc@gmail.com'),
                                                                                  (4, 'Phạm Thị D', '0918765432', 'phamthid@gmail.com');

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
                                                                       (53, 3, '1', 'Available'),
                                                                       (54, 3, '2', 'Available'),
                                                                       (55, 3, '3', 'Available'),
                                                                       (56, 3, '4', 'Available'),
                                                                       (57, 3, '5', 'Available'),
                                                                       (58, 3, '6', 'Available'),
                                                                       (59, 3, '7', 'Available'),
                                                                       (60, 3, '8', 'Available'),
                                                                       (61, 3, '9', 'Available'),
                                                                       (62, 3, '10', 'Available'),
                                                                       (63, 3, '11', 'Available'),
                                                                       (64, 3, '12', 'Available'),
                                                                       (65, 3, '13', 'Available'),
                                                                       (66, 3, '14', 'Available'),
                                                                       (67, 3, '15', 'Available'),
                                                                       (68, 3, '16', 'Available'),
                                                                       (69, 3, '17', 'Available'),
                                                                       (70, 3, '18', 'Available'),
                                                                       (71, 3, '19', 'Available'),
                                                                       (72, 3, '20', 'Available'),
                                                                       (73, 3, '21', 'Available'),
                                                                       (74, 3, '22', 'Available'),
                                                                       (75, 3, '23', 'Available'),
                                                                       (76, 3, '24', 'Available'),
                                                                       (77, 3, '25', 'Available'),
                                                                       (78, 3, '26', 'Available'),
                                                                       (79, 3, '27', 'Available'),
                                                                       (80, 3, '28', 'Available'),
                                                                       (81, 3, '29', 'Available'),
                                                                       (82, 3, '30', 'Available');

INSERT INTO `Trip` (`TripID`, `BusID`, `DepartureLocation`, `ArrivalLocation`, `DepartureTime`, `ArrivalTime`) VALUES
                                                                                                                   (1, 1, 'Hà Nội', 'Đà Nẵng', '2024-11-06 08:00:00', '2024-11-06 15:00:00'),
                                                                                                                   (2, 1, 'Hà Nội', 'Hồ Chí Minh', '2024-11-07 08:00:00', '2024-11-07 20:00:00'),
                                                                                                                   (3, 2, 'Hà Nội', 'Đà Nẵng', '2024-11-06 09:00:00', '2024-11-06 16:00:00'),
                                                                                                                   (4, 2, 'Hà Nội', 'Hồ Chí Minh', '2024-11-07 09:00:00', '2024-11-07 21:00:00'),
                                                                                                                   (5, 3, 'Đà Nẵng', 'Hồ Chí Minh', '2024-11-08 10:00:00', '2024-11-08 22:00:00');

INSERT INTO `UserAccount` (`PhoneNumber`, `Password`, `Role`) VALUES
                                                                  ('0901234567', 'password1', 'Customer'),
                                                                  ('0907654321', 'password2', 'Customer'),
                                                                  ('0912345678', 'password3', 'Customer'),
                                                                  ('0918765432', 'password4', 'Customer');

INSERT INTO `Seat` (`SeatID`, `BusID`, `SeatNumber`, `SeatStatus`) VALUES
                                                                       (1, 1, '1A', 'Available'),
                                                                       (2, 1, '1B', 'Available'),
                                                                       (3, 1, '1C', 'Available'),
                                                                       (4, 1, '1D', 'Available'),
                                                                       (5, 1, '1E', 'Available'),
                                                                       (6, 2, '2A', 'Available'),
                                                                       (7, 2, '2B', 'Available'),
                                                                       (8, 2, '2C', 'Available'),
                                                                       (9, 2, '2D', 'Available'),
                                                                       (10, 2, '2E', 'Available'),
                                                                       (11, 3, '3A', 'Available'),
                                                                       (12, 3, '3B', 'Available'),
                                                                       (13, 3, '3C', 'Available'),
                                                                       (14, 3, '3D', 'Available'),
                                                                       (15, 3, '3E', 'Available');

INSERT INTO `Ticket` (`TicketID`, `CustomerID`, `TripID`, `SeatID`, `Price`, `PaymentStatus`) VALUES
                                                                                                  (1, 1, 1, 1, 100.00, 'Paid'),
                                                                                                  (2, 2, 1, 2, 100.00, 'Pending'),
                                                                                                  (3, 3, 2, 3, 100.00, 'Cancelled'),
                                                                                                  (4, 4, 3, 4, 100.00, 'Paid'),
                                                                                                  (5, 1, 4, 5, 100.00, 'Pending');

INSERT INTO `Payment` (`PaymentID`, `TicketID`, `PaymentMethod`, `AmountPaid`, `PaymentDate`) VALUES
                                                                                                  (1, 1, 'Credit Card', 100.00, '2024-11-01 12:00:00'),
                                                                                                  (2, 4, 'Cash', 100.00, '2024-11-02 13:00:00');
