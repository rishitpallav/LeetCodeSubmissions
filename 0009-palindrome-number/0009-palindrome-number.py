class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        elif x < 10:
            return True
        revX = 0
        tempX = x
        while(tempX):
            revX = (tempX%10) + (revX * 10)
            tempX //= 10
        if revX == x:
            return True
        return False