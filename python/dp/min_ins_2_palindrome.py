def lcs(s, rs):
    dp = [[0 for _ in range(len(rs) + 1)] for _ in range(len(s) + 1)]
    ls = len(s)
    lrs = len(rs)
    for i in range(ls):
        for j in range(lrs):
            if s[i] == rs[j]:
                dp[i+1][j+1] = dp[i][j] + 1
            else:
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])
    return dp[len(s)][len(rs)]


def min_ins_2_pd(s):
    rs = s[::-1]
    m = lcs(s, rs)
    print m
    return len(s) - m

if __name__ == "__main__":
    t = "adsfsdbfa"
    print min_ins_2_pd(t)
