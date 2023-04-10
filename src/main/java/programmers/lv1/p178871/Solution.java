package programmers.lv1.p178871;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        ArrayList<String> result = new ArrayList<>(Arrays.stream(players).collect(Collectors.toList()));

        for (int index = 0; index < players.length; index++) {
            playerMap.put(players[index], index);
        }

        for (String calling : callings) {
            int idx = playerMap.get(calling);

            playerMap.put(calling, idx - 1);

            String item = result.get(idx - 1);
            playerMap.put(item, idx);

            result.remove(idx);
            result.add(idx - 1, calling);
        }

        return result.stream().toArray(String[]::new);
    }
}