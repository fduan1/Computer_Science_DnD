
public class PugSaverTester {

    public static void main(String[] args) {
        // add and rescuePugs (set, get)

        MyArrayList<Dog> dogs = new MyArrayList<Dog>();
        Dog poodle = new Dog("lassie", "poodle");
        dogs.add(new Dog("cat", "pug"));
        dogs.add(new Dog("henry", "golden retriver"));
        dogs.add(new Dog("bob", "pug"));
        dogs.add(new Dog("sam", "shitzu"));
        dogs.add(new Dog("buddy", "terrier"));
        dogs.add(new Dog("lacy", "daschund"));
        dogs.add(poodle);
        dogs.add(new Dog("goldie", "golden doodle"));
        dogs.add(new Dog("gary", "golden doodle"));
        dogs.add(new Dog("billy", "pug"));
        dogs.add(new Dog("george", "pug"));
        dogs.add(new Dog("bart", "german shephard"));
        dogs.add(new Dog("lexie", "pug"));
        dogs.add(new Dog("jess", "golden doodle"));
        
        PugSaver.rescuePugs(dogs);
        System.out.println(dogs);

        //remove
        dogs.remove(1);
        System.out.println("\n"+dogs);
        dogs.remove(poodle);
        System.out.println(dogs.contains(poodle) + "" + dogs.size());

        // add at index pt
        dogs.add(2,poodle);
        System.out.println(dogs.contains(poodle) + "" + dogs.size());
        System.out.println(dogs);

        dogs.add(1, null);
        System.out.println(dogs.size());
        System.out.println(dogs);


        

    }

}
