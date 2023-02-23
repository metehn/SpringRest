package com.metehan.springrest.sports.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {

    @GetMapping("/transfer/header")
    public ResponseEntity<?> getHeader(@RequestHeader(value = "input", defaultValue = "Varsayılan!") String input ){
        String output = "Girilen >" + input ;
        return ResponseEntity.ok(output);
    }

    @GetMapping("/transfer/cookie")
    public ResponseEntity<?> getCookie(@CookieValue(value = "input") String input ){
        String output = "Girilen >" + input ;
        return ResponseEntity.ok(output);
    }

    @GetMapping("transfer/setheader")
    public ResponseEntity<?> setHeader(){

        //HttpHeaders headers = new HttpHeaders();
        //headers.add("input", "Metehan");
        return ResponseEntity.ok()
                .header("input", "Metehan")
                .body("Header Sent");    }

    @GetMapping("/transfer/setcookie")
    public ResponseEntity<?> setCookie(){

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, "Metehan")
                .body("Cookie sent");
    }

}
