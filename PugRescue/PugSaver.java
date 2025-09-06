import java.util.Objects;
import java.util.ArrayList;

public class PugSaver {

	// Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(MyArrayList<Dog> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBreed().toLowerCase().contains("golden")) {
				int tempDogPosition = list.size() - 1;
				for (int j = tempDogPosition; j >= 0; j--) {
					if (!list.get(j).getBreed().toLowerCase().contains("golden")) {
						tempDogPosition = j;
						break;
					}
				}
				if (tempDogPosition < i) {
					i = list.size();
					break;
				}
				Dog tempGolden = list.get(i);
				list.set(i, list.get(tempDogPosition));
				list.set(tempDogPosition, tempGolden);
			}
		}
	}
}
