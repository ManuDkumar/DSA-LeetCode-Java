public class LengthOfLastWord {
    public int lengthOfWorld(String s){
        int n = s.length() - 1;
        int maxLength = 0;
        while (n >= 0 && s.charAt(n) == ' ') {
            n--;
        }
        while (n >= 0 && s.charAt(n) != ' ') {
            n--;
            maxLength++;
        }
        return maxLength;
    }
}
