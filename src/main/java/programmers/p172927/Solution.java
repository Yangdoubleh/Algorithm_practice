package programmers.p172927;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int solution(int[] picks, String[] minerals) {
        int havingAxe = Arrays.stream(picks).sum(), //가지고 있는 곡괭이 총합
        diamondAxe = picks[0], //다이아몬드 곡괭이
        ironAxe = picks[1], //철곡괭이
        stoneAxe = picks[2],//돌곡괭이
        result = 0;//결과값

        // 최대 캘수 있는 광물들 List 생성
        List<String> mineralList = Arrays.stream(minerals)
                .limit(havingAxe * 5)
                .collect(Collectors.toList());

        //모두 돌곡괭이로 캤을 경우에 점수 계산
        List<Integer> mineralScore = new ArrayList<>();
        Map<Integer, Integer> sumScore = new HashMap<>();
        int score = 0;
        mineralList.stream()
                .forEach(item ->
                        mineralScore.add(mineral.valueOf(item).usingAxe(Axe.stoneAxe))
                );

        //5개씩 광물들의 점수 합계 구하기
        for (int idx = 0; idx < mineralScore.size(); idx++) {
            score += mineralScore.get(idx);
            if (idx % 5 == 4 || idx == mineralScore.size()-1) {
                sumScore.put(idx/5, score);
                score = 0;
            }
        }

        //합계 Map 오름차순 정렬
        List<Integer> scoreKeySet = new ArrayList<>(sumScore.keySet());
        Collections.sort(scoreKeySet, ((o1, o2) -> (sumScore.get(o2).compareTo(sumScore.get(o1)))));

        //광물 합 구하기
        List<Integer> scoreList = new ArrayList<>();
        for (int idx : scoreKeySet) {
            Axe usingAxe = diamondAxe > 0 ? Axe.diamondAxe
                    : ironAxe > 0 ? Axe.ironAxe : Axe.stoneAxe;

           mineralList.stream()
                    .skip(idx * 5)
                    .limit(5)
                    .forEach(item -> scoreList.add(mineral.valueOf(item).usingAxe(usingAxe)));

            if (usingAxe.equals(Axe.diamondAxe)) {
                diamondAxe--;
            } else if (usingAxe.equals(Axe.ironAxe)) {
                ironAxe--;
            } else {
                stoneAxe--;
            }
        }

        return scoreList.stream()
                .mapToInt(Integer::valueOf).sum();
    }

    enum mineral {
        diamond{
            @Override
            int usingAxe(Axe axe) {
                return axe.equals(Axe.stoneAxe) ? 25
                        : axe.equals(Axe.ironAxe) ? 5 : 1;
            }
        },
        iron{
            @Override
            int usingAxe(Axe axe) {
                return axe.equals(Axe.stoneAxe) ? 5 : 1;
            }
        },
        stone{
            @Override
            int usingAxe(Axe axe) {
                return 1;
            }
        };

        abstract int usingAxe(Axe axe);
    }

    enum Axe {
        diamondAxe,
        ironAxe,
        stoneAxe
    }
}