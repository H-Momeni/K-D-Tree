public class KDTree {
    int k;
    Node root1 = null;
    Node curr = null;

    public KDTree(int k) {
        this.k = k;
    }

    public KDTree CreateTree(float[][] point) {
        KDTree t2 = new KDTree(k);
        Node root = null;
        for (int i = 0; i < point.length; i++) {
            root = t2.insertNode(root, point[i]);
        }
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

        root1 = root;
        return root;

    }

    public Node findParent(Node root, float[] point, int depth, Node parent) {

        if (root == null) {
            curr = parent;
            return parent;
        }

        int cd = depth % k;

        if (point[cd] < (root.point[cd]))
            root.left = findParent(root.left, point, depth + 1, root);
        else
            root.right = findParent(root.right, point, depth + 1, root);

        root1 = root;
        return curr;

    }

    public Node Parent(Node root, float[] point) {
        return findParent(root, point, 0, root);
    }

    public float distance(float[] point, Node parent) {
        Double sum = 0.0;
        Double a = 0.0;
        Double b = 0.0;
        Double c = 0.0;
        Float reason;
        for (int i = 0; i < k; i++) {
            a = Double.valueOf(point[i]);
            b = Double.valueOf(parent.point[i]);
            c = a - b;
            sum = sum + Math.pow(c, 2);
        }
        sum = Math.sqrt(sum);
        reason = sum.floatValue();
        return reason;
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

    public Node deleteNode(Node root, float point[]) {
        return delete(root, point, 0);
    }

    public Node delete(Node root, float point[], int depth) {
        if (root == null)
            return null;

        int cd = depth % k;
        if (arePointsSame(root.point, point)) {

            if (root.right != null) {
                Node min = findMin(root.right, cd);
                copyPoint(root.point, min.point);
                root.right = delete(root.right, min.point, depth + 1);
            } else if (root.left != null) // same as above
            {
                Node min = findMin(root.left, cd);
                copyPoint(root.point, min.point);
                root.left = delete(root.left, min.point, depth + 1); // khodam dorostesh kardam
            } else {
                // delete root;
                root = null;
                return null;
            }
            return root;
        }
        if (point[cd] < root.point[cd])
            root.left = delete(root.left, point, depth + 1);
        else
            root.right = delete(root.right, point, depth + 1);
        return root;
    }

    void copyPoint(float p1[], float p2[]) {
        for (int i = 0; i < k; i++)
            p1[i] = p2[i];
    }

    public Node findMinRec(Node root, int d, int depth) {
        if (root == null)
            return null;

        int cd = depth % k;
        if (cd == d) {
            if (root.left == null)
                return root;
            return findMinRec(root.left, d, depth + 1);
        }
        return minNode(root,
                findMinRec(root.left, d, depth + 1),
                findMinRec(root.right, d, depth + 1), d);
    }

    public Node findMin(Node root, int d) {
        return findMinRec(root, d, 0);
    }

    public Node minNode(Node x, Node y, Node z, int d) {
        Node res = x;
        if (y != null && y.point[d] < res.point[d])
            res = y;
        if (z != null && z.point[d] < res.point[d])
            res = z;
        return res;
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        printTree(root);
        System.out.print("\n");
        inOrder(root.right);
    }

    public void printTree(Node root) {
        for (int i = 0; i < k; i++) {
            System.out.print(root.point[i] + " ");
        }
    }
}
