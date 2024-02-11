package ru.inno.course;

import java.util.Collection;
import java.util.List;
// Задачу c xml не осилила( если дойду, напишу вам в чате)
public class TestClass {
    public static void main(String[] args) {
        PlayerService service = new PlayerServiceJSON();
        // Создаем Player
        int playerId = service.createPlayer("WinMaster_558");

        // Получаем список всех Players и выводим списорк в консоль
        Collection<Player> players = service.getPlayers();
        System.out.println(players.toString());

        // получаем player по id с выводом его в консоль
        System.out.println(service.getPlayerById(1));

        // Добавляем очков игроку. Выводим player с обновленным счетом
        service.addPoints(1, 100);
        System.out.println(service.getPlayerById(1));

        //Удаляем player по id. Выводим в консоль удаленного игрока
        System.out.println(service.deletePlayer(1));
    }
}
