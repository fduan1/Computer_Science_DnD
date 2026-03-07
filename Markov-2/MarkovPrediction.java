import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkovPrediction {

    // Please define your own variables and data structures
    HashMap<String, ArrayList<String>> map;

    //
    public HashMap<String, ArrayList<String>> readData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            HashMap<String, ArrayList<String>> weatherHashMap = new HashMap<String, ArrayList<String>>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] day = line.split(",");
                if (!weatherHashMap.containsKey(day[0])) {
                    weatherHashMap.put(day[0], new ArrayList<String>());
                }
                weatherHashMap.get(day[0]).add(day[1]);
            }
            map = weatherHashMap;
            return weatherHashMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {
        ArrayList<String> probabilities = map.get(currentState);
        int randomNum = (int) (Math.random() * probabilities.size());
        return probabilities.get(randomNum);
    }

}