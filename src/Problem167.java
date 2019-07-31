public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        index[0] = 1;
        index[1] = numbers.length;
        while (numbers[index[0]-1] + numbers[index[1]-1] != target) {
            if (numbers[index[0]-1] + numbers[index[1]-1] < target)
                index[0]++;
            else index[1]--;
        }
        return index;
    }
}
