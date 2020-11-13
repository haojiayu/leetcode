package longPressedName;

public class Solution {

    public boolean isLongPressedName(String name, String typed) {

        char[] n = name.toCharArray();
        char[] t = typed.toCharArray();
        if (n.length > t.length) {
            return false;
        }
        int i1 = 0;
        int i2 = 0;
        while (i2 < t.length) {
            if (i1 >= n.length  ) {
                if(t[i2] == n[n.length - 1]){
                    i2++;
                    continue;
                }else{
                    return false;
                }

            }
            //同一个字母 ，同一个位置
            if (n[i1] == t[i2]) {
                i1++;
                i2++;
                continue;
            }
            if (i1 > 0 && n[i1] != t[i2] && n[i1 - 1] == t[i2]) {
                i2++;
                continue;
            }
            return false;
        }
        if (i1 < n.length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        "alex"
//        "aaleex"
        String s1 = "alex";
        String s2 = "alexxr";
        System.out.println(s.isLongPressedName(s1, s2));
    }

}
