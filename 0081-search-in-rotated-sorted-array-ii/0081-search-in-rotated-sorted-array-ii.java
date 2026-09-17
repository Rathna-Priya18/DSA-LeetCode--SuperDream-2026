class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // We found the answer
            if (nums[mid] == target)
                return true;

            // If nums[start] == nums[mid] == nums[end],
            // we cannot determine which half is sorted from those values.
            // Basically, we are getting rid of useless information
            // and moving on to new boundaries.
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }

            // Is nums[start] <= nums[mid]?
            // If yes, the left half [start ... mid] is sorted.
            else if (nums[start] <= nums[mid]) {

                // Check whether our target belongs in the left half.
                // Basically checking: nums[start] <= target < nums[mid]
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            // If the left half is not sorted,
            // the right half [mid ... end] must be sorted.
            else {

                // Check whether our target belongs in the right half.
                // Basically checking: nums[mid] < target <= nums[end]
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        // Target was not found
        return false;
    }
}