import java.util.Arrays;

public class scavKey {
    private int index;
    private int[] points;
    private int[] times;


    public scavKey(int index, int[] points, int[] times) {
        this.points = points;
        this.index = index;
        this.times = times;

    }

    public int getIndex() {
        return index;
    }

    public int[] getTimes() {
        return times;
    }



    public int[] getPoints() {
        return points;
    }

    public void setIndex(int i) {
        index = i;
    }


    public boolean equals(scavKey other) {
        if (this.index == other.getIndex()) {
            if (Arrays.equals(this.points, other.getPoints()) && Arrays.equals(this.times, other.getTimes())) {
                return true;
            }
        }
        return false;
    }

}
