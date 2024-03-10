// Two Pointer Approach
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int n = nums1.length;
        int m = nums2.length;
        while(i<n && j<m){
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }
            if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return -1;
    }
}

//Binary Search
public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // Binary search should be done on the larger array
        // If nums1 is longer,then swap the two arrays.
        // this will help in avoiding if else ladder!
        if (nums1.length > nums2.length) {
            return getCommon(nums2, nums1);
        }
        // for each element in nums1, do a binary search in nums2
        for (int num : nums1) {
            if (binarySearch(num, nums2)) {
                return num;
            }
        }

        // not found case
        return -1;
    }

    private boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]==target){
                return true;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            } 
        }
        return false;
    }
}

