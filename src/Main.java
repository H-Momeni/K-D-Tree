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

        Scanner scanner = new Scanner(new File("C:\\Users\\ACER\\OneDrive\\Desktop\\K-D Tree\\src\\test.txt"));
        String txt = scanner.useDelimiter("\\A").next();
        scanner.close();

        String[] parts = txt.split("\\r?\\n");
        String[] num = new String[100]; // 100 boad hadeaksar
        String[] count = parts[0].split(" ");

        int n = parts.length;
        int k = count.length;

        float[][] arr = new float[n][k];
        KDTree t1 = new KDTree(k);

        for (int i = 0; i < n; i++) {
            num = parts[i].split(" ");
            for (int j = 0; j < k; j++) {
                arr[i][j] = Float.parseFloat(num[j]);
            }
        }
        

    
        t1 = t1.CreateTree(arr);
       t1.inOrder(t1.root1);
        // float point1[] = { 3, 6 };
        // t1.root1 = t1.deleteNode(t1.root1, point1);
        // System.out.println(t1.root1.point[0]);
        // System.out.println(t1.root1.point[1]);
        // for (int i = 0; i < n; i++) {
        // root = t1.insertNode(root, arr[i]);
        // }

        // System.out.println(t1.searchNode(t1.root1, point1));
        // System.out.println("*******");
        // System.out.println(t1.root1.right.left.right.point[0]);
        // System.out.println(t1.root1.right.left.point[1]);
        // System.out.println(root.right.left.right.point[2]);

    }
}
