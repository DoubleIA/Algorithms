def perm(arr, start, end, res):
    if start >= end:
        res.append(arr[:])
    else:
        for i in range(start, end):
            arr[i], arr[start] = arr[start], arr[i]
            perm(arr, start+1, end, res)
            arr[i], arr[start] = arr[start], arr[i]
    return res

def get_next_perm(idxs):
    flag = False
    for i in range(len(idxs)-1, 0, -1):
        if idxs[i] > idxs[i-1]:
            flag = True
            change_idx = i - 1
            break
    if not flag:
        return flag
    for i in range(len(idxs)-1, -1, -1):
        if idxs[i] > idxs[change_idx]:
            base_idx = i
            break
    idxs[base_idx], idxs[change_idx] = idxs[change_idx], idxs[base_idx]
    idxs[change_idx+1:] = list(reversed(idxs[change_idx+1:]))
    return True

def perm_without_iter(arr, res):
    idxs = range(len(arr))
    res.append(arr)
    while get_next_perm(idxs):
        res.append([arr[idx] for idx in idxs])
    return res

def next( nums):
    length = len(nums)
    if length < 2:
        return nums
    index1 = length - 2
    while index1 >= 0:
        for index2 in range(index1+1, length):
            if nums[index1] < nums[index2]:
                temp_num = nums[index1]
                nums[index1] = nums[index2]
                nums[index2] = temp_num
                nums[index1 + 1 :] = sorted(nums[index1 + 1 :])
                return nums
        nums[index1 :] = sorted(nums[index1 :])
        index1 -= 1
    return nums

if __name__ == "__main__":
    a = ['a', 'b', 'c']
    a = [1, 2, 6, 4, 3]
    res = []
    # print perm(a, 0, len(a), res)
    # print perm_without_iter(a, res)
    print next(a)
