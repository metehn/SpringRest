package com.metehan.springrest.sports.service;

import com.metehan.springrest.sports.data.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerResource {

    @GetMapping("/sports/player/{id}")
    public Player getPlayer(@PathVariable("id") long playerId) {

        Player player =  Player.builder().playerId(playerId).playerName("Metehan Ersoy").averageScore(12.04).build();

        return player;
    }

    @GetMapping("/sports/players")
    public List<Player> getPlayers() {

        List<Player> list = new ArrayList<>();

        Player player =  Player.builder().playerId(101).playerName("Metehan Ersoy").averageScore(12.04).build();
        Player player2 =  Player.builder().playerId(102).playerName("Metehan Ersoy2").averageScore(12.02).build();
        Player player3 =  Player.builder().playerId(103).playerName("Metehan Ersoy3").averageScore(13.03).build();

        list.add(player);
        list.add(player2);
        list.add(player3);

        return list;
    }

    @PostMapping("/sports/player")
    public Player  postPlayer(@RequestBody Player player){
        System.out.println(player.toString());
        player.setPlayerId(803);
        return player;
    }

    @PutMapping("/sports/player")
    public boolean  putPlayer(@RequestBody Player player){
        System.out.println("Güncelleniyor " + player.toString());
        player.setPlayerId(803);
        return true;
    }

    @DeleteMapping("/sports/player/{id}")
    public void  deletePlayer(@PathVariable("id") long playerId){
        System.out.println("Siliniyor: " + playerId );

    }

}