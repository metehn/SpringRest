package com.metehan.springrest.sports.client;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TransferController {

    @GetMapping("/client/header")
    @ResponseBody
    public String getHeader() {

        String url = "http://localhost:8080/transfer/header";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("input", "Metehan");

        HttpEntity<String> entity = new HttpEntity<>("Body", headers);


        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return "Header Sent: " + response.getBody();
    }

    @GetMapping("/client/cookie")
    @ResponseBody
    public String getCookie() {

        String url = "http://localhost:8080/transfer/cookie";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, "input=Metehan");

        HttpEntity<String> entity = new HttpEntity<>("Body", headers);


        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return "Cookie Sent: " + response.getBody();
    }

    @GetMapping("/client/setheader")
    @ResponseBody
    public String setHeader() {

        String url = "http://localhost:8080/transfer/setheader";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);

        String input = response.getHeaders().getFirst("input");

        return "Header obtained: " + response.getBody() + "header: " +input;
    }

    @GetMapping("/client/setcookie")
    @ResponseBody
    public String setCookie(){

        String url = "http://localhost:8080/transfer/setcookie";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, "input=Metehan");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String input = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        return "Cookie obtained: " + response.getBody() + "cookie: " + input;
    }

}
