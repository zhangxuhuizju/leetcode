public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        int postIndex = postorder.length-1;
        return buildTree(inorder,postorder,postIndex,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder,int postIndex,int start,int end){
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(inorder[start]);
        int index = start;
        for(int i = start;i <= end;i++){
            if(inorder[i] == postorder[postIndex]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[index]);
        root.right = buildTree(inorder,postorder,postIndex-1,index+1,end);
        root.left = buildTree(inorder,postorder,postIndex-(end-index)-1,start,index-1);
        return root;
    }
}
