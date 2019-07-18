public class Problem137 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            //one ^ num 保留出现一次的位置，出现0和2次的都置为0,与～two求与操作，把出现两次又出现的排除
            one = (one ^ num) & (~two);
            //two ^ num 中，当num出现即会记录，但与～one求与，要求one里面不含有这个num
            two = (two ^ num) & (~one);
        }
        return one;
    }
}

/**
 *twos |= ones & num # ones & num 提取两个数都为1的位，与twos作或操作保留出现2次的位
 *ones ^= num  # 当 ones 和 num 同时为 1 or 0 时，ones = 0，因为同时为1已经加到twos里了，这里不做count
 *threes = ones & twos # 当ones和twos对应位都为1时，说明此位出现了3次
 *ones &= ~threes # three为1的位，将one和two对应位归零
 *twos &= ~threes
 */
