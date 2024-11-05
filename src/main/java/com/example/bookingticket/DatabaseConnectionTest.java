package com.example.bookingticket;

import java.sql.*;

public class DatabaseConnectionTest {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookingticket"; // Thay đổi URL với tên database của bạn
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; // Nếu bạn không có mật khẩu

    public static void main(String[] args) {
        getBusData();
    }

    public static void getBusData() {
        String query = "SELECT * FROM bus"; // Truy vấn để lấy tất cả các bản ghi từ bảng Bus

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Kiểm tra nếu có dữ liệu trong ResultSet
            while (resultSet.next()) {
                int busID = resultSet.getInt("BusID");
                int busCompanyID = resultSet.getInt("BusCompanyID");
                String licensePlate = resultSet.getString("LicensePlate");
                int seatCount = resultSet.getInt("SeatCount");
                String busType = resultSet.getString("BusType");

                // In thông tin của mỗi bus
                System.out.println("Bus ID: " + busID);
                System.out.println("Bus Company ID: " + busCompanyID);
                System.out.println("License Plate: " + licensePlate);
                System.out.println("Seat Count: " + seatCount);
                System.out.println("Bus Type: " + busType);
                System.out.println("-------------");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy dữ liệu từ cơ sở dữ liệu:");
            e.printStackTrace();
        }

    }

}
