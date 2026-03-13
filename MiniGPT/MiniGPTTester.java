public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT theGreaterGatsby = new MiniGPT("thegreatgatsby.txt", 8);
        theGreaterGatsby.generateText("The Greater Gatsby", 10000);
    }

}
