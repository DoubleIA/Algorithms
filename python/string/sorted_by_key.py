def sorted_by_key(arr, R):
    count = [0] * (R + 1)
    print count
    for a in arr:
        count[a[1] + 1] += 1
    print count
    for i in range(len(count) - 1):
        count[i + 1] += count[i]
    print count
    res = [0] * len(arr)
    for a in arr:
        res[count[a[1]]] = a
        count[a[1]] += 1
    arr = res
    return arr


if __name__ == "__main__":
    array = [("a", 1), ("d", 2), ("g", 3), ("h", 3), ("i", 3), ("b", 1),
             ("e", 2), ("f", 3), ("c", 1)]
    print sorted_by_key(array, 4)
