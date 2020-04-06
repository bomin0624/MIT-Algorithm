# Analysis: θ(V+E)
# visit each vertex once in DFS alone. 

def dfs(graph,vertex):
    parents = {vertex: None}
    dfs_visit(graph,vertex,parents)


def dfs_visit(graph,vertex,parents):
    for n in graph[vertex]:
        if n not in parents:
            parents[n] = vertex
            dfs_visit(graph,n,parents)