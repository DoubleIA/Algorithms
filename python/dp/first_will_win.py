# coding=utf8
# 从左到右拿硬币，每次拿一个或拿两个，先拿的会不会累计和更大
def first_will_win(coins):
    n = len(coins)
    if n <= 2:
        return True
    sum_coins = [0] * n
    sum_coins[n - 1] = coins[n - 1]
    for i in range(n - 2, -1, -1):
        sum_coins[i] = sum_coins[i + 1] + coins[i]

    taken_max = [0] * n
    taken_max[n - 1] = coins[n - 1]
    taken_max[n - 2] = coins[n - 1] + coins[n - 2]
    for i in range(n - 3, -1, -1):
        taken_max[i] = sum_coins[i] - min(taken_max[i + 1], taken_max[i + 2])
    if taken_max[0] > sum_coins[0]:
        return True
    return False


if __name__ == "__main__":
    print first_will_win([1, 2, 4, 5, 4])
