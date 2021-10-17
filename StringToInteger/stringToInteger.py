class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """

        MIN_INTEGER = -2147483648
        MAX_INTEGER = 2147483647

        # 1. Read in and ignore any leading whitespace.
        s = s.lstrip()

        # 2. Check if the next character (if not already at the end of the string) is '-' or '+'. 
        # Read this character in if it is either. This determines if the final result is negative or 
        # positive respectively. Assume the result is positive if neither is present.
        if len(s) == 0:
            return 0
        
        if s[0] == "-":
            is_negative = True
            s = s[1:]
        elif s[0] == "+":
            is_negative = False
            s = s[1:]
        else:
            is_negative = False

        # 3. Read in next the characters until the next non-digit character or the end of the input is
        # reached. The rest of the string is ignored.
        new_s = ""
        for c in s:
            if ord(c) < 48 or ord(c) > 57:
                break

            new_s += c

        # 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were
        # read, then the integer is 0. Change the sign as necessary (from step 2).
        if new_s == "":
            return 0
        
        num = int(new_s)

        if is_negative:
            num = num * -1

        # 5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the
        # integer so that it remains in the range. Specifically, integers less than -2^31 should be
        # clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
        if num < MIN_INTEGER:
            return MIN_INTEGER

        if num > MAX_INTEGER:
            return MAX_INTEGER

        # 6. Return the integer as the final result.
        return num


