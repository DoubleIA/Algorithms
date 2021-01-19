def two_sum(arr, target):
    d = {}
    for i in range(len(arr)):
        if target - arr[i] in d:
            return (d[(target - arr[i])], i)
        else:
            d[arr[i]] = i
    return (-1, -1)


if __name__ == "__main__":
    print two_sum([5, 3, 4, 2, 7, 9], 5)

