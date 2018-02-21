class Random:
    def __init__(self, seed):
        self.n = seed

    def next(self):
        r = (7^5 * self.n) % (2^31 - 1)
        self.n += 1
        return r

    def choose(self, objects):
        i = next() % len(objects)
        return objects[i]


class Grammar:
    def __init__(self, seed):
        self.d = {}
        self.r = Random(seed)

    def rule(self, left, right):
        if left in self.d:
            temp = self.d[left]
            self.d[left] = temp + right
        else:
            self.d[left] = right

    def generate(self, strings):
        o = ''
        for s in strings:
            if s not in self.d:
                o += s
                o += ' '
            else:
                return self.generate(self.r.choose(self.d[s]))


G = Grammar(101)
G.rule('Noun',   ('cat',))                                #  01
G.rule('Noun',   ('boy',))                                #  02
G.rule('Noun',   ('dog',))                                #  03
G.rule('Noun',   ('girl',))                               #  04
G.rule('Verb',   ('bit',))                                #  05
G.rule('Verb',   ('chased',))                             #  06
G.rule('Verb',   ('kissed',))                             #  07
G.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))  #  08
G.rule('Story',  ('Phrase',))                             #  09
G.rule('Story',  ('Phrase', 'and', 'Story'))              #  10
G.rule('Start',  ('Story', '.'))                          #  11
n = Random(4999)
