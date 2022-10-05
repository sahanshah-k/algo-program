class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i ++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popped = stack.pop();
                if (popped != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}