import queue


class HuffmanNode(object):
    def __init__(self, left=None, right=None):
        self.left = left
        self.right = right

    def children(self):
        return ((self.left, self.right))


def create_tree(freq):
    q = queue.PriorityQueue()
    for f in freq:
        q.put(f)
    while q.qsize() > 1:
        l, r = q.get(), q.get()
        n = HuffmanNode(l, r)
        q.put((l[0] + r[0], n))
    return q.get()


def walk_tree(node, prefix="", code={}):
    if isinstance(node[1], HuffmanNode):
        code1 = walk_tree(node[1].left, '0', code.copy())
        code2 = walk_tree(node[1].right, '1', code.copy())
        if len(code1) > 0:
            for k, v in code1.items():
                code[k] = prefix + v
        if len(code2) > 0:
            for k, v in code2.items():
                code[k] = prefix + v
    else:
        code[node[1]] = prefix
    return code


if __name__ == "__main__":
    freq = [(8.167, 'a'), (1.492, 'b'), (2.782, 'c'), (4.253, 'd'),
            (12.702, 'e'), (2.228, 'f'), (2.015, 'g'), (6.094, 'h'),
            (6.966, 'i'), (0.153, 'j'), (0.747, 'k'), (4.025, 'l'),
            (2.406, 'm'), (6.749, 'n'), (7.507, 'o'), (1.929, 'p'),
            (0.095, 'q'), (5.987, 'r'), (6.327, 's'), (9.056, 't'),
            (2.758, 'u'), (1.037, 'v'), (2.365, 'w'), (0.150, 'x'),
            (1.974, 'y'), (0.074, 'z')]

    node = create_tree(freq)
    code = walk_tree(node)
    for i in sorted(freq, reverse=True):
        try:
            print(i[1], '{:6.2f}'.format(i[0]), code[i[1]])
        except Exception as e:
            print(e)
            continue
