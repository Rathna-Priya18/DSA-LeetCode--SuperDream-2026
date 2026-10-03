class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        double num = (double)a/b;
        int res = 0;
        for(int i=0;i<n;i++)
        {
            int y = 0, x = 0;
            for(int j = i;j<n;j++)
            {
                if(nums[j]%2==0)x++;
                else y++;

                double val = (double)x/y;
                if(val <= num)res++;
            }
        }
        return res;
    }
}