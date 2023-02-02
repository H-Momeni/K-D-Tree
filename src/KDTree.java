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

    public KDTree insertCopy(Node r) {
        KDTree t = new KDTree(k);
        t.root1 = r;
        return t;
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
            // System.out.println(a+"-"+b+"="+c+"\t"+sum);
        }
        sum = Math.sqrt(sum);
        reason = sum.floatValue();
        //System.out.println(parent.point[0]+"\t"+parent.point[1]+"\t"+reason);
        return reason;
    }

    public float[][] bounds(float[] point, float r) {
        float arr[][] = new float[2][k];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < k; i++) {
                if (j == 0) { // hade payeen
                    arr[j][i] = point[i] - r;
                }
                if (j == 1) { // hade bala
                    arr[j][i] = point[i] + r;
                }
            }
        }
        return arr;
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

    public Node nearestNeighbor(Node root, float[] target) {
        return nearestNeighbor(root, target, 0);
    }

    public Node nearestNeighbor(Node root, float[] target, int depth) {

        if (root == null)
            return null;

        Node nextBranch = null;
        Node otherBranch = null;
        int cd = depth % k;
        // compare the property appropriate for the current depth
        if (target[cd] < root.point[cd]) {
            nextBranch = root.left;
            otherBranch = root.right;
        } else {
            nextBranch = root.right;
            otherBranch = root.left;
        }

        // recurse down the branch that's best according to the current depth
        Node temp = nearestNeighbor(nextBranch, target, depth + 1);
        Node best = closest(temp, root, target);

        float radiusSquared = distance(target, best);

        float dist = target[cd] - root.point[cd];

        if (radiusSquared >= dist * dist) {
            temp = nearestNeighbor(otherBranch, target, depth + 1);
            best = closest(temp, best, target);
        }

        return best;
    }

    public Node closest(Node n0, Node n1, float[] target) {
        if (n0 == null)
            return n1;

        if (n1 == null)
            return n0;

        float d1 = distance(target, n0);
        float d2 = distance(target, n1);

        if (d1 < d2)
            return n0;
        else
            return n1;
    }

    public Node cloneBinaryTree(Node root) {
        // base case
        if (root == null) {
            return null;
        }

        // create a new node with the same data as the root node
        Node root_copy = new Node(k, root.point);

        // clone the left and right subtree
        root_copy.left = cloneBinaryTree(root.left);
        root_copy.right = cloneBinaryTree(root.right);

        // return cloned root node
        return root_copy;
    }

    public void findmnn(float[] point, int m, KDTree t1) {
        KDTree t2 = new KDTree(k);
        t2 = t1.insertCopy(t1.cloneBinaryTree(t1.root1));
        for (int i = 0; i < m; i++) {
            Node emt = t1.nearestNeighbor(t2.root1, point);
            System.out.println(emt.point[0]+"\t"+emt.point[1]);
            t2.root1 = t2.deleteNode(t2.root1, emt.point);
        }

    }

}
