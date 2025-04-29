// Knotenklasse für den Binärbaum
class TreeNode<T extends Comparable<T>> {
    T key;
    TreeNode left, right;

    public TreeNode(T item) {
        key = item;
        left = right = null;
    }
}

// Binärbaumklasse
public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    // Methode zum Einfügen eines neuen Schlüssels
    public void insert(T key) {
        root = insertRec(root, key);
    }

    // Rekursive Einfügefunktion
    private TreeNode<T> insertRec(TreeNode root, T key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key.compareTo((T) root.key) < 0) {
            root.left = insertRec(root.left, key);
        } else if (key.compareTo((T) root.key) > 0) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Methode zur Suche eines Schlüssels
    public boolean search(T key) {
        return searchRec(root, key);
    }

    // Rekursive Suchfunktion
    private boolean searchRec(TreeNode<T> root, T key) {
        if (root == null) return false;
        if (root.key.equals(key)) return true;
        return key.compareTo((T) root.key) < 0 ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // In-Order Traversierung (sortierte Ausgabe)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode<T> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Hauptmethode zum Testen
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-Order Traversierung des Baumes:");
        tree.inorder();

        int keyToFind = 60;
        System.out.println("Ist " + keyToFind + " im Baum? " + tree.search(keyToFind));
    }
}
