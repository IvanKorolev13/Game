package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(1,"Ivan", 10);
    Player player2 = new Player(2,"Alex", 10);
    Player player3 = new Player(3,"Max", 5);
    Player player4 = new Player(4,"Anton", 20);
    Player player5 = new Player(5,"Ivan", 25);

    @Test
    void roundBothPlayersHaveEqualStrength() {
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Ivan", "Alex");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundFirstPlayerHasWin() {
        game.register(player1);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Ivan", "Max");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundSecondPlayerHasWin() {
        game.register(player1);
        game.register(player4);

        int expected = 2;
        int actual = game.round("Ivan", "Anton");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundBothPlayersNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Roman", "Petya");
        });
    }

    @Test
    void roundFirstPlayerNotRegistered() {
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Roman", "Alex");
        });
    }

    @Test
    void roundSecondPlayerNotRegistered() {
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Max", "Roman");
        });
    }
    @Test
    void roundPlayerHasExistName() {
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.register(player5);
        });
    }
}