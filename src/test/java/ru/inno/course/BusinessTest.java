package ru.inno.course;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import ru.inno.course.db.DbService;
import ru.inno.course.db.models.Employee;
import ru.inno.course.network.NetworkService;
import ru.inno.course.network.models.EmployeeRequest;
import ru.inno.course.network.models.EmployeeResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessTest {
    private final String URL = "https://x-clients-be.onrender.com/";
    private static final String USERNAME = "admin_rainbow";
    private static final String PASSWORD = "Fox-fox";
    private static final String DISPLAY_NAME = "admin_rainbow";
    NetworkService networkService;

    @BeforeAll
    // Создание админа
    public static void createAdmin() throws SQLException {
        new DbService().createAdmin(USERNAME, PASSWORD, DISPLAY_NAME);
    }

    @BeforeEach
    // авторизация и создание компании
    public void setUP() throws IOException, URISyntaxException {
        String randomCompanyName = RandomStringUtils.randomAlphabetic(10).toLowerCase();

        networkService = new NetworkService(URL);
        networkService.auth(USERNAME, PASSWORD);
        networkService.createCompany(randomCompanyName);
    }

    @AfterEach
    // Удаление всех сотрудников с ключом company_id и удаление компании
    public void cleanUp() throws SQLException {
        DbService dbService = new DbService();
        dbService.deleteEmployee(networkService.getCompanyId());
        dbService.deleteCompany(networkService.getCompanyId());
        dbService.disconnect();
    }

    @AfterAll
    // удаление admin по ключу adminLogin
    public static void deleteAdmin() throws SQLException {
        new DbService().deleteAdmin(USERNAME);
    }

    @Test
    @DisplayName("Создание сотрудника через api и проверка наличия его в бд")
    public void createEmployee() throws IOException, SQLException {
        EmployeeResponse employeeId = networkService.createEmployee(generateFirstName(), generateLastName(), generateEmail(), generatePhone());

        DbService dbService = new DbService();
        assertTrue(dbService.checkEmployeeIdExist(employeeId.getId()));
        dbService.disconnect();
    }

    @Test
    @DisplayName("Получение сотрудника по id через api и проверка, что в бд есть этот сотрудник")
    public void getEmployeeById() throws IOException, SQLException, URISyntaxException {
        EmployeeResponse employeeId = networkService.createEmployee(generateFirstName(), generateLastName(), generateEmail(), generatePhone());
        EmployeeResponse employeeResponse = networkService.getEmployeeById(String.valueOf(employeeId.getId()));

        DbService dbService = new DbService();
        Employee employeeDb = dbService.getEmployeeById(employeeResponse.getId());
        dbService.disconnect();

        assertEquals(employeeResponse.getFirstName(), employeeDb.getFirstName());
        assertEquals(employeeResponse.getLastName(), employeeDb.getLastName());
        assertEquals(employeeResponse.getEmail(), employeeDb.getEmail());
        assertEquals(employeeResponse.getPhone(), employeeDb.getPhone());
    }

    @Test
    @DisplayName("Получение списка сотрудников через api и через бд проврека совпадения количества сотрудников")
    public void getAllEmployees() throws IOException, SQLException, URISyntaxException {
        for (int i = 0; i < 4; i++) {
            networkService.createEmployee(generateFirstName(), generateLastName(), generateEmail(), generatePhone());
        }

        List<EmployeeResponse> employeeResponseList = networkService.getAllEmployee();
        int networkEmployeesCount = employeeResponseList.size();

        DbService dbService = new DbService();
        int dbEmployeesCount = dbService.getAllEmployees(networkService.getCompanyId()).size();
        assertEquals(dbEmployeesCount, networkEmployeesCount);

        dbService.disconnect();
    }

    @Test
    @DisplayName("Изменение информации о сотруднике и проверка сохранения изменений в бд")
    public void patchEmployee() throws URISyntaxException, IOException, SQLException {
        EmployeeRequest employeeRequest = new EmployeeRequest();

        employeeRequest.setLastName(generateFirstName());
        employeeRequest.setEmail(generateEmail());
        employeeRequest.setPhone(generatePhone());
        employeeRequest.setActive(true);

        EmployeeResponse employeeId = networkService.createEmployee(generateFirstName(), generateLastName(), generateEmail(), generatePhone());
        EmployeeResponse employeeResponse = networkService.patchEmployee(String.valueOf(employeeId.getId()), employeeRequest);
        EmployeeResponse employeeAfterChanged = networkService.getEmployeeById(String.valueOf(employeeResponse.getId()));

        DbService dbService = new DbService();
        Employee employeeDb = dbService.getEmployeeById(employeeResponse.getId());
        dbService.disconnect();

        assertEquals(employeeAfterChanged.getLastName(), employeeDb.getLastName());
        assertEquals(employeeAfterChanged.getEmail(), employeeDb.getEmail());
        assertEquals(employeeAfterChanged.getPhone(), employeeDb.getPhone());
    }

    private String generateFirstName() {
        return RandomStringUtils.randomAlphabetic(6).toLowerCase();
    }

    private String generateLastName() {
        return RandomStringUtils.randomAlphabetic(8).toLowerCase();
    }

    private String generateEmail() {
        return RandomStringUtils.randomAlphabetic(4).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(4).toLowerCase() + ".ru";
    }

    private String generatePhone() {
        return "+" + RandomStringUtils.randomNumeric(11);
    }

}

