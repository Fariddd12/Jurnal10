import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {
    private static Map<Character, List<Character>> graf = new HashMap<>();

    private static void dfs(Character node, Set<Character> visited) {
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);

            List<Character> neighbors = graf.get(node);
            for (Character neighbor : neighbors) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void Graph(){
        graf.put('A', Arrays.asList('B', 'D', 'E'));
        graf.put('B', Arrays.asList('E'));
        graf.put('D', Arrays.asList('G'));
        graf.put('E', Arrays.asList('H', 'F'));
        graf.put('G', Arrays.asList('H'));
        graf.put('H', Arrays.asList('I'));
        graf.put('I', Arrays.asList('F'));
        graf.put('F', Arrays.asList('C'));
        graf.put('C', new ArrayList<>());
    }

    public static void main(String[] args) {
        Graph();
        System.out.println("DFS : ");
        Set<Character> visited = new HashSet<>();
        dfs('A', visited);
    }
}
