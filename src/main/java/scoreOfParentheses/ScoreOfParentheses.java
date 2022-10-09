package scoreOfParentheses;


public class ScoreOfParentheses {

    public static int scoreOfParentheses(String s) {

        String[] st = new String[s.length()];
        char[] chars = s.toCharArray();
        int index = 1;
        int stIndex = 0;
        st[0] = String.valueOf(chars[0]);
        while (index<s.length()){
            if(chars[index]==40){
                st[stIndex+1] = String.valueOf(chars[index]);
                stIndex++;
            }else {
            //如果配对成功且中间是个数字，则将数字乘以2
                if(stIndex>0 && st[stIndex-1].equals("(")&&!st[stIndex].equals("(")){
                    int i = Integer.parseInt(st[stIndex]) * 2;
                    if(stIndex>1 && !st[stIndex-2].equals("(") ){
                        int v = Integer.parseInt(st[stIndex-2]);
                        st[stIndex-2] = String.valueOf(v+i);
                        stIndex = stIndex-2;
                    }else {
                        st[stIndex-1] = String.valueOf(i);
                        stIndex--;
                    }

                }
                //如果配对成功中间无数字，且前面无数字，则在当前位置存1
                if( st[stIndex].equals("(")){
                    int i = 1;
                    if(stIndex>0 && !st[stIndex-1].equals("(") ){
                        int v = Integer.parseInt(st[stIndex-1]);
                        st[stIndex-1] = String.valueOf(v+i);
                        stIndex = stIndex-1;
                    }else {
                        st[stIndex] = String.valueOf(i );
                    }
                }
            }
            index++;
        }
        return Integer.parseInt(st[0]);
    }


    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }

}
