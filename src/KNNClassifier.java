import java.util.Arrays;

import javax.lang.model.element.Element;

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
        // System.out.println(arr1[1].length);

        // for (int i = 0; i < arr1.length; i++) {
        // for (int j = 0; j < 785; j++) {
        // System.out.print(arr1[i][j]+"\t");
        // }
        // System.out.print("\n**********************************************************************************************************************\n");
        // //System.out.println(arr1[i][784]);
        // }

        for (int i = 0; i < k; i++) {
            sort[i] = arr1[i][784];

        }
        Arrays.sort(sort);
        for (int i = 1; i < sort.length; i++) {
            // count the successive elements as long as they are same
            if (sort[i] == sort[i - 1])
                count++;

            if (sort[i] != sort[i - 1] || i == sort.length - 1) {
                // compare the count with max_count
                if (count > max_count) {

                    // update if count is greater
                    max_count = count;
                    element = sort[i - 1];
                }
                // reset count to 1
                count = 1;
            }
        }

        return element;

    }

    
}
