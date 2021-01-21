import java.util.ArrayList;
import java.util.List;

//全排列ii
public class leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] visited = new int[nums.length];
        find(nums, result, tmp, visited);
        return result;
    }
    private void find(int[] nums, List<List<Integer>> result, List<Integer> tmp,
                      int[] visited) {
        if(tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1 ||
                    (i!=0&&visited[i-1] == 0&& nums[i] == nums[i-1])) {
                    continue;
            }
            tmp.add(nums[i]);
            visited[i] = 1;
            find(nums, result, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        leetcode47 leetcode47 = new leetcode47();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = leetcode47.permuteUnique(nums);
        lists.forEach(list->list.forEach(System.out::println));
    }

}
