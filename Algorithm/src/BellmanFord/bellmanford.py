'''
Theta(VE+E) -> Theta(VE) 
+E for check if there is a negative cycle

'''
def bellman_ford(graph,source):
    dist = {}
    parent = {}
    
    for v in graph:
        dist[v] = float('inf')
        parent[v] = None
    dist[source] = 0
    
    for i in range (len(graph) - 1):
        for u in graph:
            for v in graph[u]:
                if dist[v] > dist[u] + graph[u][v]:
                    dist[v] = dist[u] + graph[u][v]
                    parent[v] = u

    for u in graph:
        for v  in graph[u]:
            if dist[v] > dist[u] + graph[u][v]:
                return None, None

    return dist,parent

def test():
    graph = {
        'a': {'b': -1, 'c': 4},
        'b': {'c': 2, 'd': 3, 'e': 2},
        'c': {},
        'd': {'b': 3, 'c': 5},
        'e': {'d': -3}
    }
    dist, parent = bellman_ford(graph, 'a')
    print(dist)
    print(parent)

def testfail():
    graph = {
        'a': {'b': -2},
        'b': {'c': -2},
        'c': {'d': -2},
        'd': {'b': -2},
    }
    dist, parent = bellman_ford(graph, 'a')
    print(dist)
    print(parent)

test()
testfail()
