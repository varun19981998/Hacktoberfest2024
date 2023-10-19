class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insert a node in the BST
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    // Search for a node in the BST
    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(TreeNode root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

        if (data < root.data) {
            return searchRecursive(root.left, data);
        } else {
            return searchRecursive(root.right, data);
        }
    }

    // Find the minimum value in the BST
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("The tree is empty.");
        }

        return findMinRecursive(root).data;
    }

    private TreeNode findMinRecursive(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Find the maximum value in the BST
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("The tree is empty.");
        }

        return findMaxRecursive(root).data;
    }

    private TreeNode findMaxRecursive(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // In-order traversal of the BST
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
        System.out.println();
    }

    private void inOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRecursive(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal:");
        bst.inOrderTraversal();

        int searchData = 40;
        System.out.println("Search for " + searchData + ": " + bst.search(searchData));

        System.out.println("Minimum value: " + bst.findMin());
        System.out.println("Maximum value: " + bst.findMax());
    }
}
