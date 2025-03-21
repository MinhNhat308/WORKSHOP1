package com; // Đảm bảo rằng gói này đúng với cấu trúc dự án của bạn

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarDAO carDAO;

    public void init() {
        carDAO = new CarDAO(); // Khởi tạo CarDAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertCar(request, response);
                    break;
                case "/delete":
                    deleteCar(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCar(request, response);
                    break;
                default:
                    listCars(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCars(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Car> listCars = carDAO.listCars(); // Lấy danh sách xe
        request.setAttribute("listCars", listCars); // Đặt danh sách xe vào thuộc tính request
        RequestDispatcher dispatcher = request.getRequestDispatcher("car-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("car-create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car existingCar = carDAO.getCar(id); // Lấy xe hiện tại
        RequestDispatcher dispatcher = request.getRequestDispatcher("car-edit.jsp");
        request.setAttribute("car", existingCar); // Đặt xe hiện tại vào thuộc tính request
        dispatcher.forward(request, response);
    }

    private void insertCar(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String carName = request.getParameter("carName");
        String manufacturer = request.getParameter("manufacturer");
        double price = Double.parseDouble(request.getParameter("price"));
        int releasedYear = Integer.parseInt(request.getParameter("releasedYear"));

        Car newCar = new Car();
        newCar.setCarName(carName);
        newCar.setManufacturer(manufacturer);
        newCar.setPrice(price);
        newCar.setReleasedYear(releasedYear);

        carDAO.addCar(newCar); // Thêm xe mới
        response.sendRedirect("cars"); // Chuyển hướng về danh sách xe
    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("carID"));
        String carName = request.getParameter("carName");
        String manufacturer = request.getParameter("manufacturer");
        double price = Double.parseDouble(request.getParameter("price"));
        int releasedYear = Integer.parseInt(request.getParameter("releasedYear"));

        Car car = new Car();
        car.setCarID(id);
        car.setCarName(carName);
        car.setManufacturer(manufacturer);
        car.setPrice(price);
        car.setReleasedYear(releasedYear);

        carDAO.updateCar(car); // Cập nhật xe
        response.sendRedirect("cars"); // Chuyển hướng về danh sách xe
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        carDAO.deleteCar(id); // Xóa xe
        response.sendRedirect("cars"); // Chuyển hướng về danh sách xe
    }
}