package test;

import org.junit.Test;
import static test.BoardTest.Cases.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    @Test
    public void should_return_empty_board_given_3x3_empty_board() {
        assertThat(new Board(empty3x3).next().toString()).isEqualTo(empty3x3);
    }

    @Test
    public void should_return_empty_board_given_3x3_board_with_one_alive_cell() {
        assertThat(new Board(oneAliveCell3x3).next().toString()).isEqualTo(empty3x3);
    }

    @Test
    public void should_return_empty_board_given_4x4_board_with_one_alive_cell() {
        assertThat(new Board(oneAliveCell4x4).next().toString()).isEqualTo(empty4x4);
    }

    @Test
    public void should_return_a_board_with_square_live_cell_3x3_given_square_live_cell_3x3() {
        assertThat(new Board(squareLiveCell3x3).next().toString()).isEqualTo(squareLiveCell3x3);
    }

    @Test
    public void should_return_a_board_with_square_live_cell_3x3_given_triangle_live_cell_3x3() {
        assertThat(new Board(triangleLiveCell3x3).next().toString()).isEqualTo(squareLiveCell3x3);
    }

    public static class Cases {
        static final String empty3x3 = """
                ...
                ...
                ...
                """;

        static final String oneAliveCell3x3 = """
                ...
                ..X
                ...
                """;

        static final String squareLiveCell3x3 = """
                .XX
                .XX
                ...
                """;

        static final String triangleLiveCell3x3 = """
                .X.
                .XX
                ...
                """;

        static final String empty4x4 = """
                ....
                ....
                ....
                ....
                """;

        static final String oneAliveCell4x4 = """
                ....
                ..X.
                ....
                ....
                """;
    }
}
