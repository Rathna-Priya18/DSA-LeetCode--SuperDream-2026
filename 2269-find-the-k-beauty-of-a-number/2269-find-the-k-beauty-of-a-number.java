class Solution {
    public int divisorSubstrings(int num, int k) {
        int left = 0;
        int right = 0;
        String st = String.valueOf(num);
        int count = 0;

        while (right <= st.length() - k) {
            int window = Integer.parseInt(st.substring(left, left + k));

            if (window != 0 && num % window == 0) {
                count++;
            }
            left++;
            right++;
        }

        return count;
    }
}