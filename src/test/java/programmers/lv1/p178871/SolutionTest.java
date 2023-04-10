package programmers.lv1.p178871;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SolutionTest {

    String[] players, callings, results;

    private final Solution solution;

    SolutionTest() {
        this.solution = new Solution();
    }

    @Test
    void solution() {
        players = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        callings = new String[]{"kai", "kai", "mine", "mine"};
        results = new String[]{"mumu", "kai", "mine", "soe", "poe"};
        String[] answers = solution.solution(players, callings);

        for (int count = 0; count < answers.length; count++) {
            assertThat(results[count]).isEqualTo(answers[count]);
        }
    }
}