def perm(arr, start, end, result):
    if start >= end:
        result.append(arr[:])
    else:
        for i in range(start, end):
            arr[i], arr[start] = arr[start], arr[i]
            perm(arr, start + 1, end, result)
            arr[i], arr[start] = arr[start], arr[i]

def perm_without_iter(arr, result):
    idxs = range(len(arr))
    result.append(arr[:])
    while get_next_perm(idxs):
        result.append([arr[i] for i in idxs])


def get_next_perm(idxs):
    flag = False
    for i in range(len(idxs) - 1, 0, -1):
        if idxs[i] > idxs[i - 1]:
            flag = True
            change_idx = i - 1
            break
    if not flag:
        return flag
    for i in range(len(idxs) - 1, 0, -1):
        if idxs[i] > idxs[change_idx]:
            base_idx = i
            break
    idxs[change_idx], idxs[base_idx] = idxs[base_idx], idxs[change_idx]
    idxs[change_idx + 1:] = list(reversed(idxs[change_idx+1:]))
    return True


def combinations(arr, r=None):
    n = len(arr)
    r = n if not r else r
    pool = tuple(arr)
    if r > n:
        return
    idxs = range(r)
    yield tuple(pool[i] for i in idxs)
    while True:
        for i in reversed(range(r)):
            if idxs[i] != i + n - r:
                break
        else:
            return
        idxs[i] += 1
        for j in range(i + 1, r):
            idxs[j] = idxs[j - 1] + 1
        yield tuple(pool[i] for i in idxs)


def permutations(arr, r=None):
    n = len(arr)
    r = n if not r else r
    pool = tuple(arr)
    if r > n:
        return
    idxs = range(n)
    cycs = range(n, n - r, -1)
    yield tuple(pool[i] for i in idxs[:r])
    while True:
        for i in reversed(range(r)):
            cycs[i] -= 1
            if cycs[i] == 0:
                cycs[i] = n - i
                idxs[i:] = idxs[i+1:] + idxs[i:i+1]
            else:
                j = cycs[i]
                idxs[i], idxs[-j] = idxs[-j], idxs[i]
                yield tuple(pool[i] for i in idxs[:r])
                break
        else:
            return

if __name__ == "__main__":
    a = ['a', 'b', 'c', 'd', 'e']
    res = []
    perm(a, 0, len(a), res)
    print a
    print res
    res = []
    perm_without_iter(a, res)
    print res
    for c in combinations(a, 2):
        print c
    for c in combinations(a, 3):
        print c
    print "-" * 100
    for c in permutations(a, 2):
        print c
    for c in permutations(a, 3):
        print c
