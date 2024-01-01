package software.ulpgc.kata6;

import java.util.Arrays;
import java.util.List;

import static software.ulpgc.kata6.Point.at;

public class Board {
    private static final char Alive = 'X';
    private static final char Dead = '.';
    private final String[] states;

    public Board(String states) {
        this.states = states.split("\n");
    }

    public interface Cell {
        int neighbours();
        boolean isAlive();
    }

    public Board next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                sb.append(shouldBeAlive(cell(at(i,j))) ? Alive : Dead);
            }
            sb.append('\n');
        }
        return new Board(sb.toString());
    }

    private int rows() {
        return states.length;
    }

    private int cols() {
        return states[0].length();
    }

    @Override
    public String toString() {
        return String.join("\n", states) + "\n";
    }

    private boolean shouldBeAlive(Cell cell) {
        return cell.isAlive() ? is(cell.neighbours(), 2, 3) : is(cell.neighbours(), 3);
    }

    private static boolean is(int value, int... options) {
        return Arrays.stream(options).anyMatch(o->o==value);
    }

    private static final List<Point> offsets = List.of(
            at(-1,-1), at(-1,0), at(-1,1),
            at(0,-1), at(0,1),
            at(1,-1), at(1,0), at(1,1)
    );
    private Cell cell(Point point) {
        return new Cell() {
            @Override
            public int neighbours() {
                return (int) offsets.stream()
                        .map(point::add)
                        .filter(this::isInBounds)
                        .filter(p -> cell(p).isAlive())
                        .count();
            }

            private boolean isInBounds(Point point) {
                return point.i() >= 0 && point.j() >= 0 && point.i() < cols() && point.j() < rows();
            }
            @Override
            public boolean isAlive() {
                return states[point.i()].charAt(point.j()) == Alive;
            }
        };
    }
}
