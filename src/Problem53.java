import org.omg.CORBA.MARSHAL;

public class Problem53 {
    /*
        非常典型的题目，从O(n^2) -> O(nlogn) -> O(n)
        其中，分治法的写法需要引起重视！很经典
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            if (temp + num > 0) {
                temp += num;
                max = Math.max(max, temp);
            }
            else temp = 0;
        }
        return max;
    }
}
