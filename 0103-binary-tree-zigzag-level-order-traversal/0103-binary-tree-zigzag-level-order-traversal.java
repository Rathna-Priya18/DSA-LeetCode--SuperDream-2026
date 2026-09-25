import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            Deque<Integer> level = new ArrayDeque<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (leftToRight) {
                    level.offerLast(curr.val);
                } else {
                    level.offerFirst(curr.val);
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            result.add(new ArrayList<>(level));

            // Change direction for the next level
            leftToRight = !leftToRight;
        }

        return result;
    }
}