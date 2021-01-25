import java.util.ArrayList;
import java.util.List;

// 数组综合III
public class leetcode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        find(k, n, result, tmp, 1);
        return result;
    }

    private void find(int k, int n, List<List<Integer>> result, List<Integer> tmp, int index) {
        if(k == 0 && n == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if(k < 0 || n < 0) {
            return;
        }

        for(int i = index; i <=9-k+1; i++) {
            tmp.add(i);
            find(k-1, n-i, result, tmp, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        leetcode216 leetcode216 = new leetcode216();
        int k = 3, n = 7;
        List<List<Integer>> lists = leetcode216.combinationSum3(k, n);
        lists.forEach(list->list.forEach(System.out::println));
    }
}
