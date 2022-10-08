package threeEqualParts;

import java.util.Arrays;

public class ThreeEqualParts {

    //实现二，按官方实现方式优化
    public static int[] threeEqualParts2(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }

        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }

        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }


    //实现一。全局遍历，时间超限
    public static int[] threeEqualParts(int[] arr) {
        int[]result = new int[]{-1,-1};
        boolean zro = true;
        int ontCount = 0;
        //全是 0 特殊处理
        for (int i : arr) {
            if(i !=0){
                ontCount++;
            }
        }
        if(ontCount == 0){
            result[0] = 0;
            result[1] = arr.length-1;
            return result;
        }
        if(ontCount%3!=0){
           return result;
        }

        for (int i = ontCount/3-1;i< arr.length-1;i++){
            for(int j = ontCount/3 ;j<arr.length;j++){
                int index = 0;
                while (true){
                    int L1 = i+1;
                    int L2 = j-i-1;
                    int L3 = arr.length-j;
                     if(index>L1 && index>L2 && index>L3){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                    int i1 = 0;
                    int i2 = 0;
                    int i3 = 0;
                    //第一个值
                   if(L1>index) i1 = arr[i-index];
                   //第二个值
                   if(L2>index) i2 = arr[j-1-index];

                   if(L3>index) i3 = arr[arr.length-1-index];
                    //第三个值
                   if(i1!=i2||i2!=i3) break;
                   index++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = threeEqualParts(new int[]{0,1,0,1,1});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
