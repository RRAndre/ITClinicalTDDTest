import java.util.HashMap;
import java.util.Map;

public class UppercaseLettersFilter {
        private int N = 1;
        private String text = null;
    public String filterUppercase(int N, String text) {
        this.N = N;
        this.text = text;

        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> charCounterMap = new HashMap<>();

        if (text.length() == 0) {
            throw new IllegalArgumentException("Please provide a text to be filtered.");
        }
        if (N <= 0 || N >= text.length()) {
            throw new IllegalArgumentException("N needs to be a positive integer, and smaller than " + text.length());
        }
        else {
            char[] chars = text.toCharArray();
            for (int i = N - 1; i < chars.length; i += N) {
                char ch = chars[i];
                if (!Character.isLowerCase(ch) && !Character.isWhitespace(ch)) {
                    builder.append(ch);
                    if(!charCounterMap.containsKey(ch)){
                        charCounterMap.put(ch, 1);
                    }
                    else {
                        charCounterMap.put(ch,charCounterMap.get(ch) + 1);
                    }
                }
            }
            String resultString = builder.toString();
            System.out.println(resultString);
            for (Map.Entry entry : charCounterMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            return resultString;
        }
    }
    public void checkInvalidCondition(){
        if (text.length() == 0) {
            throw new IllegalArgumentException("Please provide a text to be filtered.");
        }
        if (N <= 0 || N >= text.length()) {
            throw new IllegalArgumentException("N needs to be a positive integer, and smaller than " + text.length());
        }
    }
}
