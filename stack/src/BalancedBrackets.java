import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(balancedBrackets("([])(){}(())()()"));
    }

    public static boolean balancedBrackets(String str) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put('}', '{');
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character bracket = str.charAt(i);
            if (openingBrackets.indexOf(bracket) != -1) {
                stack.add(bracket);
            } else if (closingBrackets.indexOf(bracket) != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.get(stack.size() - 1) == matchingBrackets.get(bracket)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
