class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
          Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }
        
        // Step 2: Answer queries
        double[] result = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0; // unknown variable
            } else if (src.equals(dst)) {
                result[i] = 1.0; // same variable
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, src, dst, 1.0, visited);
            }
        }
        
        return result;
          }
    
    private double dfs(Map<String, Map<String, Double>> graph, String src, String dst, double product, Set<String> visited) {
        if (src.equals(dst)) return product;
        visited.add(src);
        
        for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double ans = dfs(graph, neighbor.getKey(), dst, product * neighbor.getValue(), visited);
                if (ans != -1.0) return ans;
            }
        }
        
        return -1.0;
    }
}