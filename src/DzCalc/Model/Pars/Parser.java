package DzCalc.Model.Pars;


import java.util.*;

public class Parser implements Parsering {
    private Stack<String> operations;
    private List<String> postfixForm;
    private StringBuilder inputExampleAndWhitespace;
    private String[] arraysInputEx;
    private Map<String, Integer> prioritizingOperation;


    public Parser() {
        operations = new Stack<>();
        prioritizingOperation = new HashMap<>();
        prioritizingOperation.put("(", 1);
        prioritizingOperation.put("-", 2);
        prioritizingOperation.put("+", 2);
        prioritizingOperation.put("*", 3);
        prioritizingOperation.put("/", 3);
        prioritizingOperation.put("~", 4);
    }

    @Override
    public List<String> pars(String text) {
        postfixForm = new ArrayList<>();
        arraysInputEx = createArrInputEx(text);
        return infixToPostfix();
    }

    private String[] createArrInputEx(String text) {
        inputExampleAndWhitespace = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
           if (Character.isDigit(text.charAt(i))){
               inputExampleAndWhitespace.append(text.charAt(i++));
               while (i < text.length() && (Character.isDigit(text.charAt(i)) || '.' == text.charAt(i))){
                   inputExampleAndWhitespace.append(text.charAt(i++));
               }
               inputExampleAndWhitespace.append(" ");
               i--;
           } else {
               inputExampleAndWhitespace.append(text.charAt(i)).append(" ");
           }
        }
        return inputExampleAndWhitespace.toString().split(" ");
    }

    private List<String> infixToPostfix() {
        for (int i = 0; i < arraysInputEx.length; i++) {
            if (arraysInputEx[i].matches("\\d*\\.?\\d*")) {
                postfixForm.add(arraysInputEx[i]);
            } else {
                if (operations.isEmpty() || "(".equals(arraysInputEx[i])) {
                    operations.add(arraysInputEx[i]);
                    continue;
                }

                if (")".equals(arraysInputEx[i])) {
                    while (!"(".equals(operations.peek())) {
                        postfixForm.add(operations.pop());
                    }
                    operations.pop();
                    continue;
                }

                //пока в стеке есть более приоритетные опперации
                while (!operations.isEmpty() &&
                        prioritizingOperation.get(arraysInputEx[i]) <= prioritizingOperation.get(operations.peek())) {
                    postfixForm.add(operations.pop());
                }
                operations.push(arraysInputEx[i]);
            }
        }
        while (!operations.isEmpty()) {
            postfixForm.add(operations.pop());
        }
        return postfixForm;
    }


}
