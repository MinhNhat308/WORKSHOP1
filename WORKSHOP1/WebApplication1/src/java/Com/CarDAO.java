package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=MyStock;integratedSecurity=true";
    private Connection connection;

    public CarDAO() {
        try {
            System.setProperty("java.library.path", "C:\\path\\to\\sqljdbc_auth.dll"); // Cập nhật đường dẫn đến sqljdbc_auth.dll
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(jdbcURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Car> listCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM Cars";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarID(resultSet.getInt("CarID"));
                car.setCarName(resultSet.getString("CarName"));
                car.setManufacturer(resultSet.getString("Manufacturer"));
                car.setPrice(resultSet.getDouble("Price"));
                car.setReleasedYear(resultSet.getInt("ReleasedYear"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public Car getCar(int id) {
        Car car = null;
        String sql = "SELECT * FROM Cars WHERE CarID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                car = new Car();
                car.setCarID(resultSet.getInt("CarID"));
                car.setCarName(resultSet.getString("CarName"));
                car.setManufacturer(resultSet.getString("Manufacturer"));
                car.setPrice(resultSet.getDouble("Price"));
                car.setReleasedYear(resultSet.getInt("ReleasedYear"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void addCar(Car car) {
        String sql = "INSERT INTO Cars (CarName, Manufacturer, Price, ReleasedYear) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getCarName());
            statement.setString(2, car.getManufacturer());
            statement.setDouble(3, car.getPrice());
            statement.setInt(4, car.getReleasedYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car car) {
        String sql = "UPDATE Cars SET CarName = ?, Manufacturer = ?, Price = ?, ReleasedYear = ? WHERE CarID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getCarName());
            statement.setString(2, car.getManufacturer());
            statement.setDouble(3, car.getPrice());
            statement.setInt(4, car.getReleasedYear());
            statement.setInt(5, car.getCarID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int id) {
        String sql = "DELETE FROM Cars WHERE CarID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}