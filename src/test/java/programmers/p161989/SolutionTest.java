package programmers.p161989;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class SolutionTest {

    int n, m;
    int[] section;

    private final Solution solution;

    SolutionTest() {
        this.solution = new Solution();
    }

    @Test
    void Test1() {
        n = 8;
        m = 4;
        section = new int[]{2, 3, 6};
        int result = solution.solution(n, m, section);
        log.info("result = {}", result);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void Test2() {
        n = 5;
        m = 4;
        section = new int[]{1, 3};
        int result = solution.solution(n, m, section);
        log.info("result = {}", result);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void Test3() {
        n = 4;
        m = 1;
        section = new int[]{1, 2, 3, 4};
        int result = solution.solution(n, m, section);
        log.info("result = {}", result);
        Assertions.assertThat(result).isEqualTo(4);
    }
}