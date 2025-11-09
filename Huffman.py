import heapq

class Node:
    def __init__(self, ch, freq, left=None, right=None):
        self.ch, self.freq, self.left, self.right = ch, freq, left, right
    
    def __lt__(self, other): 
        return self.freq < other.freq

def print_codes(node, code=""):
    if not node.left and not node.right:
        print(node.ch, "->", code)
        return
    print_codes(node.left, code + "0")
    print_codes(node.right, code + "1")

chars  = ['a','b','c','d','e','f']
freqs  = [5,9,12,13,16,45]

heap = [Node(chars[i], freqs[i]) for i in range(len(chars))]
heapq.heapify(heap)

while len(heap) > 1:
    a, b = heapq.heappop(heap), heapq.heappop(heap)
    heapq.heappush(heap, Node('-', a.freq + b.freq, a, b))

print_codes(heap[0])
