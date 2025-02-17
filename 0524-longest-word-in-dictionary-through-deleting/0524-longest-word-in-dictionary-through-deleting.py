class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        def check(s1, s2):
            j = 0
            for i in range(len(s1)):
                if s1[i] == s2[j]:
                    j+=1
                    if j == len(s2):
                        return True
            return False
        
        a = -1
        for i,v in enumerate(dictionary):
            if check(s, v):
                if a == -1:
                    a = i
                else:
                    if len(dictionary[a]) < len(v):
                        a = i
                    elif len(dictionary[a]) == len(v):
                        if dictionary[a] > v:
                            a =i
        if a == -1:
            return ""
        return dictionary[a]