package com.metehan.springrest.sports.data;

import lombok.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Player {

    private long playerId;
    private String playerName;
    private double averageScore;
}
