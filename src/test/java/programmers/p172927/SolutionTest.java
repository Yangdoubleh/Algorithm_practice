package programmers.p172927;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    int[] picks;

    String[] minerals;

    private final Solution solution;

    SolutionTest() {
        this.solution = new Solution();
    }

    @Test
    void Test1() {
        picks = new int[]{1, 3, 2};
        minerals = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        assertThat(solution.solution(picks, minerals)).isEqualTo(12);
    }

    @Test
    void Test2() {
        picks = new int[]{0, 1, 1};
        minerals = new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        assertThat(solution.solution(picks, minerals)).isEqualTo(50);
    }
}