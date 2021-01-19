def min_length(arr, target):
    right = 0
    _sum = 0
    _min = len(arr) + 1
    for j in range(0, len(arr)):
        _sum += arr[j]
        if _sum > target:
            while _sum - arr[right] > target and right < j:
                _sum -= arr[right]
                right += 1
            _min = min(_min, j - right + 1)
    if _min == len(arr) + 1:
        return -1
    return _min

if __name__ == "__main__":
    arr = [2, 4, 5 ,2, 2, 1, 3, 5]
    print min_length(arr, 100)
