public class KDTree {
    int k; // be tedad abad eshare mikonad
    Node root1 = null; // rishe derakht ra negah midarad

    public KDTree(int k) { // sazande derakht kd tree
        this.k = k;
    }

    // ********************** marbooot be sakht derakht
    public KDTree CreateTree(float[][] point) { // sakht derakht ba noghat mad nazar
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
    // **********************

    // ********************** marboot be point exist
    public boolean searchNode(Node root, float point[]) {
        return search(root, point, 0);
    }

    public boolean search(Node root, float point[], int depth) {
        if (root == null)
            return false;
        if (arePointsSame(root.point, point)) // dar ghesmat delete
            return true;
        int cd = depth % k;
        if (point[cd] < root.point[cd])
            return search(root.left, point, depth + 1);

        return search(root.right, point, depth + 1);
    }
    // **********************

    // ********************** marboot be delete node
    // dar delete kardan agar gere barg bood an ra hazf mikonim
    // agar right!=null bood kochektarin adad dar haman bood ra peyda karde an node
    // ra jaygozin va hazf mikonim
    // agar left!=null bood kochektarin adad dar haman bood ra peyda karde an node
    // ra jaygozin va hazf mikonim va hamchenin zir derakht left ro bayad tabdil
    // konim be zir derakht rast an
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
            } else if (root.left != null) {
                Node min = findMin(root.left, cd);
                copyPoint(root.point, min.point);
                root.left = delete(root.left, min.point, depth + 1);
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

    public boolean arePointsSame(float point1[], float point2[]) {
        for (int i = 0; i < k; ++i)
            if (point1[i] != point2[i])
                return false;
        return true;
    }

    public Node findMin(Node root, int d) {
        return findMinRec(root, d, 0);
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

    public Node minNode(Node x, Node y, Node z, int d) { // peyda kardan koochektarin bein 3 node
        Node res = x;
        if (y != null && y.point[d] < res.point[d])
            res = y;
        if (z != null && z.point[d] < res.point[d])
            res = z;
        return res;
    }

    void copyPoint(float p1[], float p2[]) {
        for (int i = 0; i < k; i++)
            p1[i] = p2[i];
    }
    // **********************

    // ********************** marboot be peimayesh inorder
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        printTree(root);
        System.out.print("*******\n");
        inOrder(root.right);
    }

    public void printTree(Node root) {
        for (int i = 0; i < k; i++) {
            System.out.print(root.point[i] + " ");
        }
    }
    // **********************

    // ********************** marboot be peyda kardan yek hamsaye nazdik
    // agar omgh derakht h bashad ma hadeaksar 2*h node ra mibinim
    public Node nearestNeighbor(Node root, float[] target) {
        return nearestNeighbor(root, target, 0);
    }

    public Node nearestNeighbor(Node root, float[] target, int depth) {

        if (root == null)
            return null;

        Node nextBranch = null; // next branch branchie ke node tosh on samte
        Node otherBranch = null;
        int cd = depth % k;
        // peyda kardan branch khode node
        if (target[cd] < root.point[cd]) {
            nextBranch = root.left;
            otherBranch = root.right;
        } else {
            nextBranch = root.right;
            otherBranch = root.left;
        }

        // mirim payeen baray peyda kardan behtarin node feli(parent yaftan)
        Node temp = nearestNeighbor(nextBranch, target, depth + 1);
        Node best = closest(temp, root, target); // dar inja best bein rishe va temp hast
        float radius = distance(target, best); // mohasebe shoaa dar ebteda be onvan behtarin fasele

        // peymayesh branch haye digar shayad noghte nazdiktary peyda beshe
        float dist = target[cd] - root.point[cd]; // mohasebe fasele bein rishe va target dar bode mored nazar ba
                                                  // distance fargh darad
        if (radius >= dist) {
            temp = nearestNeighbor(otherBranch, target, depth + 1);
            best = closest(temp, best, target); // dar inja best bein best ghabli va temp hast
        }
        return best;
    }

    public Node closest(Node n0, Node n1, float[] target) {
        // moshkhas mikonad bein 2 node ferestade shode kodam yek nazdiktar ast va digar
        // amightar nemiravad
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

    public float distance(float[] point, Node parent) {
        Double sum = 0.0;
        Double a = 0.0;
        Double b = 0.0;
        Double c = 0.0;
        Float reason;
        for (int i = 0; i < k; i++) { // barye eslah dar ferestadan k+1 bod mitavanim halghe ra i<k-1 konim
            a = Double.valueOf(point[i]);
            b = Double.valueOf(parent.point[i]);
            c = a - b;
            sum = sum + Math.pow(c, 2);
        }
        sum = Math.sqrt(sum);
        reason = sum.floatValue();
        return reason;
    }
    // **********************

    // ********************** marboot ba peyda kardan knn
    public float[][] findmnn(float[] point, int m, KDTree t1) {
        KDTree t2 = new KDTree(k);
        float[][] ans = new float[m][k + 2];
        t2 = t1.insertCopy(t1.cloneBinaryTree(t1.root1)); // ba tavajoh be farakhani delete ma niaz be ek derakht copy
                                                          // darim

        for (int i = 0; i < m; i++) {
            Node emt = t2.nearestNeighbor(t2.root1, point);
            for (int j = 0; j < k; j++) {
                ans[i][j] = emt.point[j];
            }
            t2.root1 = t2.deleteNode(t2.root1, emt.point);
        }
        return ans;
    }

    public Node cloneBinaryTree(Node root) { // baraye copy kardan derakht
        if (root == null) {
            return null;
        }
        Node root_copy = new Node(k, root.point);
        root_copy.left = cloneBinaryTree(root.left);
        root_copy.right = cloneBinaryTree(root.right);
        return root_copy; // khorooji yek node rishe be hamrahe tamam farzandan on ast va nave va ...
    }

    public KDTree insertCopy(Node r) { // ijad derakht ba rishe ye dade shode
        KDTree t = new KDTree(k);
        t.root1 = r;
        return t;
    }
    // **********************

}
