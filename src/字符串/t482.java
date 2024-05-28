package 字符串;

/**
 * @ClassName t482
 * @author: 周益和
 * @qq: 1552951165
 * @date: 2024/5/28
 * @description:
 */
public class t482 {
    
    public static String licenseKeyFormatting(String s, int k) {
        int len = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(len >= 0){
            if(s.charAt(len) == '-'){
                len--;
            }else if(count == k){
                count = 0;
                sb.append('-');
            }else{
                if(s.charAt(len) < 97){
                    sb.append((char)(s.charAt(len)));
                }else{
                    sb.append((char)(s.charAt(len) - 32));
                }
                count++;
                len--;
            }
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "--a-a-";
        System.out.println("licenseKeyFormatting = " + licenseKeyFormatting(s, 2));
    }
}
