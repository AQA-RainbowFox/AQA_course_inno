package ru.inno.course.db;

import ru.inno.course.db.models.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbService {
    private static final String CONNECTION_STRING = "jdbc:postgresql://dpg-cn1542en7f5s73fdrigg-a.frankfurt-postgres.render.com/x_clients_xxet";
    private static Connection connection;
    private static final String USER = "x_clients_user";
    private static final String PASS = "x7ngHjC1h08a85bELNifgKmqZa8KIR40";


    public DbService() throws SQLException {
        connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASS);
    }

    //получение сотрудника по id
    public Employee getEmployeeById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setActive(resultSet.getBoolean("is_active"));
        employee.setCreateTimestamp(resultSet.getString("create_timestamp"));
        employee.setChangeTimestamp(resultSet.getString("change_timestamp"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setMiddleName(resultSet.getString("middle_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setPhone(resultSet.getString("phone"));
        employee.setEmail(resultSet.getString("email"));
        employee.setBirthdate(resultSet.getString("birthdate"));
        employee.setAvatarUrl(resultSet.getString("avatar_url"));
        employee.setCompanyId(resultSet.getInt("company_id"));

        return employee;
    }

    public boolean checkEmployeeIdExist(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT EXISTS(SELECT id FROM employee WHERE id = ?)");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getBoolean(1);
    }

    //Получение всех сотрудников по company_id
    public List<Employee> getAllEmployees(int companyId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where company_id = ?");
        List<Employee> employees = new ArrayList<>();
        statement.setInt(1, companyId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setActive(resultSet.getBoolean("is_active"));
            employee.setCreateTimestamp(resultSet.getString("create_timestamp"));
            employee.setChangeTimestamp(resultSet.getString("change_timestamp"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setMiddleName(resultSet.getString("middle_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setPhone(resultSet.getString("phone"));
            employee.setEmail(resultSet.getString("email"));
            employee.setBirthdate(resultSet.getString("birthdate"));
            employee.setAvatarUrl(resultSet.getString("avatar_url"));
            employee.setCompanyId(resultSet.getInt("company_id"));
            employees.add(employee);
        }
        return employees;
    }

    //удаление сотрудника
    public void deleteEmployee(int companyId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE company_id=?");
        statement.setInt(1, companyId);
        statement.execute();
    }

    //удаление компании
    public void deleteCompany(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM company WHERE id=?");
        statement.setInt(1, id);
        statement.execute();
    }

    //создание админа
    public void createAdmin(String adminLogin, String adminPassword, String displayName) throws SQLException {
        String CREATE_ADMIN_SQL = "INSERT INTO app_users (is_active, create_timestamp, change_timestamp, login, password, display_name, role) VALUES(TRUE, now(), now(), ?, ?, ?, 'admin'::app_users_role_enum);";
        PreparedStatement statement = connection.prepareStatement(CREATE_ADMIN_SQL);
        statement.setString(1, adminLogin);
        statement.setString(2, adminPassword);
        statement.setString(3, displayName);
        statement.execute();
        connection.close();
    }

    //удаление админа
    public void deleteAdmin(String adminLogin) throws SQLException {
        String DELETE_ADMIN_SQL = String.format("DELETE FROM app_users WHERE login='%s';", adminLogin);
        PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL);
        statement.execute();
        connection.close();
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}

