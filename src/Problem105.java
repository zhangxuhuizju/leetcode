public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode createTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pr < pl) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int index = il;
        for (; index <= ir; ++index)
            if (preorder[pl] == inorder[index]) break;
        root.left = createTree(preorder, inorder, pl + 1, pl+index-il, il, index - 1);
        root.right = createTree(preorder, inorder, pl+index-il+1, pr,index+1, ir);
        return root;
    }
}
