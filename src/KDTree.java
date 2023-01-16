public class KDTree {
    int k;
    Node root1=null;

    public KDTree(int k) {
        this.k = k;
    }

    public KDTree CreateTree(float[][] point) {
        KDTree t2 = new KDTree(k);
        Node root = null;
        for (int i = 0; i < point.length; i++) {
            root = t2.insertNode(root, point[i]);
        }
        System.out.println(root.left.point[0]);
        //System.out.println(root.left.point[1]);
        return t2;

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
            
        root1=root;
        return root;

    }

    public boolean searchNode(Node root, float point[]) {
        return search(root, point, 0);
    }

    public boolean search(Node root, float point[], int depth) {
        if (root == null)
            return false;
        if (arePointsSame(root.point, point))
            return true;
        int cd = depth % k;
        if (point[cd] < root.point[cd])
            return search(root.left, point, depth + 1);

        return search(root.right, point, depth + 1);
    }

    public boolean arePointsSame(float point1[], float point2[]) {
        for (int i = 0; i < k; ++i)
            if (point1[i] != point2[i])
                return false;
        return true;
    }

}
