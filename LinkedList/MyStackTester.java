public class MyStackTester {
    public static void main(String[] args) {
        MyStack<String> s = new MyStack<>();
        System.out.println(s.empty());
        s.push("a");
        System.out.println(s.peek());
        System.out.println(s.empty());
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");
        s.push("f");
        s.push("g");
        while (!s.empty()) {
            System.out.println(s.peek());
            System.out.println(s.pop());
        }
        System.out.println(s.peek());
        System.out.println(s.pop());

    }

}
