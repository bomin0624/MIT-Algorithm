# Analysis: θ(V+E)
# visit each vertex once in DFS alone. 

def dfs(graph,vertex):
    parents = {vertex: None}
    dfs_visit(vertex,graph,parents)

def dfs_visit(vertex,graph,parents):
    for n in graph[vertex]:
        if n not in parents:
            parents[n] = vertex
            dfs_visit(vertex,n,parents)