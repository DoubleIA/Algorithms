def k_p(ps, k):
    n = len(ps)
    dp = [[0 for _ in range(0, k + 1)] for _ in range(0, n + 1)]
    dp[0][0] = 1
    for i in range(1, n + 1):
        for j in range(0, k + 1):
            if j == 0:
                dp[i][j] = dp[i - 1][j] * (1 - ps[i - 1])
            else:
                dp[i][j] = dp[i - 1][j] * (1 - ps[i - 1]) + dp[i - 1][j - 1] * ps[i - 1]
    return dp[n][k]


if __name__ == "__main__":
    P = [0.1, 0.3, 0.5]
    K = 2
    print k_p(P, K)
    P = [0.8, 0.9, 0.7, 0.6]
    K = 3
    print k_p(P, K)
