package request.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import request.request.ResponseDto;

import java.net.URI;
import java.util.Collections;

import static org.springframework.http.MediaType.*;

@Service
public class RequestService {

    private final RestTemplate restTemplate;

    public RequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendGetRequest(String name, int age) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8082")
                .path("/getResponse")
                .queryParam("name",name)
                .queryParam("age", age)
                .encode()
                .build()
                .toUri();

        restTemplate.getForEntity(uri,String.class);

        return "TJDRHD";
    }

    public ResponseDto sendPostRequest(ResponseDto responseDto) throws JsonProcessingException {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8082")
                .path("/postResponse")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseDto requestDto = new ResponseDto(responseDto.getName(), responseDto.getAge());
        HttpEntity<ResponseDto> requestEntity = new HttpEntity<>(requestDto, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(uri, requestEntity, String.class);

        System.out.println("Response Body: " + response.getBody());
        System.out.println("Status Code: " + response.getStatusCode());

        return responseDto;

    }

}