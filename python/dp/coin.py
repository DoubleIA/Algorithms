# coding=utf8
# 给定任意一组硬币组合，和所需要的金额，求所用硬币最小的个数是多少
def get_min_coins(coins, value): # 可重复
    min_coins = [value] * (value + 1)
    min_coins[0] = 0
    for i in range(1, value + 1):
        for c in coins:
            if c <= i and min_coins[i - c] < min_coins[i]:
                min_coins[i] = min_coins[i - c] + 1
        print i, min_coins[i]
    return min_coins[value]

def get_min_coins_v2(coins, value): # 不可重复
    return dp(coins, value)

def dp(coins, value):
    print coins
    print value
    print '-' * 10
    
    if value < 0 or len(coins) == 0:
        return 100
    if value == coins[-1]:
        return 1
    res = min(dp(coins[:-1], value - coins[-1]) + 1, dp(coins[:-1], value))
    return res

def get_coins_pair(coins, value): # 不可重复组数
    if value <= 0 or len(coins) == 0:
        return 0
    if value == coins[-1]:
        return 1 + get_coins_pair(coins[:-1], value)
    res = get_coins_pair(coins[:-1], value - coins[-1]) + get_coins_pair(coins[:-1], value)
    return res


# def get_coins_pair(): # 可重复数组 ?


if __name__ == "__main__":
    # print get_min_coins([1, 2, 5], 13)
    # print get_min_coins_v2([1, 1, 3, 5, 7], 14)
    print get_coins_pair([1, 2, 3, 1, 2, 1], 3) # 8
