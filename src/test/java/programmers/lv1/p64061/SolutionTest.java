package programmers.lv1.p64061;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SolutionTest {

    private int[][] board;

    private int[] moves;

    private final programmers.lv1.p64061.Solution solution;

    SolutionTest() {
        this.solution = new programmers.lv1.p64061.Solution();
    }

    @Test
    void solution() {
        board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        int result = solution.solution(board, moves);
        log.info("result = {}", result);
        assertThat(result).isEqualTo(4);
    }
}