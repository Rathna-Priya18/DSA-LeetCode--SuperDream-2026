class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """

        stack=[]
        pairs = {')':'(', '}': '{', ']': '['}
        for c in s:
            if c in pairs.values():
                stack.append(c)
            else:
                    if not stack or stack.pop() != pairs[c]:
                        return False

        return not stack
        
        
