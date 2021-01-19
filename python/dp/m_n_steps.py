def steps(m, n):
    if n <= m:
        return 1 << (m - 1)
    dp = [0] * (n + 1)
    tmp = 0
    for i in range(1, m + 1):
        dp[i] = 1 << (i - 1)
        dp[0] += dp[i]
    for i in range(m + 1, n + 1):
        dp[i] = dp[0]
        dp[0] += dp[i]
        dp[0] -= dp[i - m]
    return dp

if __name__ == "__main__":
    m = 3
    n = 10
    print steps(m, n)
