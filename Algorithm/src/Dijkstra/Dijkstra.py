'''
Dijkstra (G, W, s) //uses priority queue Q
  Initialize (G, s)
  S ← φ
  Q ← V [G] //Insert into Q
  while Q != φ
      do u ← EXTRACT-MIN(Q) //deletes u from Q
      S = S ∪ {u}
      for each vertex v  Adj[u]
        do RELAX (u, v, w) ← this is an implicit DECREASE KEY operation

 Array:Theta(v^2) 
 Binary Min-heap: Theta(VlgV + ElgV)
 Fibonacci Heap: Theta(VlgV + E)       
'''

def dijkstra(Graph, weights, s):
  unfinished = dict()
  for u in Graph:  # create a dict of all unfinished vertices cost from s
    unfinished[u] = float('inf') # set infinite
  unfinished[s] = 0
  path_costs = dict()
  predecessors = {s: None}
  
  while unfinished:
    # get the closest vertex to s (starting with s)
    u = min(unfinished, key=unfinished.get)
    path_costs[u] = unfinished[u]  # record the cost to get there
    del unfinished[u]  # remove it from the set of unfinished vertices
    for v in Graph[u]:
      if v in path_costs:  # for each unfinished vertex adjacent to u
        continue #跳出本次循環

      # Relax  
      if unfinished[v] > path_costs[u] + weights[(u, v)]:  
          unfinished[v] = path_costs[u] + weights[(u, v)]
          predecessors[v] = u
  
  return path_costs, predecessors