import java.util.ArrayList;

public class Arithmetic {
    // Evaluates a String exp that has an arithmetic expression, written in classic
    // notation

    public static int evaluate(String exp) {
        return evaluateStout(convertClassicToStout(exp));
    }

    // Returns the result of doing operand1 operation operand2,
    // e.g. operate(5, 2, "-") should return 3
    public static int operate(int operand1, int operand2, String operation) {
        if (operation.equals("*")) {
            return operand1 * operand2;
        }
        if (operation.equals("/")) {
            return operand1 / operand2;
        }
        if (operation.equals("+")) {
            return operand1 + operand2;
        }
        if (operation.equals("-")) {
            return operand1 - operand2;
        }
        if (operation.equals("%")) {
            return operand1 % operand2;
        }
        if (operation.equals("^")) {
            return (int) Math.pow((double) operand1, (double) operand2);
        }
        return 0;
    }

    // Evaluates a String exp that has an arithmetic expression written in STOUT
    // notation
    public static int evaluateStout(String exp) {
        String[] expressions = exp.split(" ");
        MyStack<String> evaluator = new MyStack<>();
        for (String term : expressions) {
            if (!isOperator(term)) {
                evaluator.push(term);
            } else {
                String operator = term;
                int operand2 = Integer.parseInt(evaluator.pop());
                evaluator.push(
                        "" + operate(Integer.parseInt(evaluator.pop()), operand2, operator));
            }
        }
        return Integer.parseInt(evaluator.pop());
    }

    public static boolean isOperator(String exp) {
        if (exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/") || exp.equals("%") || exp.equals("(") || exp.equals(")") || exp.equals("^")) {
            return true;
        }
        return false;
    }

    public static String convertClassicToStout(String exp) {
        String[] classic = exp.split(" ");
        ArrayList<String> stout = new ArrayList<>(classic.length);
        MyStack<String> converter = new MyStack<>();
        for (String term : classic) {
            if (!isOperator(term)) {
                stout.add(term);
            } else {
                String operand = term;
                if (converter.empty() || operand.equals("(")) {
                    converter.push(operand);
                } else if (operand.equals(")")) {
                    while (!converter.peek().equals("(")) {
                        stout.add(converter.pop());
                    }
                    converter.pop();
                } else {
                    if (findOrder(converter.peek()) >= findOrder(operand)) {
                        stout.add(converter.pop());
                        converter.push(operand);
                    } else {
                        converter.push(operand);
                    }
                }
            }
        }
        while (!converter.empty()) {
            stout.add(converter.pop());
        }
        String newExp = "";
        for (String i : stout) {
            newExp += i + " ";
        }
        return newExp;
    }

    public static int findOrder(String term) {
        if (term.equals("+") || term.equals("-")) {
            return 1;
        }
        if (term.equals("*") || term.equals("/") || term.equals("%")) {
            return 2;
        }
        if (term.equals("^") || term.equals("/")) {
            return 3;
        }
        if (term.equals("^")) {
            return 4;
        }
        return 0;
    }

}