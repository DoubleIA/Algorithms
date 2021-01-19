import random

def trailing_zeroes(num):
    """Counts the number of trailing 0 bits in num."""
    if num == 0:
        return 64 # Assumes 32 bit integer inputs!
    p = 0
    while (num >> p) & 1 == 0:
        p += 1
    return p

def estimate_cardinality(values, k):
    """Estimates the number of unique elements in the input set values.

    Arguments:
      values: An iterator of hashable elements to estimate the cardinality of.
      k: The number of bits of hash to use as a bucket number; there will be 2**k buckets.
    """
    num_buckets = 2 ** k
    max_zeroes = [0] * num_buckets
    for value in values:
        h = hash(value)
        bucket = h & (num_buckets - 1) # Mask out the k least significant bits as bucket ID
        bucket_hash = h >> k
        max_zeroes[bucket] = max(max_zeroes[bucket], trailing_zeroes(bucket_hash))
    return 2 ** (float(sum(max_zeroes)) / num_buckets) * num_buckets * 0.79402


if __name__ == "__main__":
    print [100000/estimate_cardinality([random.random() for i in range(100000)], 10) for j in range(10)]
