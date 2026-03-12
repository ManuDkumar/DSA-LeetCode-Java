import java.util.ArrayList;
import java.util.List;
public class LetterCombinationOfPhoneNumber {

    private static final String[] MAP = {
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(result, current, 0, digits, MAP);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder current, int index, String digits, String[] kewpad) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = MAP[digits.charAt(index) - '0'];

        for(char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, current, index + 1, digits, kewpad);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
