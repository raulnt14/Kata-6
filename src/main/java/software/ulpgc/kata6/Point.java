package software.ulpgc.kata6;

public record Point(int i, int j) {
    public static Point at(int i, int j) {
        return new Point(i, j);
    }

    public Point add(Point offset) {
        return new Point(this.i + offset.i, this.j + offset.j);
    }
}
