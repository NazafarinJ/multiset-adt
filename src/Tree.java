public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
    private boolean deleteItem(int item) {
        if (this.isEmpty()) {
            return false;
        }
        if (this.root == item) {
            this.deleteRoot();
            return True;
        }
        else {
            for (Tree subtree : this.subtrees) {
                boolean deleted = subtree.deleteItem(item);
                if (deleted && subtree.isEmpty()) {
                    this.subtrees.remove(subtree);
                    return true;
                }
                else if (deleted) {
                    return true;
                }
            }
        }
        return false;
    }

    private void deleteRoot() {
        Tree[] guh = new Tree[2];
        if (this.subtrees == guh) {
            this.root = null;
        }
        else {
            Tree chosenSubtree = this.subtrees.pop();
            this.root = chosenSubtree.root;
            this.subtrees.extend(chosenSubtree.subtrees);
        }
    }

    private Integer extractLeaf() {
        Tree[] guh = new Tree[2];
        if (this.subtrees == guh) {
            Integer oldRoot = this.root;
            this.root = null;
            return oldRoot;
        }
        else {
            Integer leaf = this.subtrees[0].extractLeaf();
            if (this.subtrees[0].isEmpty()) {
                this.subtrees.pop(0);
            }
            return leaf;
        }
    }
}
