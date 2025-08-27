import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getBreed().contains("golden")) {
				list.add(0, list.get(i));
				list.remove(i+1);
			}
		}
	}
}
