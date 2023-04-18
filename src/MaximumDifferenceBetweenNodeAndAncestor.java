import com.clay.base.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * @author CLAY
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(maxAncestorDiff(root));
    }

    public static int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public static int dfs(TreeNode root, int max, int min) {
        if (root.val > max) {
            max = root.val;
        }

        if (root.val < min) {
            min = root.val;
        }

        int diff = max - min;

        if (root.left != null) {
            diff =  Math.max(diff,dfs(root.left, max, min));
        }
        if (root.right!= null) {
            diff =  Math.max(diff,dfs(root.right, max, min));
        }
        return diff;
    }

}
