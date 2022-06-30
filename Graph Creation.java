import java.util.*;

class Pair {
    int nbr;
    int wt;
    
    //for unweighted graph
    Pair(int nbr) {
        this.nbr = nbr;
        wt = 1;
    }
    
    //for weighted graph
    Pair(int nbr, int wt) {
        this.nbr = nbr;
        this.wt = wt; 
    }
}

class Graph {
    ArrayList<Pair>[] adj;
    
    Graph(int n) {
        adj = new ArrayList[n];
        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }
    }
 
    //for unweighted graph
    public void addEdge(int src,int dest) {
        adj[src].add(new Pair(dest));
        adj[dest].add(new Pair(src));
    }
    
    //for weighted graph
    public void addEdge(int src, int dest, int wt) {
          adj[src].add(new Pair(dest,wt));
          adj[dest].add(new Pair(src,wt));
    }
    
    public void printAdjList() {
        for(int i=0;i<adj.length;i++) {
            for(int j=0;j<adj[i].size();j++) {
                System.out.print(i + " -> (" + adj[i].get(j).nbr + "," + adj[i].get(j).wt + ")\t");
            }
            System.out.println();
        }
    }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int vtces = scn.nextInt();
        Graph g = new Graph(vtces);
        
        int edges = scn.nextInt();
        
        for(int i=0;i<edges;i++) {
            int src = scn.nextInt();
            int dest = scn.nextInt();
            int wt = scn.nextInt();
            g.addEdge(src,dest,wt);
        }
        
        g.printAdjList();
    }
}
