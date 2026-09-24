class Solution {
public void flatten(TreeNode root) {
TreeNode curr = root;

while (curr != null) {

// If there is no left subtree,
// the node is already in the correct position.
if (curr.left == null) {
curr = curr.right;
continue;
}

// Find the rightmost node of the left subtree
TreeNode predecessor = curr.left;

while (predecessor.right != null) {
predecessor = predecessor.right;
}

// Connect the rightmost node of the left subtree
// to the original right subtree.
predecessor.right = curr.right;

// Move the left subtree to the right
curr.right = curr.left;

// Left pointer must always be null
curr.left = null;

// Move to the next node
        curr = curr.right;
                }
                    }
                    }
