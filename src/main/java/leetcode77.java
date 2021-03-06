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

    public static void main(String[] args) {
        leetcode77 leetcode77 = new leetcode77();
        List<List<Integer>> combine = leetcode77.combine(4, 2);
        combine.forEach(list->list.forEach(System.out::println));
        System.out.println(3);
    }
}
