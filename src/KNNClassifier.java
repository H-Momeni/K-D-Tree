public class KNNClassifier {
    KDTree tree = new KDTree(784);
    int k;

    public KNNClassifier(float[][] point, int k) { // dar inja in k neshan az k hamsaye nazdik darad na bodha
        tree=tree.CreateTree(point);
        this.k = k;
        // for (int i = 0; i < point.length; i++)
        // System.out.println(point[i][784]);

        // for (int i = 0; i < 10; i++) {
        //     for (int j = 0; j < point[1].length; j++) {
        //         System.out.print(point[i][j]+"\t");
        //     }
        //     System.out.print("\n**********************************************************************************************************************\n");
        //     //System.out.println(arr1[i][784]);
        // }
    }

    public int classify(float[] point) {

        float[][] arr1 = new float[k][784];
        arr1=tree.findmnn(point, k, tree);
        System.out.println(arr1[1].length);
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[1].length; j++) {
                System.out.print(arr1[i][j]+"\t");
            }
            System.out.print("\n**********************************************************************************************************************\n");
            //System.out.println(arr1[i][784]);
        }



        return k;

    }
}
