# Given a string s, return the longest palindromic substring in s.
# https://leetcode.com/problems/longest-palindromic-substring/

# Citations: https://en.wikipedia.org/wiki/Longest_palindromic_substring

from math import floor

class Solution:
    def longestPalindrome(self, s: str) -> str:
        sPrime = self.getSPrime(s)

        palindromeRadii = [0] * len(sPrime)

        center = 0
        radius = 0

        while center < len(sPrime):

            while center - (radius + 1) >= 0 and center + (radius + 1) < len(sPrime) and sPrime[center - (radius + 1)] == sPrime[center + (radius + 1)]:
                radius += 1

            palindromeRadii[center] = radius

            oldCenter = center
            oldRadius = radius
            center += 1

            radius = 0
            while center <= oldCenter + oldRadius:
                mirroredCenter = oldCenter - (center - oldCenter)
                maxMirroredRadius = oldCenter + oldRadius - center
                if palindromeRadii[mirroredCenter] < maxMirroredRadius:
                    palindromeRadii[center] = palindromeRadii[mirroredCenter]
                    center += 1
                elif palindromeRadii[mirroredCenter] > maxMirroredRadius:
                    palindromeRadii[center] = maxMirroredRadius
                    center += 1
                else:
                    radius = maxMirroredRadius
                    break

        maxValue = max(palindromeRadii)
        maxIndex = palindromeRadii.index(maxValue)
        offset = palindromeRadii[maxIndex]
        palindrome = sPrime[maxIndex - offset: maxIndex + offset].replace("|", "")
        return palindrome


    def getSPrime(self, s: str):
        s_prime = "|"
        for c in s:
            s_prime += c + "|"

        return s_prime