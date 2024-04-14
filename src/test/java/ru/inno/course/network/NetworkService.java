package ru.inno.course.network;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import ru.inno.course.network.models.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class NetworkService {
    private final HttpClient client;
    private final String URL;
    private String TOKEN;
    private int COMPANY_ID;

    public NetworkService(String incomeUrl) {
        this.client = HttpClientBuilder.create().build();
        URL = incomeUrl;
    }
    // авторизация
    public void auth(String user, String pass) throws IOException {
        HttpPost httpPost = new HttpPost(URL + "/auth/login");
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(new AuthRequest(user, pass));
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);

        HttpResponse response = client.execute(httpPost);
        String responseBody = EntityUtils.toString(response.getEntity());
        AuthResponse authResponse = mapper.readValue(responseBody, AuthResponse.class);
        TOKEN = authResponse.getUserToken();
    }

    // создание компании
    public void createCompany(String companyName) throws IOException, URISyntaxException {
        URIBuilder uri = new URIBuilder(URL);
        uri.setPath("/company");

        HttpPost httpPost = new HttpPost(uri.build());
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(new CompanyRequest(companyName));
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        httpPost.setHeader("x-client-token", TOKEN);

        HttpResponse response = client.execute(httpPost);
        String responseBody = EntityUtils.toString(response.getEntity());
        CompanyResponse companyResponse = mapper.readValue(responseBody, CompanyResponse.class);
        COMPANY_ID = companyResponse.getId();
    }

    public List<EmployeeResponse> getAllEmployee() throws URISyntaxException, IOException {
        URIBuilder uri = new URIBuilder(URL);
        uri.setPath("/employee");
        uri.addParameter("company", String.valueOf(COMPANY_ID));
        HttpGet httpGet = new HttpGet(uri.build());
        ObjectMapper mapper = new ObjectMapper();

        HttpResponse response = client.execute(httpGet);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, new TypeReference<>() {
        });
    }

    // создание сотрудника с данными
    public EmployeeResponse createEmployee(String firstName, String lastName, String email, String phone) throws IOException {
        HttpPost httpPost = new HttpPost(URL + "/employee");
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(new EmployeeRequest(firstName, lastName, COMPANY_ID, email, phone));
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        httpPost.setHeader("x-client-token", TOKEN);

        HttpResponse response = client.execute(httpPost);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, EmployeeResponse.class);
    }

    // создание сотрудника
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) throws IOException {
        HttpPost httpPost = new HttpPost(URL + "/employee");
        ObjectMapper mapper = new ObjectMapper();
        employeeRequest.setCompanyId(COMPANY_ID);
        String requestBody = mapper.writeValueAsString(employeeRequest);
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        httpPost.setHeader("x-client-token", TOKEN);

        HttpResponse response = client.execute(httpPost);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, EmployeeResponse.class);
    }

    //получение сотруднкиа по id
    public EmployeeResponse getEmployeeById(String id) throws URISyntaxException, IOException {
        URIBuilder uri = new URIBuilder(URL);
        uri.setPath("/employee/" + id);
        HttpGet httpGet = new HttpGet(uri.build());
        ObjectMapper mapper = new ObjectMapper();

        HttpResponse response = client.execute(httpGet);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, EmployeeResponse.class);
    }

    // изменение сотрудника
    public EmployeeResponse patchEmployee(String id, EmployeeRequest employeeRequest) throws URISyntaxException, IOException {
        URIBuilder uri = new URIBuilder(URL);
        uri.setPath("/employee/" + id);
        HttpPatch httpPatch = new HttpPatch(uri.build());
        httpPatch.setHeader("x-client-token", TOKEN);
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(employeeRequest);
        StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPatch.setEntity(entity);

        HttpResponse response = client.execute(httpPatch);
        String responseBody = EntityUtils.toString(response.getEntity());
        return mapper.readValue(responseBody, EmployeeResponse.class);
    }

    // получение компании по id
    public int getCompanyId() {
        return COMPANY_ID;
    }
}
