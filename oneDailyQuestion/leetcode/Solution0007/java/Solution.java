package oneDailyQuestion.Solution0007.java;




/**
 * 7. 整数反转
 * https://leetcode.cn/problems/reverse-integer/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseNum(2147483641));
        System.out.println(Integer.MAX_VALUE);
    }


    /**
     * 转换为字符串反转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length();i++)
            ans.append(s.charAt(i));
        ans.reverse();
        if (x<0){
            ans.deleteCharAt(ans.length()-1);
            ans.insert(0,"-");
            String a = String.valueOf(ans);
            double rev = Double.parseDouble(a);
            if(rev<Integer.MIN_VALUE){
                return 0;
            }else{
                return (int)rev;
            }
        }else{
            String a = String.valueOf(ans);
            double rev = Double.parseDouble(a);
            if (rev > Integer.MAX_VALUE){
                return 0;
            }else{
                return (int)rev;
            }
        }
    }

    public static int reverseNum(int x) {
        int rev = 0;
        while(x!=0){
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int dig = x%10;
            x = x/10;
            rev = rev*10 +dig;
        }
        return rev;
    }
}
