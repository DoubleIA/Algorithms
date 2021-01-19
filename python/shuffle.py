import random

def shuffle(arr):
    n = len(arr)
    for i in range(n):
        idx = random.randint(i, n - 1)
        tmp = arr[i]
        arr[i] = arr[idx]
        arr[idx] = tmp
    return arr


if __name__ == "__main__":
    d = {}
    tot = 500000
    for i in range(tot):
        arr = [1, 2, 3]
        arr = shuffle(arr)
        key = ",".join(map(str, arr))
        if key not in d:
            d[key] = 0
        d[key] += 1
    for k, v in d.items():
        print k, v, v * 1.0 / tot
