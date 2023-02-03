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
        // Scanner input = new Scanner(System.in);

        Scanner scanner = new Scanner(new File("C:\\Users\\ACER\\OneDrive\\Desktop\\K-D Tree\\src\\noghat.txt"));
        String txt = scanner.useDelimiter("\\A").next();
        scanner.close();
        // System.out.println(txt);
        String[] parts = txt.split("\\r?\\n");
        String[] num = new String[10000]; // 10000 boad hadeaksar
        String[] count = parts[0].split(" ");

        Scanner out = new Scanner(new File("C:\\Users\\ACER\\OneDrive\\Desktop\\K-D Tree\\src\\train.txt"));
        String text = out.useDelimiter("\\A").next();
        out.close();
        // System.out.println(txt);
        String[] parts1 = text.split("\\r?\\n");

        int n = parts.length;
        int k = count.length;

        float[][] arr = new float[n][k + 1];
        KDTree t1 = new KDTree(k);

        for (int i = 0; i < n; i++) {
            num = parts[i].split(" ");
            for (int j = 0; j < k; j++) {
                arr[i][j] = Float.parseFloat(num[j]);
            }
        }

        for (int i = 0; i < n; i++) {
             arr[i][784] = Float.parseFloat(parts1[i]);
        }
        // System.out.print(arr[100][784]);
        // KNNClassifier example = new KNNClassifier(arr, 1); // jaye 5 adad delkhah

         System.out.print(arr[1][784]);

        t1 = t1.CreateTree(arr);

        float point1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 204, 203,
                7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 253, 252, 56, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 253, 252, 143, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 163, 253, 252, 168, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 241, 255, 253, 106, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 169,
                113, 0, 0, 0, 0, 0, 0, 0, 85, 252, 253, 240, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 229, 252, 168,
                0, 0, 0, 0, 0, 0, 0, 123, 252, 253, 196, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 253, 252, 168, 0, 0,
                0, 0, 0, 0, 0, 197, 252, 253, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 241, 254, 253, 168, 0, 0, 0,
                0, 0, 0, 120, 253, 253, 251, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 172, 252, 253, 252, 224, 169, 108,
                57, 38, 0, 7, 187, 252, 252, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 169, 252, 252, 253, 252, 252, 252,
                253, 252, 234, 197, 154, 252, 252, 252, 76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 206, 252, 252, 253,
                252, 252, 252, 253, 252, 252, 252, 253, 252, 252, 252, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 76, 150,
                175, 126, 225, 225, 225, 254, 253, 253, 253, 254, 253, 253, 128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 84, 84, 215, 252, 253, 252, 196, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 82, 240, 252, 253, 208, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 114, 206, 252, 252, 253, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 128,
                254, 253, 253, 253, 151, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 114, 234, 252, 253,
                252, 233, 145, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 169, 252, 252, 253, 196,
                62, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94, 228, 202, 78, 9, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        float point2[] = { 25, 70 };

        // example.classify(point1);
        float[][] arr1 = new float[n][k + 1];

        // int[] arr3 = new int[5];
        // int arrayLength = arr3.length;
        // System.out.println("the array"+point1.length);
        // for(int i=0;i<point1.length;i++){
        // System.out.println("//////////"+i);
        // }

        arr1 = t1.findmnn(point1, 2, t1);
        System.out.println("-------------------------");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < k+1; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.print("*****\n");
        }

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

        

        Node emt = t1.nearestNeighbor(t1.root1, point1);
        for(int i=0;i<emt.point.length;i++){
        System.out.print(emt.point[i]+" ");
        }

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

    }
}
