import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

public class MiniGPT {
	HashMap<String, ArrayList<String>> probabilities;
	int chainOrder;


	public MiniGPT(String fileName, int chainOrder) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			this.chainOrder = chainOrder;
			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
			int charAsInt;
			String charSequence = "";
			// Read until the end of the stream (-1 is returned)
			while ((charAsInt = reader.read()) != -1) {
				// Cast the integer value to a character
				char character = (char) charAsInt;
				if (charSequence.length() < chainOrder) {
					charSequence += character;
				} else if (charSequence.length() == chainOrder) {
					if (!map.containsKey(charSequence)) {
						map.put(charSequence, new ArrayList<>());
					}
					map.get(charSequence).add(character + "");
					charSequence += character;
					charSequence = charSequence.substring(1);
				}
			}
			probabilities = map;
		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
		}
	}


	public void generateText(String outputFileName, int numChars) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
			String output = "Then wear the gold hat, if that will move her;".substring(0, chainOrder);
			for (int i = chainOrder; i < numChars; i++) {
				output += predictNextState(output.substring(i - chainOrder, i));
			}
			writer.write(output);
		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
		}
	}

	public String predictNextState(String currentState) {
		ArrayList<String> next = probabilities.get(currentState);
		int randomNum = (int) (Math.random() * next.size());
		return next.get(randomNum);
	}
}
