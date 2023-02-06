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

        String pathNode = "C:\\Users\\ACER\\OneDrive\\Desktop\\K-D Tree\\src\\test.txt";
        String pathLabel = "C:\\Users\\ACER\\OneDrive\\Desktop\\K-D Tree\\src\\train.txt";
        //String pathLabel = null;


        System.out.println("How many points do you want to enter?(KDTree nodes)");
        int num = input.nextInt();
        System.out.println("How many dimensions do points have?");
        int k = input.nextInt();
        int kReal = k; // baraye point exist

        if (pathLabel != null) {
            k = k + 1;
        }

        float[][] point = new float[num][k];

        ReadFile read = new ReadFile();
        point = read.Read(pathNode, pathLabel);

        // ********************** create tree

        // KDTree tree = new KDTree(k);

        // tree = tree.CreateTree(point);
    

        // System.out.println("What node do you want to add to the KDTree?");
        // float[] node = new float[k];
        // for (int i = 0; i < k; i++) {
        //     node[i] = input.nextFloat();
        // }
        // tree.root1 = tree.insertNode(tree.root1, node);

        // System.out.println("Enter the desired point:");
        // float[] searchPoint = new float[k];
        // for (int i = 0; i < kReal; i++) {
        //     searchPoint[i] = input.nextFloat();
        // }
        // Node answer = tree.nearestNeighbor(tree.root1, searchPoint);
        // for (int i = 0; i < answer.point.length; i++) {
        //     System.out.print(answer.point[i] + " ");
        // }

        // System.out.println("How many points are you looking for?");
        // int number = input.nextInt();
        // System.out.println("Enter the desired point:");
        // float[] searchPoint1 = new float[k];
        // float[][] answer1 = new float[num][k];
        // for (int i = 0; i < kReal; i++) {
        //     searchPoint1[i] = input.nextFloat();
        // }
        // answer1 = tree.findmnn(searchPoint1, number, tree);
        // for (int i = 0; i < number; i++) {
        //     for (int j = 0; j < k; j++) {
        //         System.out.print(answer1[i][j] + " ");
        //     }
        //     System.out.print("\n____________________________________________________\n");
        // }

        // System.out.println("Enter search point:");
        // float[] searchPoint2 = new float[k];
        // for (int i = 0; i < kReal; i++) {
        //     searchPoint2[i] = input.nextFloat();
        // }
        // System.out.println(tree.searchNode(tree.root1, searchPoint2));

        // System.out.println("Which point do you want to delete? Enter the point:");
        // float[] searchPoint3 = new float[k];
        // for (int i = 0; i < kReal; i++) {
        //     searchPoint3[i] = input.nextFloat();
        // }
        // System.out.print("Point exist:");
        // System.out.println(tree.searchNode(tree.root1, searchPoint3));
        // tree.root1 = tree.deleteNode(tree.root1, searchPoint3);
        // System.out.print("Point exist:");
        // System.out.println(tree.searchNode(tree.root1, searchPoint3));

        // ********************** Finish

        // ********************** create KNNClassifier

        // System.out.println("How many points are you looking for?");
        // int number1 = input.nextInt();
        // KNNClassifier treeClassifier = new KNNClassifier(point, number1);

        // System.out.println("Enter the desired point:");
        // float[] searchPoint4 = new float[k];
        // for (int i = 0; i < kReal; i++) {
        //     searchPoint4[i] = input.nextFloat();
        // }
        // float javab = treeClassifier.classify(searchPoint4);
        // System.out.println(javab);

        // System.out.println("Enter the desired number of points: (calssify all)");
        // int number2 = input.nextInt();
        // System.out.println("Please enter target points:");
        // float[][] searchPoint5 = new float[number2][k];
        // float[] answer2 = new float[number2];
        // for (int i = 0; i < number2; i++) {
        //     for (int j = 0; j < kReal; j++) {
        //         searchPoint5[i][j] = input.nextFloat();
        //     }
        // }
        // answer2 = treeClassifier.classifyAll(searchPoint5, number2);
        // System.out.println("Labels in order:");
        // for (int i = 0; i < number2; i++) {
        //     System.out.println(answer2[i]);
        // }

        // System.out.println("Enter the desired number of points: ");
        // int number3 = input.nextInt();
        // System.out.println("Please enter target points:");
        // float[][] searchPoint6 = new float[number3][k];
        // for (int i = 0; i < number3; i++) {
        //     for (int j = 0; j < kReal; j++) {
        //         searchPoint6[i][j] = input.nextFloat();
        //     }
        // }
        // System.out.println("Enter correct label:");
        // float[] label = new float[number3];
        // for (int i = 0; i < number3; i++) {
        //     label[i] = input.nextFloat();
        // }
        // treeClassifier.accuracy(searchPoint6, label, number3);

        // ********************** Finish
    }
}
