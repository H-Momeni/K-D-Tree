public class KNNClassifier {
    KDTree tree = new KDTree(784);
    int k;

    public KNNClassifier(float[][] point,int k) { // dar inja in k neshan az k hamsaye nazdik darad na bodha
        tree.CreateTree(point);
        this.k=k;
    }

}
