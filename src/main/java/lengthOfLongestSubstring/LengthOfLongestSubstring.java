package lengthOfLongestSubstring;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        int max = 1;
        char[] chars = s.toCharArray();
        if(chars.length ==0){
            return 0;
        }
        int lastIndex = 1;
        for (int n = 0;n<chars.length-1;) {
            for(int t = n;t<lastIndex;t++){
                //意味着以n位置开头的字串，到此位置结束了，计算最长长度
                //最长长度= lastIndex-n
                if(chars[t] == chars[lastIndex]){
                    int length = lastIndex-n;
                    if(max<length){
                        max = length;
                    }
                    n++;
                    lastIndex=n+1;
                    break;
                }
                //T到头了，且last与t不相等，则lastIndex++
                if(lastIndex-t==1&&chars[t] != chars[lastIndex]){
                    lastIndex++;
                    break;
                }
            }
            //如果此时lastIndex超出长度，循环结束返回max
            if(lastIndex == chars.length){
                int length = lastIndex-n;
                if(max<length){
                    max = length;
                }
                return max;
            }
            //如果lastIndex = chars.length；说明到头了
            if(chars.length-n<=max){
//                int length = lastIndex-n;
//                if(max<length){
//                    max = length;
//                }
                return max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[] chars = "".toCharArray();
        System.out.println(lengthOfLongestSubstring("111"));
    }

}
