def max_palindrome(s):
    l = len(s)
    dp = [[False for i in range(l)] for j in range(l)]
    for i in range(l - 1, -1, -1):
        for j in range(i, l):
            if i == j:
                dp[i][j] = True
            elif i + 1 == j and s[i] == s[j]:
                dp[i][j] = True
            elif i + 1 <= j - 1:
                dp[i][j] = dp[i + 1][j - 1] and s[i] == s[j]
    max_p = 0
    print dp
    for i in range(l):
        for j in range(i, l):
            if dp[i][j] and max_p < (j - i + 1):
                print i, j
                max_p = j - i + 1
    return max_p


if __name__ == "__main__":
    s = "aslflvkkvsdlkffkldssdsjflksdng"
    print max_palindrome(s)
