package isFlipedString;

public class IsFlipedString {

    public static boolean isFlipedString(String s1, String s2) {

        char[]c1 = s1.toCharArray();
        char[]c2 = s2.toCharArray();
        if(c1.length!=c2.length){
            return false;
        }
        if(c1.length==0){
           return true;
        }
        int cha = 0;
        int count = 0;
        for (int i = 0; i < c1.length;) {
                if(c1[(i+cha)%c2.length]!=c2[i]){
                    if(i==c2.length-1){
                        break;
                    }
                    cha++;
                    i=0;
                    count = 0;
                }else {
                    count++;
                    i++;

                }
        }
        if(count == c1.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
       System.out.println(isFlipedString("abcd","acbd"));
    }

}
