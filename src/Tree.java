import java.util.Arrays;

public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
    private Integer root = null;
    private Tree[] subtrees = null;

    public Tree(Integer root, Tree[] subtrees) {
        this.root = root;
        if (subtrees == null) {
            this.subtrees = new Tree[0];
        } else{
            this.subtrees = Arrays.copyOf(subtrees, subtrees.length);
        }
    }
    public boolean isEmpty() {
        return root == null && subtrees.length == 0;
    }
    public Integer len() {
        if (isEmpty()) {
            return 0;
        } else {
            int size = 0;
            for (Tree subtree : subtrees) {
                size += subtree.len();
            }
            return size;
        }
    }
    public Integer count(Integer item) {
        if (isEmpty()) {
            return 0;
        }else{
            int num = 0;
            if (this.root == item) {
                num += 1;

            }
            for (Tree subtree : subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }
    public String str() {
        return strIndented(0);
    }
    private String strIndented(Integer depth) {
        if (isEmpty()) {
            return "";
        }else{
            StringBuilder s = new StringBuilder();
            s.append("  ".repeat(depth));
            s.append(root);
            s.append("\n");
            for (Tree subtree : subtrees) {
                s.append(subtree.strIndented(depth + 1));
            }
            return s.toString();
        }

    }
    public double average() {
        if (isEmpty()) {
            return 0.0;
        } else {
            double[] result = averageHelper();
            return result[0] / result[1];
        }
    }
    private double[] averageHelper() {
        if (isEmpty()) {
            return new double[]{0, 0};
        } else {
            double total = root != null ? root : 0;
            double size = root != null ? 1 : 0;

            for (Tree subtree : subtrees) {
                double[] subtreeResult = subtree.averageHelper();
                total += subtreeResult[0];
                size += subtreeResult[1];
            }

            return new double[]{total, size};
        }
    }
}
