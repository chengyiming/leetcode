import java.util.Arrays;

//除了自身以外数据的乘机
public class leetcode238 {
    //解法一，内存消耗比较多，时间复杂度还可以
    public int[] productExceptSelf(int[] nums) {
        if (nums ==  null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] left = new int[n];
        left[0]  = 1;
        int[] right = new int[n];
        right[n-1] = 1;
        int[] result = new int[n];
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for(int j = n-2; j >=0; j--) {
            right[j] = right[j+1]*nums[j+1];
        }
        for(int k = 0; k < n; k++) {
            result[k] = left[k]*right[k];
        }
        return result;
    }

    //方法二：常数的空间复杂度
    public int[] productExceptSelf2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int multi = 1;
        for(int j = n-1; j >=0; j--) {
            result[j] = result[j] * multi;
            multi *= nums[j];
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        leetcode238 leetcode238 = new leetcode238();
        int[] ints = leetcode238.productExceptSelf2(nums);
        Arrays.stream(ints).forEach(System.out::println);
    }
}

