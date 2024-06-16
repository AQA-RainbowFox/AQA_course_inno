package ru.inno.course.db;

import ru.inno.course.db.models.CompanyDb;
import ru.inno.course.utils.ConfigHelper;

import java.sql.*;

public class DbService {
    private static Connection connection;


    public DbService() throws SQLException {
        connection = DriverManager.getConnection(ConfigHelper.getConnectionString(),
                ConfigHelper.getUserDb(),
                ConfigHelper.getPasswordDb()
        );
    }

    public CompanyDb getCompanyById(int companyId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM company where id = ?");
        statement.setInt(1, companyId);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        CompanyDb companyDb = new CompanyDb();
        companyDb.setId(resultSet.getInt("id"));
        companyDb.setActive(resultSet.getBoolean("is_active"));
        companyDb.setCreateDateTime(resultSet.getString("create_timestamp"));
        companyDb.setLastChangedDateTime(resultSet.getString("change_timestamp"));
        companyDb.setName(resultSet.getString("name"));
        companyDb.setDescription(resultSet.getString("description"));
        companyDb.setDeletedAt(resultSet.getString("deleted_at"));

        return companyDb;
    }

    public boolean checkEmployeeFirstNameExist(String firstName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT EXISTS(SELECT id FROM employee WHERE first_name = ?)");
        statement.setString(1, firstName);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getBoolean(1);
    }

    public void deleteEmployeeByCompanyId(int companyId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE company_id=?");
        statement.setInt(1, companyId);
        statement.execute();
    }

    public void deleteEmployeeById(int employeeId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id=?");
        statement.setInt(1, employeeId);
        statement.execute();
    }


    public void createAdmin(String adminLogin, String adminPassword, String displayName) throws SQLException {
        String CREATE_ADMIN_SQL = "INSERT INTO app_users (is_active, create_timestamp, change_timestamp, login, password, display_name, role) VALUES(TRUE, now(), now(), ?, ?, ?, 'admin'::app_users_role_enum);";
        PreparedStatement statement = connection.prepareStatement(CREATE_ADMIN_SQL);
        statement.setString(1, adminLogin);
        statement.setString(2, adminPassword);
        statement.setString(3, displayName);
        statement.execute();
    }


    public void createCompany(boolean isActive, String name, String description) throws SQLException {
        String CREATE_COMPANY_SQL = "INSERT INTO company (is_active, create_timestamp, change_timestamp, name, description, deleted_at) VALUES(?, now(), now(), ?, ?, NULL);";
        PreparedStatement statement = connection.prepareStatement(CREATE_COMPANY_SQL);
        statement.setBoolean(1, isActive);
        statement.setString(2, name);
        statement.setString(3, description);
        statement.execute();
    }

    public void deleteAdmin(String adminLogin) throws SQLException {
        String DELETE_ADMIN_SQL = String.format("DELETE FROM app_users WHERE login='%s';", adminLogin);
        PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL);
        statement.execute();
    }
    public void deleteCompanyById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM company WHERE id=?");
        statement.setInt(1, id);
        statement.execute();
    }
    public void deleteCompanyByName(String companyName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM company WHERE name=?");
        statement.setString(1, companyName);
        statement.execute();
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
