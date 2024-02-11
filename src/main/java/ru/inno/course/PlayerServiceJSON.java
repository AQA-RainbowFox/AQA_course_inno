package ru.inno.course;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class PlayerServiceJSON implements PlayerService {
    ObjectMapper mapper = new ObjectMapper();
    private final File filePath = Path.of("src/main/resources/library/Player.json").toFile();

    @Override
    public Player getPlayerById(int id) {
        ArrayList<Player> list = null;
        Player resultPlayer = new Player(0, "", 0, false);
        try {
            list = mapper.readValue(filePath, new TypeReference<ArrayList<Player>>() {
            });
            for (Player p : list) {
                if (p.getId() == id) {
                    resultPlayer = p;
                }
            }
        } catch (Exception e) {
        }
        return resultPlayer;
    }

    @Override
    public Collection<Player> getPlayers() {
        try {
            return mapper.readValue(filePath, new TypeReference<ArrayList<Player>>() {
            });
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public int createPlayer(String nickname) {
        ArrayList<Player> list = null;
        int returnId = -1;
        try {
            list = mapper.readValue(filePath, new TypeReference<ArrayList<Player>>() {
            });
        } catch (Exception e) {
            try {
                mapper.writeValue(filePath, List.of(new Player(0, nickname, 0, true)));
                returnId = 0;
            } catch (IOException ex) {
            }
        }
        try {
            if (list != null) {
                int maxId = 0;
                for (Player p : list) {
                    if (p.getId() > maxId) maxId = p.getId();
                }
                list.add(new Player(maxId + 1, nickname, 0, true));
                mapper.writeValue(filePath, list);
                returnId = maxId + 1;
            }
        } catch (Exception e) {
            returnId = -1;
        }
        return returnId;
    }

    @Override
    public Player deletePlayer(int id) {
        ArrayList<Player> list = null;
        Player resultPlayer = new Player(0, "", 0, false);
        try {
            list = mapper.readValue(filePath, new TypeReference<ArrayList<Player>>() {
            });
            Iterator<Player> playerIterator = list.iterator();
            while (playerIterator.hasNext()) {
                Player player = playerIterator.next();
                if (player.getId() == id) {
                    resultPlayer = player;
                    playerIterator.remove();
                }
            }
            mapper.writeValue(filePath, list);
        } catch (Exception e) {
        }
        return resultPlayer;
    }

    @Override
    public int addPoints(int playerId, int points) {
        int score = 0;
        try {
            ArrayList<Player> list = mapper.readValue(filePath, new TypeReference<ArrayList<Player>>() {
            });
            for (Player p : list) {
                if (p.getId() == playerId) {
                    score = p.getPoints() + points;
                    p.setPoints(score);
                }
            }
            mapper.writeValue(filePath, list);
        } catch (Exception e) {
        }
        return score;
    }
}
