import random

def judge_shuffle(arr):
    for i in range(len(arr), 0, -1):
        rn = random.randint(0, i-1)
        arr[i - 1], arr[rn] = arr[rn], arr[i - 1]
    return arr


if __name__ == "__main__":
    d = {}
    iters = 1200000
    for i in range(iters):
        k = judge_shuffle(range(0, 5))
        key = ",".join(map(str, k))
        if key not in d:
            d[key] = 0
        d[key] += 1
    print d
    print len(d)
    for (k, v) in d.items():
        print k, v * 1.0 / iters
    print judge_shuffle(range(0, 10))
