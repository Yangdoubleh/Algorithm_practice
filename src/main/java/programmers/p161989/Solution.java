package programmers.p161989;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public int solution(int n, int m, int[] section) {
        // section 을 List 형으로 반환
        List<Integer> sectionList = Arrays.stream(section)
                .boxed().collect(Collectors.toList());

        int result = 0; //결과값

        // 1칸씩 칠할경우 listsize 반환
        if (m == 1) {
            return sectionList.size();
        } else {
            //list가 빌 때까지 반복
            while (!sectionList.isEmpty()) {
                int init = sectionList.get(0); // list 첫번째 값 가져오기
                // list 첫번째값부터 칠하기
                sectionList = sectionList.stream()
                        .filter(index -> index > init + m - 1).collect(Collectors.toList());
                // 횟수 count
                result++;
            }
        }

        return result;
    }
}