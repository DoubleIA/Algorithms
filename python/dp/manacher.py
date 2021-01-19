def init(s):
    new_s = "$"
    for c in s:
        new_s += "#" + c
    new_s += "#"
    return new_s

def manacher(s):
    new_s = init(s)
    l = len(new_s)
    idx = 0
    mx = 0
    max_p = 0
    p = [0] * l
    for i in range(1, l - 1):
        if i < mx:
            p[i] = min(p[2 * i - idx], mx - i)
        else:
            p[i] = 1
        while (i + p[i] < l) and (new_s[i - p[i]] == new_s[i + p[i]]):
            p[i] += 1
        if mx < i + p[i]:
            idx = i
            mx = i + p[i]
        max_p = max(max_p, p[i] - 1)
    return max_p

if __name__ == "__main__":
    s = "aslflvkkvsdlkffkldssdsjflksdng"
    print manacher(s)
