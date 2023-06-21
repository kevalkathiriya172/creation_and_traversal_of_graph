import java.util.*;


class graph{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the value of vertex:");
        int V =sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean[] vis = new boolean[V];

        creategraph(graph,V);
        System.out.println("bfs:");
        bfs(graph,V);
        System.out.println();
        System.out.println("dfs:");
        dfs(graph,vis,0);

    }
    public static void creategraph(ArrayList<Edge> graph[],int V){
       // boolean[] vis = new boolean[V];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }

        // manual input
//        graph[0].add(new Edge(0,2));
//        graph[1].add(new Edge(1,2));
//        graph[1].add(new Edge(1,3));
//        graph[2].add(new Edge(2,0));
//        graph[2].add(new Edge(2,1));
//        graph[2].add(new Edge(2,3));
//        graph[3].add(new Edge(3,1));
//        graph[3].add(new Edge(3,2));
        int j=0;
        System.out.println("enter the all the edges of src and dest one by one  : ");

        while( true){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            if(src>V || dest>V){
                System.out.println("enter the valid input");
                continue;
            }

            graph[src].add(new Edge(src,dest));
            System.out.println("if you want to break then give -1 other wise give 0:");


            int c  = sc.nextInt();

            if(c==-1){
                break;
            }


        }



    }
    public static void bfs(ArrayList<Edge> graph[],int V){
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int n = q.remove();
            if(vis[n]==false){
                System.out.print(n+" ");
                vis[n]=true;
                for(int i=0;i<graph[n].size();i++){
                    Edge e = graph[n].get(i);
                    q.add(e.dest);

                }

            }
        }

    }
    public static void dfs(ArrayList<Edge> graph[],boolean[] vis,int current){
        System.out.print(current+" ");
        vis[current] = true;
        for(int i=0;i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            if(vis[e.dest]==false){
                dfs(graph,vis,e.dest);
            }
        }
    }

}
class Edge{
    int src;
    int dest;
    Edge(int n,int m){
        this.src = n;
        this.dest = m;
    }
}
