import java.util.Arrays;

//下一个排列
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int j = nums.length - 1;
        while(j > 0) {
            if(nums[j] < nums[j - 1]) {
                j--;
            } else {
                int start = j-1;
                while(j < nums.length && nums[j] > nums[start]) {
                    j++;
                }
                j--;
                int tmp = nums[start];
                nums[start] = nums[j];
                nums[j] = tmp;
                //对start后面的元素进行排序,调整顺序就可以了
                reverse(nums, start+1);

                return;
            }
        }
        reverse(nums, 0);
    }

    private void reverse(int[] nums, int index) {
        int i = index;
        int j = nums.length - 1;
        while(i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        leetcode31 leetcode31 = new leetcode31();
        int[] nums = {1,2,4,9,8,7,6,1};
        leetcode31.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
