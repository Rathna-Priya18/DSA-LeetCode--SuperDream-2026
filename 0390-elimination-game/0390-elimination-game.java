class Solution {
    public int lastRemaining(int n) {
        int left = 1;
        int right = n;
        int step = 1;
        boolean fromLeft = true;

        while (left < right) {
            int nums = (right - left) / step + 1;
            if (fromLeft) {
                left += step;
                if (nums % 2 == 1) right -= step;
            } else {
                right -= step;
                if (nums % 2 == 1) left += step;
            }
            fromLeft = !fromLeft;
            step *= 2;
        }
        return left;
    }
}