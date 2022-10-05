package rotatedDigits;

/**
 * 788
 * 旋转的数字 https://leetcode.cn/problems/rotated-digits/
 *
 */
public class RotatedDigits {
    //个人思路：
    //1、求出好数 2、比较好数与原数大小 3、计数

    //官方思路：
    //
    public static int rotatedDigits(int n) {
        int count = 0;
        //转换
        for (int i = 1; i <= n; i++) {
            int good = 0;
            int j = 10000;

            for (int m = 0;m<=4 ;m++){
                int vue = i/j%10;
                if(vue==1||vue==8||vue==0){
                    good = good+ vue*j;
                }else
                if(vue==2){
                    good = good+ 5*j;
                }else
                if(vue==5){
                    good = good+ 2*j;
                }else
                if(vue==6){
                    good = good+ 9*j;
                }else
                if(vue==9){
                    good = good+ 6*j;
                }else{
                    good=0;
                    break;
                }
                j=j/10;
            }
            if(good!=0&&good!=i){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }

}
