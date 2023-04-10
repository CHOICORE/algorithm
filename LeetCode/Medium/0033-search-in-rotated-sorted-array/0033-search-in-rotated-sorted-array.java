class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, 0, n-1);
        if (pivot == -1) {
            return binarySearch(nums, 0, n-1, target);
        } else if (nums[0] <= target && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        } else {
            return binarySearch(nums, pivot+1, n-1, target);
        }
    }
    
    private int findPivot(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (mid < hi && nums[mid] > nums[mid+1]) {
            return mid;
        } else if (mid > lo && nums[mid] < nums[mid-1]) {
            return mid - 1;
        } else if (nums[mid] <= nums[lo]) {
            return findPivot(nums, lo, mid-1);
        } else {
            return findPivot(nums, mid+1, hi);
        }
    }
    
    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
