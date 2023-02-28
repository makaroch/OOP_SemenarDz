package DzCalc.Model;

import java.util.Stack;

class Checking {
    private Stack<Character> stack;
    private StringBuilder st;

    Checking() {
        stack = new Stack<>();
        st = new StringBuilder();
    }

    public boolean check(String example) {
        return checkOperators(example) && checkBracket(example);
    }

    // проверка на правильность расстановки скобок
    private boolean checkBracket(String example) {
        for (int i = 0; i < example.length(); i++) {
            if (example.charAt(i) == '(') {
                stack.push('(');
            } else if (example.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        return false;
    }

    // Проверка на правильную расстановку операторов
    private boolean checkOperators(String example) {
        char currentChar;
        char nextChar;
        for (int i = 0; i < example.length() - 1; i++) {
            currentChar = example.charAt(i);
            nextChar = example.charAt(i + 1);
            if ((currentChar == '+' || currentChar == '-' || currentChar == '*'
                    || currentChar == '/' || currentChar == '(') &&
                    (nextChar == '+' || nextChar == '-' || nextChar == '*' || nextChar == '/')) {
                return false;
            }
        }
        return true;

    }

}
