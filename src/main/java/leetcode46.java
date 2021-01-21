import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//全排列
public class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        List<Integer> tmp = new ArrayList<>();
        find(nums, visited, result, tmp);
        return result;
    }

    private void find(int[] nums, int[] visited,
                      List<List<Integer>> result, List<Integer> tmp) {
        if(tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            find(nums, visited, result, tmp);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        leetcode46 leetcode46 = new leetcode46();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = leetcode46.permute(nums);
        permute.forEach(list-> list.forEach(System.out::println));
    }
}
