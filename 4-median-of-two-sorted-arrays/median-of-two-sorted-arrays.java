class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 0) {
            int left = find(nums1, 0, m-1, nums2, 0, n-1, total / 2);
            int right = find(nums1, 0, m-1, nums2, 0, n-1, total / 2 + 1);
            return (left + right) / 2.0;
        }else {
            return find(nums1, 0, m-1, nums2, 0, n-1, total / 2 + 1);
        }
    }

    private int find(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        if((r1-l1) > (r2-l2)) return find(nums2, l2, r2, nums1, l1, r1, k);
        if (k == 1) {
            if (r1-l1 < 0) {
                return nums2[l2];
            }else{
                return Math.min(nums2[l2], nums1[l1]);
            }
        }
        if (r1-l1 < 0) {
            return nums2[l2+k-1];
        }

        int index1 = Math.min(nums1.length, l1 + k/2);
        int index2 = l2 + k - (index1-l1);
        if (nums1[index1-1] > nums2[index2-1]) {
            return find(nums1, l1, r1, nums2, index2, r2, k-(index2-l2));
        }else {
            return find(nums1, index1, r1, nums2, l2, r2, k-(index1-l1));
        }
    }
}