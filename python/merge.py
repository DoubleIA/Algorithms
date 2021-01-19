def merge(arr, left, right):
    if left + 1 >= right:
        return arr, 0
    mid = (left + right) / 2
    arr1, c1 = merge(arr[left:mid], 0, mid - left)
    arr2, c2 = merge(arr[mid:right], 0, right - mid)
    i = 0
    j = 0
    tmp = []
    count = 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] <= arr2[j]:
            tmp.append(arr1[i])
            i += 1
        else:
            count += len(arr1) - i
            tmp.append(arr2[j])
            j += 1
    while i < len(arr1):
        tmp.append(arr1[i])
        i += 1
    while j < len(arr2):
        tmp.append(arr2[j])
        j += 1
    arr[left:right] = tmp
    return arr, c1 + c2 + count




if __name__ == "__main__":
    arr = [5, 4, 3, 1, 2, 6, 4, 3]
    print merge(arr, 0, len(arr))
