
public class PugSaverTester {

    public static void main(String[] args) {
        MyArrayList<Dog> dogs = new MyArrayList<Dog>();
        dogs.add(new Dog("cat", "pug"));
        dogs.add(new Dog("henry", "golden retriver"));
        dogs.add(new Dog("bob", "pug"));
        dogs.add(new Dog("sam", "shitzu"));
        dogs.add(new Dog("buddy", "terrier"));
        dogs.add(new Dog("lacy", "daschund"));
        dogs.add(new Dog("lassie", "poodle"));
        dogs.add(new Dog("goldie", "golden doodle"));
        dogs.add(new Dog("gary", "golden doodle"));
        dogs.add(new Dog("billy", "pug"));
        dogs.add(new Dog("george", "pug"));
        dogs.add(new Dog("bart", "pug"));
        dogs.add(new Dog("lexie", "pug"));
        dogs.add(new Dog("jess", "golden doodle"));


        PugSaver.rescuePugs(dogs);
        System.out.println(dogs);
    }

}
