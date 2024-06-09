import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class bfs {
    private Map<Character, List<Character>> list;

    public bfs() {
        this.list = new HashMap<>();
        Graph();
    }

    private void Graph() {
        list.put('A', Arrays.asList('B', 'D', 'E'));
        list.put('B', Arrays.asList('E'));
        list.put('D', Arrays.asList('G'));
        list.put('E', Arrays.asList('H', 'F'));
        list.put('G', Arrays.asList('H'));
        list.put('H', Arrays.asList('I'));
        list.put('I', Arrays.asList('F'));
        list.put('F', Arrays.asList('H', 'C'));
        list.put('C', Arrays.asList('B'));
    }

    public void bfs(char bfs) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        queue.offer(bfs);
        visited.add(bfs);

        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            System.out.print(vertex + " ");

            List<Character> neighbors = list.get(vertex);
            if (neighbors != null) {
                for (char neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        bfs graph = new bfs();

        System.out.println("BFS : ");
        graph.bfs('A');
    }
}