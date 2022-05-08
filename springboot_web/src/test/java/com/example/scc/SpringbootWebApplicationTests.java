package com.example.scc;

import com.example.scc.entity.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SpringbootWebApplicationTests {

    @Test
    void contextLoads() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        ResponseEntity<Result> resultResponseEntity = testRestTemplate.exchange("http://localhost:8080/user/{id}", HttpMethod.DELETE, null, Result.class, 1);
        System.out.println(resultResponseEntity.toString());
    }

}
