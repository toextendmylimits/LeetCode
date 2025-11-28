I use preorder DFS to serialize the tree.
Every node is recorded as its value, and I use "x" for null pointers.
This sequence uniquely describes the tree because preorder always visits: node → left → right.

To deserialize, I read the values in order using an iterator.
Whenever I see "x" I return None; otherwise I create a node and recursively build its left and right subtrees.
Because serialize and deserialize follow the same preorder structure, the original tree is reconstructed exactly.

class Codec:

    def serialize(self, root):
        values = []

        def dfs(node):
            if not node:
                values.append("x")
                return
            values.append(str(node.val))
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return ",".join(values)

    def deserialize(self, data):
        values = iter(data.split(","))

        def build_subtree():
            val = next(values)
            if val == "x":
                return None
            node = TreeNode(int(val))
            node.left = build_subtree()
            node.right = build_subtree()
            return node

        return build_subtree()
