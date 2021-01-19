# coding=utf8
# 一列硬币，面额不同，两个人每次可以从任意两端取一枚硬币，求先取的人最多可以取多少
def coin_in_line(coins):
    dp = [[0] * len(coins) for _ in range(len(coins))]
    for it in range(len(coins)):
        i = 0
        j = it
        while j < len(coins):
            if i + 2 <= j:
                a = dp[i + 2][j]
            else:
                a = 0
            if i + 1 <= j - 1:
                b = dp[i + 1][j - 1]
            else:
                b = 0
            if i <= j - 2:
                c = dp[i][j - 2]
            else:
                c = 0
            dp[i][j] = max(coins[i] + min(a, b), coins[j] + min(b, c))
            i += 1
            j += 1
    return dp[0][len(coins) - 1]


if __name__ == "__main__":
    ori_coins = [6, 9, 1, 2, 16, 8]
    total = coin_in_line(ori_coins)
    print total, sum(ori_coins)
