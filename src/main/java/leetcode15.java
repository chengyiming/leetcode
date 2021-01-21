import java.util.*;

// 三数之和
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int L = i+1;
            int R = nums.length - 1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(sum < 0) {
                    L++;
                } else if(sum > 0) {
                    R--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //去除重复元素
                    while(L < R && nums[L] == nums[L+1]) {
                        L++;
                    }
                    L++;
                    while(L < R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    R--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        leetcode15 leetcode15 = new leetcode15();
        List<List<Integer>> lists = leetcode15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        lists.forEach(list->list.forEach(System.out::println));
    }
}
