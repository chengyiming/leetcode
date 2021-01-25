import java.util.Stack;

//接雨水
public class leetcode42 {

//    方法一，使用left和right数组
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        int[] right = new int[n];
        right[n-1] = height[n-1];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        for(int j = n-2; j >=0; j--) {
            right[j] = Math.max(right[j+1], height[j]);
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }


//    方法二：使用栈解决
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int pre = stack.peek();
                sum += (i-pre-1)*(Math.min(height[i], height[pre]) - height[pop]);
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        leetcode42 leetcode42 = new leetcode42();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = leetcode42.trap2(nums);
        System.out.println(trap);
    }
}
