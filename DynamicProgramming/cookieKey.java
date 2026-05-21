import java.util.Arrays;

public class cookieKey {
 private int coordinate;
    private int[][] map;


    public cookieKey(int coordinate, int[][] map) {
        this.coordinate = coordinate;
        this.coordinate = coordinate;

    }

    public int getCoords() {
        return coordinate;
    }

    public int[][] getMap() {
        return map;
    }

    public void setCoords(int coord) {
        coordinate = coord;
    }

    public void setNext(int[][] m) {
        map = m;
    }

  public boolean equals(cookieKey other){
    if (this.coordinate == other.getCoords()) {
        if (Arrays.equals(this.map, other.getMap())) {
            return true;
        }
    }
    return false;
  }
}
