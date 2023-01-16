public class KDTree {
    int k;

    public KDTree(int k) {
        this.k = k;
    }

    public Node insertNode(Node root, float[] point) {
        return insert(root, point, 0);

    }

    public Node insert(Node root, float[] point, int depth) {
        if (root == null)
            return new Node(k, point);

        int cd = depth % k;

        if (point[cd] < (root.point[cd]))
            root.left = insert(root.left, point, depth + 1);
        else
            root.right = insert(root.right, point, depth + 1);

        return root;

    }

    

}
