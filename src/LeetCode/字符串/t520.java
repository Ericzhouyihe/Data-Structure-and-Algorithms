package LeetCode.字符串;

public class t520 {
    public static boolean detectCapitalUse(String word) {
        if(word.length() < 2){
            return true;
        }

        boolean c1 = word.charAt(0) >= 65 && word.charAt(0) <= 90 ? true:false;
        boolean c2 = word.charAt(1) >= 65 && word.charAt(1) <= 90 ? true:false;

        if(c1 == false && c2 == true){
            return false;
        }

        for(int i = 2;i < word.length();i++){
            if(c1 == true && c2 == true){
                if(word.charAt(i) >= 97 && word.charAt(i) <= 122){
                    return false;
                }
            }else{
                if(word.charAt(i) >= 65 && word.charAt(i) <= 90){
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "gfa fdasf dasf";
        s.length();
    }
}
