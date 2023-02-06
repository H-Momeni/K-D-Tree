import java.util.Arrays;

public class KNNClassifier {
    KDTree tree = new KDTree(785);
    int k;

    public KNNClassifier(float[][] point, int k) { // dar inja in k neshan az k hamsaye nazdik darad na bodha
        tree = tree.CreateTree(point);
        this.k = k;
    }

    public float classify(float[] point) {
        float element = Float.MIN_VALUE, max_count = 1, count = 1;
        float[][] arr1 = new float[k][785];
        float[] sort = new float[k];
        arr1 = tree.findmnn(point, k, tree);
        for (int i = 0; i < k; i++) {
            sort[i] = arr1[i][784];

        }
        Arrays.sort(sort);
        for (int i = 1; i < sort.length; i++) {
            if (sort[i] == sort[i - 1])
                count++;
            if (sort[i] != sort[i - 1] || i == sort.length - 1) {
                if (count > max_count) {
                    max_count = count;
                    element = sort[i - 1];
                }
                count = 1;
            }
        }
        return element;
    }

    public float[] classifyAll(float[][] point, int num) {
        float[] javab = new float[num];
        for (int i = 0; i < num; i++) {
            javab[i] = classify(point[i]);
        }
        return javab;
    }

    public void accuracy(float[][] point, float[] dorost, int num) {
        int count = 0;
        float[] answer = new float[num];
        answer = classifyAll(point, num);
        for (int i = 0; i < point.length; i++) {
            // System.out.println(point[i]+"\t"+dorost[i]);
            if (answer[i] == dorost[i]) {
                count++;
            } 
            // else {
            //     System.out.println(i + "\t" + answer[i] + "\t" + dorost[i]);
            // }
        }
        System.out.println(count * 100 / num + "%");
    }
}
