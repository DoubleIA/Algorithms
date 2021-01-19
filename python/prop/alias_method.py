import numpy as np

class AliasMethod(object):
    def __init__(self, distribution):
        self.prop, self.alias = self.build(distribution)

    def build(self, distribution):
        n = len(distribution)
        prop = [0] * n
        alias = [0] * n
        dis = len(distribution) * np.array(distribution)
        small = np.where(dis < 1)[0].tolist()
        large = np.where(dis >= 1)[0].tolist()
        while len(small) > 0 and len(large) > 0:
            s_idx, small = small[0], small[1:]
            l_idx, large = large[0], large[1:]
            prop[s_idx] = dis[s_idx]
            alias[s_idx] = l_idx
            dis[l_idx] -= 1 - dis[s_idx]
            if dis[l_idx] >= 1:
                large.append(l_idx)
            else:
                small.append(l_idx)

        while len(large) > 0:
            l_idx, large = large[0], large[1:]
            prop[l_idx] = 1
        
        while len(small) > 0:
            s_idx, small = small[0], small[1:]
            prop[s_idx] = 1

        return prop, alias
    
    def sample(self):
        k = np.random.randint(0, len(self.prop))
        p = np.random.rand()
        if self.prop[k] > p:
            return k
        else:
            return self.alias[k]


if __name__ == '__main__':
    dis = [0.3, 0.05, 0.05, 0.2, 0.1, 0.3]
    alias_method = AliasMethod(dis)

    N = 1000000
    X = [0 for i in range(N)]
    for nn in xrange(N):
        X[nn] = alias_method.sample()
    a_dict = {}
    for x in X:
        a_dict.setdefault(x, 0)
        a_dict[x] += 1
    for k, v in a_dict.iteritems():
        print k, v/float(N)
