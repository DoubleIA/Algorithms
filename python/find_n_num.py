def find_n_digit(n):
    if n <= 0:
        return -1
    i = 0
    while True:
        i += 1
        ith_num = i * 9 * 10 ** (i - 1)
        if n > ith_num:
            n -= ith_num
        else:
            break
    r = n / i
    p = n % i
    num = 10 ** (i - 1) - 1 + r + (1 if p else 0)
    if p == 0:
        return num % 10
    return (num / 10 ** (i - p)) % 10


if __name__ == "__main__":
    # 1
    print 1
    print 1, find_n_digit(1), 1

    # 9
    print 9
    print 9, find_n_digit(9), 9

    # 10
    print 10
    print 10, find_n_digit(10), 1
    print 11, find_n_digit(11), 0

    # 19
    print 19
    print 28, find_n_digit(28), 1
    print 29, find_n_digit(29), 9

    # 20
    print 20
    print 30, find_n_digit(30), 2 
    print 31, find_n_digit(31), 0 

    # 29
    print 29
    print 48, find_n_digit(48), 2
    print 49, find_n_digit(49), 9 

    # 30
    print 30
    print 50, find_n_digit(50), 3
    print 51, find_n_digit(51), 0

    # 99
    print 99
    print 188, find_n_digit(188), 9
    print 189, find_n_digit(189), 9

    # 100
    print 100
    print 190, find_n_digit(190), 1
    print 191, find_n_digit(191), 0
    print 192, find_n_digit(192), 0


    # 102
    print 102
    print 196, find_n_digit(196), 1
    print 197, find_n_digit(197), 0
    print 198, find_n_digit(198), 2

    # 109
    print 109
    print 217, find_n_digit(217), 1
    print 218, find_n_digit(218), 0
    print 219, find_n_digit(219), 9

    # 199
    print 199
    print 487, find_n_digit(487), 1
    print 488, find_n_digit(488), 9
    print 489, find_n_digit(489), 9

    # 999
    print 999
    print 2887, find_n_digit(2887), 9
    print 2888, find_n_digit(2888), 9
    print 2889, find_n_digit(2889), 9

    # 1000
    print 1000
    print 2890, find_n_digit(2890), 1
    print 2891, find_n_digit(2891), 0
    print 2892, find_n_digit(2892), 0
    print 2893, find_n_digit(2893), 0
