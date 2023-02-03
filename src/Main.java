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
        KDTree t1 = new KDTree(k + 1);

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
        KNNClassifier example = new KNNClassifier(arr, 3); // jaye 5 adad delkhah
        // for (int i = 0; i < arr[1].length; i++){
        // System.out.print(arr[1][i]+" ");}

        // t1 = t1.CreateTree(arr);
        // t1.inOrder(t1.root1);

        float point1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 87, 138, 170, 253, 253, 244, 118, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 13, 89, 161, 253, 252, 252, 214, 227, 253, 252, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 45, 172, 252, 221, 184, 110, 69, 13, 32, 253, 252, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 62, 236, 252, 176, 35, 0, 0, 0, 0, 0, 253, 252, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 53, 243, 252, 136, 4, 0, 0, 0, 0, 0, 53, 253, 252, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51,
                243, 255, 144, 0, 0, 0, 0, 36, 138, 233, 253, 255, 196, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 93,
                252, 218, 33, 0, 0, 0, 36, 219, 252, 252, 252, 218, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 176,
                252, 153, 70, 70, 70, 174, 222, 252, 252, 252, 168, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                113, 252, 253, 252, 252, 252, 252, 253, 252, 185, 119, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 9, 179, 253, 252, 221, 232, 252, 253, 157, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 38, 233, 253, 179, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9,
                155, 252, 252, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 130, 252, 252,
                136, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 194, 252, 218, 14, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128, 252, 252, 108, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 76, 255, 253, 173, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 93, 252, 253, 202, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 19, 188, 252, 205, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 164, 252, 252, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 184, 252,
                147, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, -1 }; // barchasb diffult ro -1 migiram
        float point2[] = { 25, 70 };
        float javab;
       // javab = example.classify(point1);
        //System.out.println(javab);
        float[][] arr1 = new float[n][k + 1];
            
        System.out.println("How many points do you want to enter?");
        int z = input.nextInt();
        float [] zzzz=new float [z];
        float [] aaaa=new float [z];

       // double v=0;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < k + 1; j++) {
                arr1[i][j]=input.nextFloat();
            }
        }
        System.out.println("--------------");
        for (int j = 0; j < z; j++) {
            aaaa[j]=input.nextFloat();
        }

        zzzz=example.classifyAll(arr1, z);
        // for (int j = 0; j < z; j++) {
        //     System.out.println(zzzz[j]);
        // }
        
       example.accuracy( zzzz,aaaa, z);
       // System.out.println(v);


        // System.out.println(k);

        // arr1 = t1.findmnn(point1, 2, t1);
        // System.out.println("-------------------------");
        // for (int i = 0; i < arr1.length; i++) {
        // for (int j = 0; j < k+1; j++) {
        // System.out.print(arr1[i][j] + " ");
        // }
        // System.out.print("*****\n");
        // }

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

        // Node emt = t1.nearestNeighbor(t1.root1, point1);
        // for(int i=0;i<emt.point.length;i++){
        // System.out.print(emt.point[i]+" ");
        // }

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
