import java.util.*;

public class Problem47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] selected = new boolean[nums.length];
        permute(nums, selected);
        return res;
    }

    private void permute(int[] nums, boolean[] selected) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        /*
            注意和没有重复数字不一样的是，用swap的话，把数字的位置换掉了，
            所以nums[i] == nums[i-1]判断条件不再适用
            应该用选择法,某一位只能选不同的数字一次
            即，如果nums[i]==nums[i-1]，那这次选数字只选这其中的一个
        */
        for (int i = 0; i < nums.length; ++i) {
            if (selected[i] || (i > 0 && !selected[i-1] && nums[i] == nums[i-1]))
                continue;
            selected[i] = true;
            list.add(nums[i]);
            permute(nums, selected);
            selected[i] = false;
            list.pollLast();
        }
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,9};
        System.out.println(new Problem47().permuteUnique(a));
    }
}
