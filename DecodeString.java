// 394. Decode String


class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.equals("")) {
            return s;
        }

        Stack<String> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // put substring to stack until meet "]"
            if (s.charAt(i) != ']') {
                stack.push(s.substring(i, i + 1));
                continue;
            }
            String str = "";
            String num = "";
            // pop until meet "[" and construct string
            while(!stack.peek().equals("[")) {
                str = stack.pop() + str;
            }
            stack.pop();
            // pop until empty or "[" and construct number
            while(!stack.isEmpty() && isNum(stack.peek())) {
                num = stack.pop() + num;
            }
            // construct decoded substring
            int number = num.equals("") ? 1 : Integer.parseInt(num);
            String string = "";
            for (int j = 0; j < number; j++) {
                string += str;
            }
            // put back to stack
            stack.push(string);
        }
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    private boolean isNum(String s) {
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            return true;
        }
        return false;
    }
}