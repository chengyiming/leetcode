// 盛最多水的容器
public class leetcode11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while(i < j) {
            max = Math.max(max, Math.min(height[i], height[j])*(j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        leetcode11 leetcode11 = new leetcode11();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int i = leetcode11.maxArea(nums);
        System.out.println(i);
    }
}
