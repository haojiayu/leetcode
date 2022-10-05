package missingTwo;

/**
 * 244
 *  消失的两个数字
 *  给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 *  以任意顺序返回这两个数字均可。
 *  2022-09-26
 */
public class MissingTwo {
    /**
     * 解题思路：
     * 创建空数组，长度为需要检验的数组长度+2
     * 将已存在数字的下角标设置为1
     * 则为0的下角标就是不存在的数字
     *
     */


    public int[] missingTwo(int[] nums) {
        int[] sum = new int[nums.length+2];
        for (int num : nums) {
            sum[num-1] = 1;
        }
        int[] re = new int[2];
        int index = 0;
        for (int i  = 0;i<sum.length;i++) {
            if(sum[i]==0){
                re[index] = i+1;
                index++;
            }
            if(index == 2){
                return re;
            }
        }
        return re;
    }
}
