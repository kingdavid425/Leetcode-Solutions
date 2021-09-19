from math import floor

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """  
        array = []

        while nums1 != [] and nums2 != []:
            if nums1[0] < nums2[0]:
                array.append(nums1[0])
                nums1 = nums1[1:]
                continue
                
            array.append(nums2[0])
            nums2 = nums2[1:]

        array += nums1 + nums2

        if array == []:
            return 0
        
        if len(array) == 1:
            return array[0]

        if len(array) % 2 == 0:
            mid = int(len(array) / 2)
            return (array[mid] + array[mid - 1]) / 2
        
        mid = int(floor(len(array) / 2))
        return array[mid]
        