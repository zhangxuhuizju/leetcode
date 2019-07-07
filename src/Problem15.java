import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
代码能力太渣！！！
public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(nums.length <= 2) return answer;
        Arrays.sort(nums);
        //减枝很重要！
        for (int i = 0; i != nums.length-2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1, right = nums.length - 1;
            while (right > left) {
                if (nums[right] + nums[left] == -nums[i]) {
                    //API要会灵活使用！
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (nums[right] + nums[left] < -nums[i]) left++;
                else right--;
            }
        }
        return answer;
    }
 */
public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i-1])
                i++;
            int left = i + 1, right = nums.length - 1, temp = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == temp) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;right--;
                    while (left < right && nums[left-1] == nums[left]) left++;
                    while (left < right && nums[right+1] == nums[right]) right--;
                }else if (nums[left] + nums[right] > temp) {
                    right--;
                } else left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-2,0,1,1,2};
        new Problem15().threeSum(a);
    }
}
