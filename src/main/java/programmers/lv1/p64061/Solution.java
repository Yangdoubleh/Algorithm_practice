package programmers.lv1.p64061;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public int solution(int[][] board, int[] moves) {
        int result = 0;
        List<LinkedList<Integer>> boardList = new ArrayList<>();

        //2차원 배열 List로 변경
        for (int line = 0; line < board.length; line++) {
            LinkedList<Integer> itemList = new LinkedList<>();
            for (int item = 0; item < board.length; item++) {
                int itemcode = board[item][line];
                if (itemcode > 0) {
                    itemList.add(itemcode);
                }
            }
            boardList.add(itemList);
        }

        LinkedList<Integer> pickupList = new LinkedList<>();

        //moves에 맞춰서 리스트에서 값 가져오기
        for (int move : moves) {
            int index = move - 1;
            if (!boardList.get(index).isEmpty()) {
                int pickup = boardList.get(index).pop();
                if (!pickupList.isEmpty() && pickupList.getLast().equals(pickup)) {
                    result += 2;
                    pickupList.pollLast();
                } else {
                    pickupList.add(pickup);
                }
            }
        }

        return result;
    }
}