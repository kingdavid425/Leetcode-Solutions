# Given a string s, find the length of the longest substring without repeating characters.
# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        current = ""
        longest = 0
        partition = 0
        while partition < len(s):
            index = current.find(s[partition])

            if index != -1:
                s = s[index + 1:]
                longest = max(longest, len(current))

                if longest > len(s):
                    return longest

                partition = 0
                current = ""
                continue
            
            current += s[partition]
            partition += 1

        return max(partition, longest)


print(Solution().lengthOfLongestSubstring("dvdf"))