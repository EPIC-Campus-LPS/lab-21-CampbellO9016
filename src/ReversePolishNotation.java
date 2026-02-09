public class ReversePolishNotation {
    static String oper = "()+-*/";

    /**
     * Takes in a postfix expression as a String, evaluates it, and returns the answer.
     * @param input String with valid symbols
     *              and numbers separated by spaces
     * @return int of evaluated Postfix
     * @throws IllegalArgumentException when
     * input is not in correct format.
     */
    static int evaluatePostfix(String input)throws IllegalArgumentException{
        String[] arr = input.split(" ");
        Stack op = new Stack();
        for (String s : arr) {
            if (oper.contains(s)) {
                if(op.size() < 2){
                    throw new IllegalArgumentException();
                }
                int num1 = Integer.parseInt(op.pop());
                int num2 = Integer.parseInt(op.pop());
                op.push(calculate(s, num1, num2));
            }
            else{
                op.push(s);
            }

        }
        return Integer.parseInt(op.peek());
    }

    /**
     * Takes in an infix expression as a String, converts it to a postfix expression and returns it.
     * @param input String with valid symbols and number separated by spaces
     * @return String of converted infix to postfix
     */
    static String infixToPostfix(String input){
        String[] arr = input.split(" ");
        Stack op = new Stack();
        String out = "";
        for (String c : arr) {
            if(oper.contains(c)) {
                if(c.equals("(")){
                    op.push(c);
                }
                else if(c.equals(")")){
                    while(!(op.isEmpty()) && !(op.peek().equals("("))){
                        out += op.pop()+ " ";
                    }
                    op.pop();
                }
                else {
                    while ((!op.isEmpty()) && (oper.indexOf(op.peek()) / 2) >= (oper.indexOf(c) / 2)) {
                        out += op.pop() + " ";
                    }
                    op.push(c);
                }

            }
            else{
                out+= c + " ";
            }
        }
            while(!(op.isEmpty())){
                out += op.pop() + " ";
            }

            return out;
    }

    /**
     * Takes and operator and 2 numbers and performs the operation with those 2 numbers
     * @param opera a valid operator
     * @param num1 a valid number
     * @param num2 a valid number
     * @return String with final calculation
     */
    static String calculate(String opera, int num1, int num2){
        int sum = 0;
        if(opera.equals("-")){
            sum = num2 - num1;
        }
        else if(opera.equals("+")){
            sum = num2 + num1;
        }
        else if(opera.equals("*")){
            sum = num2 * num1;
        }
        else if(opera.equals("/")){
            sum = num2 / num1;
        }
        return Integer.toString(sum);
    }

    static String evaluatePrefix(String input){
        String[] arr = input.split(" ");
        Stack op = new Stack();
        for(String s: arr){
            System.out.println(s);
        }
        for (int i = arr.length- 1; i >= 0 ; i--) {
            if (oper.contains(arr[i])) {
                if(op.size() < 2){
                    throw new IllegalArgumentException();
                }
                int num2 = Integer.parseInt(op.pop());
                int num1 = Integer.parseInt(op.pop());
                op.push(calculate(arr[i], num1, num2));
            }
            else{
                op.push(arr[i]);
            }

        }
        return op.peek();
    }
}
