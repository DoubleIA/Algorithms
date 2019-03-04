def LSD(arr, R, W):
    for w in range(W - 1, -1, -1):
        count = [0] * (R + 1)
        for a in arr:
            count[int(a[w]) + 1] += 1
        for i in range(R):
            count[i + 1] += count[i]
        res = [0] * len(arr)
        for a in arr:
            res[count[int(a[w])]] = a
            count[int(a[w])] += 1
        arr = res
    return arr


if __name__ == "__main__":
    array = ["123423", "234233", "234225", "532432", "234235", "343532", "823984", "439058"]
    print LSD(array, 10, 6)
