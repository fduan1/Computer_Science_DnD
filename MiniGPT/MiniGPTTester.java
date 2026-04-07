public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT theGreaterGatsby = new MiniGPT("lawsuit.txt", 8);
        theGreaterGatsby.generateText("new lawsuit", 10000);
    }

}
