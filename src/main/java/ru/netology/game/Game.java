package ru.netology.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        if (findByName(player.getName()) != null) { //name uniqueness check
            throw new NotRegisteredException(
                    "Player with name: " + player + " exists "
            );
        }
        players.put(player.getName(), player); //key is name
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1); //search player by name
        Player player2 = findByName(playerName2);

        if ((player1 == null) && (player2 == null)) { //massage when both players are not registered
            throw new NotRegisteredException(
                    "Players with names: " + playerName1 + " and " + playerName2 + " are not registered"
            );
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " is not registered"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " is not registered"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String name) {
        for (String key : players.keySet()) {
            if (key.equals(name)) {
                return players.get(key);
            }
        }
        return null;
    }
}
