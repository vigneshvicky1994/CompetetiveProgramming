import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class dimmingstar {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Graph graph = new Graph(100);
        for(int i=0;i<n;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph.addEdge(x,y);

        }
        int start = scan.nextInt();
        graph.finddimmest(start-1);
    }
}

class Graph{

    private int V;
    private LinkedList<Integer> adj[]   ;
    private int[] size;

    Graph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++) adj[i] = new LinkedList<>();
        size = new int[V];
    }
    public void addEdge(int v,int w){
        adj[v-1].add(w-1);
    }
    public void finddimmest(int start){
        findrecdim(start,0);
        System.out.println(findIndex());
    }

    private int findIndex() {
        int index = Integer.MAX_VALUE;
        int max =0;
        for(int i=0;i<size.length;i++){
            if(size[i] > max){
                max = size[i];
                index = i;
            }else if(size[i] == max) if (i < index) index = i;
        }
        return index + 1;
    }

    private void findrecdim(int start, int i) {
        size[start] = i;
        Iterator<Integer> itr = adj[start].iterator();
        while(itr.hasNext()){
            int val = itr.next();
            findrecdim(val,i+1);
        }
    }
}

