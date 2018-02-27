'''
Project 1
Henry O'Callaghan
CSci 1913
Spring 2018
Lab section 4
'''


class Random:
    def __init__(self, seed):
        self.num = seed

    def next(self):
        r = (16807 * self.num) % 2147483647
        self.num = r
        return r

    def choose(self, objects):
        i = self.next() % len(objects)
        return objects[i]


class Grammar:
    def __init__(self, seed):
        self.dictionary = {}
        self.random = Random(seed)

    def rule(self, left, right):
        if left in self.dictionary:
            temp = self.dictionary[left]
            self.dictionary[left] = temp + (right,)
        else:
            self.dictionary[left] = (right,)

    def generate(self):
        if 'Start' in self.dictionary:
            return self.generating(('Start',))
        else:
            raise RuntimeError

    def generating(self, strings):
        output = ''
        for s in strings:
            if s not in self.dictionary:
                output += s
                output += ' '
            else:
                output += self.generating(self.random.choose(self.dictionary[s]))
        return output

'''
G = Grammar(101)
print('Story 1')
G.rule('Noun',   ('cat',))
G.rule('Noun',   ('boy',))
G.rule('Noun',   ('dog',))
G.rule('Noun',   ('girl',))
G.rule('Verb',   ('bit',))
G.rule('Verb',   ('chased',))
G.rule('Verb',   ('kissed',))
G.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))
G.rule('Story',  ('Phrase',))
G.rule('Story',  ('Phrase', 'and', 'Story'))
G.rule('Start',  ('Story', '.'))
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())

H = Grammar(101)
print('\nStory 2')
H.rule('Noun',   ('apple',))
H.rule('Noun',   ('banana',))
H.rule('Noun',   ('man',))
H.rule('Noun',   ('woman',))
H.rule('Verb',   ('ate',))
H.rule('Verb',   ('threw',))
H.rule('Verb',   ('helped',))
H.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))
H.rule('Story',  ('Phrase',))
H.rule('Start',  ('Either', 'Phrase', 'and', 'Story', 'or', 'Phrase', 'and', 'Story', '.'))
print(H.generate())
print(H.generate())
print(H.generate())
print(H.generate())
'''
