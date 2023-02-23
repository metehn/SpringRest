package com.metehan.springrest.sports.service;

import com.metehan.springrest.sports.data.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
public class StatusResource {

    @GetMapping("/status/ok/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable("id") long playerId){

        Player player = new Player(playerId, "Metehan Ersoy", 12.12);


        //return new ResponseEntity<>(player, HttpStatus.OK);
        //return ResponseEntity.status(HttpStatus.OK).body(player);
        //return ResponseEntity.ok().body(player);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/status/notfound/{id}")
    public ResponseEntity<?> getNotfound(@PathVariable("id") long playerId){

        Player player = new Player(playerId, "Metehan Ersoy", 12.12);

        if(playerId == 0){

            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payer Not Found!");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    @GetMapping("/status/type/{id}")
    public ResponseEntity<?> getType(@PathVariable("id") long playerId){

        Player player = new Player(playerId, "Metehan Ersoy", 12.12);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(new MediaType("application", "json", Charset.forName("UTF-8")))
                .body(player);
    }


}
