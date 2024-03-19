package cz.upce.fei.nnpia.cviceni;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppUserRestTests {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void testGetUserByIdExisting() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/app-user/1", String.class);
        assertEquals(200, responseEntity.getStatusCode().value());
    }

    @Test
    void testGetUserByIdNonExisting() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/app-user/999", String.class);
        assertEquals(404, responseEntity.getStatusCode().value());
    }
}
