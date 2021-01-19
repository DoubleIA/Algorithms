def count_cut_tri(n):
    if n <= 3:
        return 1
    cnt = 0
    for k in range(n - 2):
        cnt += count_cut_tri(2 + k) * count_cut_tri(n - 1 - k)
    return cnt

if __name__ == "__main__":
    print count_cut_tri(3)
    print count_cut_tri(4)
    print count_cut_tri(5)
    print count_cut_tri(6)
    print count_cut_tri(7)
