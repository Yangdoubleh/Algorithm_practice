package programmers.lv1.p178871;

import java.util.*;

class Solution {

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();

        for (int index = 0; index < players.length; index++) {
            playerMap.put(players[index], index);
        }

        for (String calling : callings) {
            int idx = playerMap.get(calling);

            playerMap.put(calling, idx - 1);

            String item = players[idx - 1];
            playerMap.put(item, idx);

            players[idx-1] = calling;
            players[idx] = item;
        }

        return players;
    }
}