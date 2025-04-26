class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        '''

        Approach:
        - Sliding Window:

        Take a left pointer and a right pointer and then iterate the pointers till the end of the s
        initially take a counter of p and match it with the pointers counter. 
        If they match then append left pointer to the result

        '''

        left_pointer = 0
        right_pointer = len(p) - 1

        p_counter = Counter(p)
        current_counter = Counter(s[left_pointer: right_pointer + 1])

        res = []

        while right_pointer < len(s):

            if current_counter == p_counter:
                res.append(left_pointer)
            
            current_counter[s[left_pointer]] -= 1
            if current_counter[s[left_pointer]] == 0:
                del current_counter[s[left_pointer]]
            
            left_pointer += 1
            right_pointer += 1

            if right_pointer < len(s):
                current_counter[s[right_pointer]] += 1


        return res