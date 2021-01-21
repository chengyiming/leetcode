import java.util.ArrayList;
import java.util.List;

//组合
//组合是不同于排列
public class leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        find(n, k, result, tmp, 0);
        return result;
    }

    private void find(int n, int k, List<List<Integer>> result,
                      List<Integer> tmp, int index) {
        if(0 == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = index; i < Math.min(index+k, n); i++) {
            tmp.add(i+1);
            find(n, k-1, result, tmp, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
