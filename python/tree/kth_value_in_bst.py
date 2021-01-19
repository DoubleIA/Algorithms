class Node(object):
    def __init__(self, left, right, value):
        self.left = left
        self.right = right
        self.value = value


def kth_value(root, k):
    val, _ = kth_value_count(root, k, 0)
    return val


def kth_value_count(root, k, count):
    if root is None:
        return -1, count
    if root.left is not None:
        val, count = kth_value_count(root.left, k, count)
        if count == k:
            return val, count
    count += 1
    if count == k:
        return root.value, count
    return kth_value_count(root.right, k, count)


def inorder(root, k):
    if not root:
        return 0, -1
    left_size, val = inorder(root.left, k)
    if val > 0:
        return left_size, val
    if left_size == k-1:
        return left_size+1, root.value
    right_size, val = inorder(root.right, k-left_size-1)
    if val < 0:
        return left_size + right_size + 1, -1
    else:
        return left_size + right_size + 1, val


if __name__ == "__main__":
    """
              3
             / \
            1   4
           / \   \
          0   2   10
                  /
                 6
    """
    lr = Node(None, None, 2)
    ll = Node(None, None, 1)
    l = Node(ll, lr, 1)
    rrl = Node(None, None, 6)
    rr = Node(rrl, None, 10)
    r = Node(None, rr, 4)
    root = Node(l, r, 3)
    print kth_value(root, 5)
    # print inorder(root, 3)
