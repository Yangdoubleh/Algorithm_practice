package programmers.lv1.p178871;

import java.util.*;

class Solution {

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();

        for (int index = 0; index < players.length; index++) {
            playerMap.put(players[index], index);
        }

        for (String calling : callings) {
            int before = playerMap.get(calling);
            int after = before - 1;

            playerMap.put(calling, after);

            String chased = players[after];
            playerMap.put(chased, before);

            players[after] = calling;
            players[before] = chased;
        }

        return players;
    }
}