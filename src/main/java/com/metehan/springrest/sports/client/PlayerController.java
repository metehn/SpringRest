package com.metehan.springrest.sports.client;

import com.metehan.springrest.sports.data.Player;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class PlayerController {

    @GetMapping("/client/player/{id}")
    @ResponseBody
    public String getPlayer(@PathVariable("id") long playerId) {
        String url = "http://localhost:8080/sports/player/" + playerId;

        RestTemplate restTemplate = new RestTemplate();
        /*
        String json = restTemplate.getForObject(url, String.class);
        System.out.println("JSON" + json);
        */
        /*
        Player player = restTemplate.getForObject(url, Player.class);
        System.out.println("JSON" + player.toString());
         */
        ResponseEntity<Player> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Player.class);
        Player player = response.getBody();
        System.out.println("JSON" + player.toString());

        return "JSON Alındı";
    }

    @GetMapping("/client/players")
    @ResponseBody
    public String getPlayer() {
        String url = "http://localhost:8080/sports/players";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Player>> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Player>>() {
        });
        List<Player> playerList = response.getBody();

        for (Player p : playerList){
            System.out.println(p.toString());

        }

        return "Oyuncular: " + playerList.size();
    }

    @GetMapping("/client/send")
    @ResponseBody
    public String sendPlayer(@RequestParam(name ="name") String playerName,
                            @RequestParam(name = "score") double averageScore ){

        String url = "http://localhost:8080/sports/player";
        Player player = new Player(0, playerName, averageScore);

        RestTemplate restTemplate = new RestTemplate();
        Player result = restTemplate.postForObject(url, player, Player.class);
        return "Yollandı: " + result.getPlayerId() + " " + result.getPlayerName();
    }

    @GetMapping("/client/change")
    @ResponseBody
    public String changePlayer(@RequestParam(name ="name") String playerName,
                             @RequestParam(name = "score") double averageScore ){

        String url = "http://localhost:8080/sports/player";
        Player player = new Player(0, playerName, averageScore);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Boolean> response  = restTemplate.exchange( url, HttpMethod.PUT, new HttpEntity<Player>( player), Boolean.class);
        boolean updated = response.getBody();

        return "Değiştirildi: " + updated;
    }

    @GetMapping("/client/delete/{id}")
    @ResponseBody
    public String deletePlayer(@PathVariable(name ="id") long playerId ){

        String url = "http://localhost:8080/sports/player/" + playerId;

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange( url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);

        return "Oyuncu silindi: " + playerId;
    }

}