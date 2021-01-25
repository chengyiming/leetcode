import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//数组总和II
public class leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        int[] visited = new int[candidates.length];
        find(candidates, target, result, tmp,0);
        return result;
    }

    private void find(int[] candidates, int target, List<List<Integer>> result,
                      List<Integer> tmp,int index) {

        if(target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(i > index  && candidates[i]==candidates[i-1]) {
                continue;
            }
            tmp.add(candidates[i]);

            find(candidates, target - candidates[i], result, tmp, i+1);
            tmp.remove(tmp.size() - 1);

        }
    }


    public static void main(String[] args) {
        leetcode40 leetcode40 = new leetcode40();
        int[] nums = {10, 1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = leetcode40.combinationSum2(nums, target);
        lists.forEach(list->list.forEach(System.out::println));
    }
}
