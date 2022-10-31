public class Codec {
    private static final String SPLITTER = ",";
    private static final String NULL_SYMBOL = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULL_SYMBOL).append(SPLITTER);
        }
        else {
            sb.append(root.val).append(SPLITTER);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLITTER)));
        return buildTree(nodes);
    }
             
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if(NULL_SYMBOL.equals(val)) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        
        return root;
    }
}
