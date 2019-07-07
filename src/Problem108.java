public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = createTree(nums, left, middle-1);
        root.right = createTree(nums, middle+1, right);
        return root;
    }
}
