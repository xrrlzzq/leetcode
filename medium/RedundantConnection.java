/**
leetcode no.684
description:
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

example:
input [[1,2],[1,3],[2,3]]
output: [2,3]

solution:
This is the classic union find problem, use union find API, and join each connected node in the same union, if the two node is in the same union, then it is redundant connection

**/
class Solution {
    class UnionFind{
      private int count=0;
      private int[] parent,rank;
    
      public UnionFind(int n){
          count=n;
          parent=new int[n+1];
          rank=new int[n+1];
          for(int i=1;i<=n;i++){
              parent[i]=i;
          }
      } 
      public int find(int p){    // path compress
          while(p!=parent[p]){
              parent[p]=parent[parent[p]];
              p=parent[p];
          }
          return p;
      }
      public void union(int p, int q){ 
          int pid=find(p);
          int qid=find(q);
          if(pid==qid)
              return;
          if(rank[qid]>rank[pid]) 
              parent[pid]=qid;
          else{
              parent[qid]=pid;
              if(rank[pid]==rank[qid])
                  rank[pid]++;
          }
          count--;
      }
      public int getCount(){
          return count;
      }
    }
    public int[] findRedundantConnection(int[][] edges) {
           UnionFind uf=new UnionFind(edges.length);
           for(int i=0;i<edges.length;i++){
               int[] temp=edges[i];
               if(uf.find(temp[0])==uf.find(temp[1]))
                   return temp;
               uf.union(temp[0],temp[1]);
           }
        return new int[1];
    }
}