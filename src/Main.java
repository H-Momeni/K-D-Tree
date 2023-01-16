import java.util.Scanner;

class Node {
    float[] point;
    Node right;
    Node left;

    public Node(int k, float arr[]) {
        point = new float[k];
        for (int i = 0; i < k; i++) {
            point[i] = arr[i];
        }
        right = null;
        left = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of dimensions and points.");
        Node root = null;
        int k = input.nextInt();
        int n = input.nextInt();
        float[][] arr = new float[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        KDTree t1 = new KDTree(k);

        for (int i = 0; i < n; i++) {
            root = t1.insertNode(root, arr[i]);
        }
        System.out.println(root.left.point[0]);
        System.out.println(root.left.point[1]);
       // System.out.println(root.left.point[2]);
        System.out.println("*******");
        System.out.println(root.right.left.right.point[0]);
        System.out.println(root.right.left.right.point[1]);
        //System.out.println(root.right.left.right.point[2]);
        

    }
}
