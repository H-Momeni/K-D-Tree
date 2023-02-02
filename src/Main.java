import java.io.File;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        Scanner scanner = new Scanner(new File("C:\\Users\\ACER\\OneDrive\\Desktop\\K-D Tree\\src\\noghat.txt"));
        String txt = scanner.useDelimiter("\\A").next();
        scanner.close();
        // System.out.println(txt);
        String[] parts = txt.split("\\r?\\n");
        String[] num = new String[20000]; // 20000 boad hadeaksar
        String[] count = parts[0].split(" ");

        int n = parts.length;
        int k = count.length;

        float[][] arr = new float[n][k];
        KDTree t1 = new KDTree(k);
        KNNClassifier example = new KNNClassifier(arr, 5);

        for (int i = 0; i < n; i++) {
            num = parts[i].split(" ");
            for (int j = 0; j < k; j++) {
                arr[i][j] = Float.parseFloat(num[j]);
            }
        }

        // t1 = t1.CreateTree(arr);

        // float point1[] = { 25, 70 };

        // t1.findmnn(point1, 3, t1);
        // KDTree t2=new KDTree(k); //in derakht baray peyda kardan m va n karbord darad
        // KDTree t2 = new KDTree(k);
        // t1.inOrder(t1.root1);
        // t2 = t1.insertCopy(t1.cloneBinaryTree(t1.root1));

        // t2.root1 = t2.deleteNode(t2.root1, point1);
        // t2.inOrder(t2.root1);
        // System.out.println("*************");
        // t1.inOrder(t1.root1);

        // Node mesal=t1.cloneBinaryTree(t1.root1);
        // System.out.println(mesal.right.right.point[0]);

        // t1.root1 = t1.deleteNode(t1.root1, point1);

        // Node emt = t1.Parent(t1.root1, point1);

        // Node emt = t1.nearestNeighbor(t1.root1, point1);
        // float b = t1.distance(point1, emt);
        // System.out.println("*********");
        // System.out.println(emt.point[0]);
        // System.out.println(emt.point[1]);
        // System.out.println(b);
        // float[][] arr1 = new float[2][k];
        // arr1=t1.bounds(point1, b);
        // for (int j = 0; j < 2; j++) {
        // for (int i = 0; i < k; i++) {
        // System.out.print(arr1[j][i]+"\t");
        // }
        // System.out.print("\n");
        // }

        // t1.inOrder(t1.root1);
        //
        //
        // System.out.println(t1.root1.point[0]);
        // System.out.println(t1.root1.point[1]);
        // for (int i = 0; i < n; i++) {
        // root = t1.insertNode(root, arr[i]);
        // }

        // System.out.println(t1.searchNode(t1.root1, point1));
        // System.out.println("*******");
        // System.out.println(t1.root1.right.right.point[0]);
        // System.out.println(t1.root1.right.right.point[1]);
        // System.out.println(t1.root1.right.right.left.point[0]);
        // System.out.println(t1.root1.right.right.left.point[1]);
        // System.out.println(root.right.left.right.point[2]);

    }
}
