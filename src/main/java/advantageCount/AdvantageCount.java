package advantageCount;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class AdvantageCount {

    //按官方方式优化,省去used
    public static int[] advantageCount3(int[] nums1, int[] nums2) {

        int len = nums1.length;

        Integer [] nums = new Integer[len];
        for (int i = 0; i < len; i++) {
            nums[i] = i;
        }
        Arrays.sort(nums, Comparator.comparingInt(i -> nums2[i]));

        int [] result = new int[len];
        //排序
        nums1 = Arrays.stream(nums1).sorted().toArray();
        int start = 0;
        int end = len-1;
        int index = 0;
        while (index < len){
            //第二个最小值大于赛的最小值
            if (nums2[nums[start]]>=nums1[index]){
                result[nums[end]] = nums1[index];
                end--;
            }else {
                result[nums[start]] = nums1[index];
                start++;
            }
            index ++;
        }
        return result;
    }
    public static void main(String[] args) {
        //[5621,1743,5532,3549,9581]
        //[2,0,4,1,2]
        //[1,3,0,0,2]

        int[] ints = advantageCount3(new int[]{2,0,4,1,2}, new int[]{1,3,0,0,2});
//        int[] nums1 = new int[]{5621,1743,5532,3549,9581};
//        Integer [] nums = new Integer[]{0,1,2,3,4,5};
//        int [] nums2 = new int[]{5,1,2,3,0,6};
//        Arrays.sort(nums, (i, j) -> nums2[i] - nums2[j]);
////        nums1 = Arrays.stream(nums1).sorted().toArray();
        Arrays.stream(ints).forEach(System.out::println);
    }
    //优化
    public static int[] advantageCount2(int[] nums1, int[] nums2) {
        int [] result = new int[nums1.length];
        //排序
        nums1 = Arrays.stream(nums1).sorted().toArray();
        //贪心算法 如果存在大于的，则用最小的那个，如果没有，则取最小的那个
        Set<Integer> used = new HashSet<>();

        for (int i = 0;i<nums2.length;i++) {
            int vue = -1;
            for (int j = 0; j < nums1.length; j++) {
                if (used.contains(j)) continue;
                if (nums2[i] < nums1[j] ) {
                    vue = nums1[j];
                    used.add(j);
                    break;
                }
            }
            //找到最小值
                if(vue==-1){
                    for (int j = 0; j < nums1.length; j++) {
                        if (used.contains(j)) continue;
                        vue = nums1[j];
                        used.add(j);
                        break;
                    }
                }
            result[i] = vue;

        }

        return result;
    }




    //最基础算法
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int [] result = new int[nums1.length];
        //贪心算法 如果存在大于的，则用最小的那个，如果没有，则取最小的那个
        Set<Integer> used = new HashSet<>();
        int index = 0;
        for (int i = 0;i<nums2.length;i++) {
            int vue = -1;
            for (int j = 0; j < nums1.length; j++) {
                if (used.contains(j)) continue;

                if (nums2[i] < nums1[j]) {
                    if (vue == -1) {
                        vue = nums1[j];
                        used.add(j);
                        index = j;
                    } else if (vue > nums1[j]) {
                        vue = nums1[j];
                        used.remove(index);
                        used.add(j);
                        index = j;
                    }
                }
            }
            //找到最小值
            if (vue == -1) {
                for (int j = 0; j < nums1.length; j++) {
                    if (used.contains(j)) continue;
                    if (vue == -1) {
                        vue = nums1[j];
                        used.add(j);
                        index = j;
                    } else if (vue > nums1[j]) {
                        vue = nums1[j];
                        used.remove(index);
                        used.add(j);
                        index = j;
                    }
                }
            }
            result[i] = vue;

        }

        return result;
    }

}
