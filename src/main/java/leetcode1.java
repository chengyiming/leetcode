import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 两数之和
public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        leetcode1 leetcode1 = new leetcode1();
        int[] ints = leetcode1.twoSum(new int[]{2, 7, 11, 5}, 9);
        Arrays.stream(ints).forEach(System.out::println);
    }
}

