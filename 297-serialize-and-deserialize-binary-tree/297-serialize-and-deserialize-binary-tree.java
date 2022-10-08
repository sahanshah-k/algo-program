/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return encodeHelper(root);
    }
    
    private String encodeHelper(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tree = q.poll();
            if (tree == null) {
                sb.append("n ");
                continue;
            }
            
            sb.append(tree.val + " ");
            q.add(tree.left);
            q.add(tree.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] strArray = data.split(" ");
        System.out.println(Arrays.toString(strArray));
        TreeNode tree = new TreeNode(Integer.parseInt(strArray[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree);
        for (int i = 1; i < strArray.length; i ++) {
            TreeNode parent = q.poll();
            if (!strArray[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(strArray[i]));        
                parent.left = left;
                q.add(left);
            }
            if (!strArray[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(strArray[i])); 
                parent.right = right;
                q.add(right);
            }
        }
        return tree;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));