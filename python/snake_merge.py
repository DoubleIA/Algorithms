import Queue


class MergeInfo(object):
    def __init__(self, key, quota, step, values):
        self.key = key
        self.quota = quota
        self.step = step
        self.values = values


def snake_merge(merge_infos, counts):
    pq = Queue.PriorityQueue()
    steps = {}
    for info in merge_infos:
        pq.put((info.quota, (info.key, info.values, 0)))
        steps[info.key] = info.step
    results = []
    merge_keys = set({})

    while not pq.empty():
        if len(results) >= counts:
            break
        quota, (key, values, idx) = pq.get()
        if idx >= len(values):
            continue
        value = values[idx]
        if value not in merge_keys:
            results.append((quota, value))
            merge_keys.add(value)
        quota += steps[key]
        idx += 1
        pq.put((quota, (key, values, idx)))

    return results


if __name__ == "__main__":
    merge_infos = []
    merge_infos.append(MergeInfo('a', 1.0/2, 1.0/2, [1, 2, 3, 4, 5, 6, 7, 8]))
    merge_infos.append(MergeInfo('b', 1.0/4, 1.0/4, [10, 20, 30, 40, 50, 60, 70, 80]))
    merge_infos.append(MergeInfo('c', 1.0/3, 1.0/3, [100, 200, 300, 400, 500, 600, 700, 800]))
    print snake_merge(merge_infos, 25)
