def min_cut_dp(s):
    l = len(s)
    p = [[False for i in range(l)] for _ in range(l)]
    m = [l] * (l + 1) # m[i] means the min cut between i and l - 1
    m[l] = -1
    return dp(s, p, m) 

def dp(s, p, m):
    l = len(s)
    for i in range(l-1, -1, -1):
        for j in range(i, l):
            if s[i] == s[j] and (j - i <= 1 or p[i+1][j-1]):
                p[i][j] = True
                m[i] = min(m[i], m[j + 1] + 1)
    return m[0]


def min_cut(s):
    l = len(s)
    if l <= 1:
        return 0
    if is_p(s):
        return 0

    min_c = l
    for i in range(1, len(s)):
        tmp = min_cut(s[:i]) + min_cut(s[i:]) + 1
        if min_c > tmp:
            min_c = tmp
    return min_c


def is_p(s):
    for i in range(len(s) / 2):
        if s[i] != s[len(s) - i - 1]:
            return False
    return True


if __name__ == "__main__":
    import time
    s = "abaababacefefec"
    t = time.time()
    print min_cut(s)
    e = time.time()
    print e - t
    print min_cut_dp(s)
    print time.time() - e

    s = "aaaaa"
    t = time.time()
    print min_cut(s)
    e = time.time()
    print e - t
    print min_cut_dp(s)
    print time.time() - e

    s = "abcedfghi"
    t = time.time()
    print min_cut(s)
    e = time.time()
    print e - t
    print min_cut_dp(s)
    print time.time() - e

    s = "abaababacefefec"
    t = time.time()
    print min_cut(s)
    e = time.time()
    print e - t
    print min_cut_dp(s)
    print time.time() - e
