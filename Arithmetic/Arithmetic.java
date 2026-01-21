public class Arithmetic {
    // Evaluates a String exp that has an arithmetic expression, written in classic
    // notation

    public static int evaluate(String exp) {
        return evaluateStout(convertClassicToStout(exp));
    }

    // Returns the result of doing operand1 operation operand2,
    // e.g. operate(5, 2, "-") should return 3
    public static int operate(int operand1, int operand2, String operation) {
        switch (operate(operand1, operand2, operation)) {
            case 1:
                operation.equals("*");
                return operand1 * operand2;
            case 2:
                operation.equals("/");
                return operand1 / operand2;
            case 3:
                operation.equals("+");
                return operand1 + operand2;
            case 4:
                operation.equals("-");
                return operand1 - operand2;
            case 5:
                operation.equals("%");
                return operand1 % operand2;
        }
        return 0;
    }

    // Evaluates a String exp that has an arithmetic expression written in STOUT
    // notation
    public static int evaluateStout(String exp) {
        String[] expressions = exp.split(" ");
        MyStack<String> evaluator = new MyStack<>();
        int evaluation = 0;
        for (String term : expressions) {
            if (!isOperator(exp)) {
                evaluator.push(term);
            } else {
                String operand = term;
                evaluator.push(
                        "" + operate(Integer.parseInt(evaluator.pop()), Integer.parseInt(evaluator.pop()), operand));
            }
        }
        return Integer.parseInt(evaluator.pop());
    }

    public static boolean isOperator(String exp) {
        if (exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/") || exp.equals("%")) {
            return true;
        }
        return false;
    }

    public static String convertClassicToStout(String exp) {

        return "";
    }
}