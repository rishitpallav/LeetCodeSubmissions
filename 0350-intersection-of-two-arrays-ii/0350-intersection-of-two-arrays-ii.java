class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
        Different ways to solve:
        1. Sorted two arrays and use two pointers - n*log(n) sorting + O(n)
        2. Use a hashmap: count frequncies and verify - o(n) + o(n)
        3. Similar approach to hashmap, but use array: works only in lower constraints - o(n) 

        Follow Up:
        1. Use Two Pointers.
        2. Use HashMap for smaller one and keep iterating the larger and reduce the hashmap accordingly
        3. Use HashMap for nums1 and keep loading chunks and reducing the HashMap accordingly
        */

        int[] nums1Counter = new int[1001];
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums1) {
            nums1Counter[num]++;
        }

        for (int num : nums2) {
            if (nums1Counter[num] > 0) {
                result.add(num);
                nums1Counter[num]--;
            }
        }

        int[] res = new int[result.size()];

        for (int i = 0; i < result.size(); i++ ) {
            res[i] = result.get(i);
        }

        return res;
    }
}