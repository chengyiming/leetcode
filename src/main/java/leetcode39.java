import java.util.ArrayList;
import java.util.List;

//组合总和
public class leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        find(candidates, target, result, tmp,0);
        return result;
    }
    private void find(int[] candidates, int target, List<List<Integer>> result,
                      List<Integer> tmp, int index) {

        if(0 == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            find(candidates, target- candidates[i], result, tmp,i);
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        leetcode39 leetcode39 = new leetcode39();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = leetcode39.combinationSum(candidates, target);
        lists.forEach(list->list.forEach(System.out::println));
    }
}
