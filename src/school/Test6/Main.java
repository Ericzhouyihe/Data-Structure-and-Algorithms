package school.Test6;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        System.out.println("深度优先遍历（DFS）：");
        graph.DFS(0);

        System.out.println("\n广度优先遍历（BFS）：");
        graph.BFS(0);
    }
}
