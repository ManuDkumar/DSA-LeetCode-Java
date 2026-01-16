class Palindrome {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int y=0;
        int i =x;
        while(i>0){
            int add = i%10;
            y = y*10 + add;
            i = i/10;
        }
        return x==y;
    }
}
