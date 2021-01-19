def count_bst(n):
    if n <= 1:
        return n
    b = [0] * (n + 1)
    print b
    b[0] = 1
    b[1] = 1
    for i in range(2, n+1):
        for j in range(i):
            print i, j, i - 1 - j
            b[i] += b[j] * b[i - 1 - j]
    return b[n]


if __name__ == "__main__":
    print count_bst(0)
    print count_bst(1)
    print count_bst(2)
    print count_bst(3)
    print count_bst(4)
