# https://leetcode.com/problems/add-two-numbers/
# You are given two non-empty linked lists representing two non-negative integers. 
# The digits are stored in reverse order, and each of their nodes contains a single digit. 
# Add the two numbers and return the sum as a linked list.
# You may assume the two numbers do not contain any leading zero, except the number 0 itself.

import math

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0

        output = None
        current = None

        x = l1.val
        y = l2.val

        sum = x + y + carry

        if sum > 9:
            carry = int(math.floor(sum / 10))
            sum = sum % 10

        output = ListNode(val=sum)
        current = output

        l1 = l1.next
        l2 = l2.next
        
        while l1 != None and l2 != None:
            x = l1.val
            y = l2.val

            sum = x + y + carry

            if sum > 9:
                carry = int(math.floor(sum / 10))
                sum = sum % 10
            else:
                carry = 0

            current.next = ListNode(val=sum)
            current = current.next
        
            l1 = l1.next
            l2 = l2.next

        while l1 != None:
            x = l1.val
            sum = int(x + carry)

            if sum > 9:
                carry = int(math.floor(sum / 10))
                sum = sum % 10
            else:
                carry = 0

            current.next = ListNode(val=sum)
            current = current.next

            l1 = l1.next

        while l2 != None:
            x = l2.val
            sum = int(x + carry)

            if sum > 9:
                carry = int(math.floor(sum / 10))
                sum = sum % 10
            else:
                carry = 0

            current.next = ListNode(val=sum)
            current = current.next

            l2 = l2.next        

        if carry != 0:
            current.next = ListNode(val=carry)

        return output
