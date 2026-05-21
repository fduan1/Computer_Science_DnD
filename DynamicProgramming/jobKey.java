import java.util.Arrays;

public class jobKey {
    private int day;
    private int[] high;
    private int[] low;
    private boolean hilo;


    public jobKey(int day, int[] high, int[]low, boolean hilo) {
        this.day = day;
        this.high = Arrays.copyOf(high, high.length);
        this.low = Arrays.copyOf(low, low.length);
        this.hilo = hilo;
    }

    public int getDay() {
        return day;
    }

    public int[] getHigh() {
        return high;
    }

    public int[] getLow() {
        return low;
    }

    public boolean isHigh() {
        return hilo;
    }

    public void setLow(){
        hilo = false;
    }

    public void setHigh(){
        hilo = true;
    }

    public void setDay(int d) {
        day = d;
    }

  public boolean equals(jobKey other){
    if (this.day == other.getDay()) {
        if (Arrays.equals(this.high, other.getHigh()) && Arrays.equals(this.low, other.getLow())) {
            return true;
        }
    }
    return false;
  }
}
