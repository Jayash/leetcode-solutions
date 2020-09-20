class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        ReturnValue returnedValue = createGraph(n, m, group, beforeItems);
        
        List<GraphGroupNode> graphGroup = new ArrayList<GraphGroupNode>(returnedValue.graphGroup.values());
        
        Map<Integer, GraphNode> graph = returnedValue.graph;
        
        List<GraphGroupNode> sortedGroup = new ArrayList<>();
        for(int i=0; i< graphGroup.size(); i++) {
            if(!topologicalSort(sortedGroup, graphGroup.get(i), returnedValue)) return new int[]{};
        }
        
        int ans[] = new int[n];
        
        int index = 0;
        for(int i=0; i< sortedGroup.size(); i++) {
            List<GraphNode> sortedNode = new ArrayList<>();
            for(int j=0; j< sortedGroup.get(i).node.size(); j++) {
                
                if(!topologicalSort(sortedNode, graph.get(sortedGroup.get(i).node.get(j)), returnedValue)) 
                   return new int[]{};
            }
            
            for(int j=0; j<sortedNode.size(); j++) {
                ans[index] = sortedNode.get(j).node;
                index++;
            }
        }
        
        return ans;
        
    }
    
    public boolean topologicalSort(List<GraphNode> sortedNode,  GraphNode node, ReturnValue value) {
        
        if(node.visited) return true;
        if(node.visiting) return false;
        node.visiting = true;
        
            for(int i=0; i< node.child.size(); i++) {
                if(!topologicalSort(sortedNode, value.graph.get(node.child.get(i)), value)) return false;
            }
            sortedNode.add(node);
        
        node.visiting = false;
        node.visited = true;
        return true;
    }
    
    public boolean topologicalSort(List<GraphGroupNode> sortedGroup,  GraphGroupNode node, ReturnValue value) {
        
        if(node.visited) return true;
        if(node.visiting) return false;
        node.visiting = true;
        
            for(int i=0; i< node.child.size(); i++) {
                if(!topologicalSort(sortedGroup, value.graphGroup.get(node.child.get(i)), value)) return false;
            }
            sortedGroup.add(node);
        
        node.visiting = false;
        node.visited = true;
        return true;
    }
    
    public ReturnValue createGraph(int n, int m, int[] group, 
                                                     List<List<Integer>> beforeItems) {
        
        
        Map<Integer, GraphGroupNode> graphGroup = new HashMap<>();
        
        Map<Integer, GraphNode> graph = new HashMap<>();
        int nonGroup = m;
        
        for(int i=0; i< n; i++) {
            GraphNode node = new GraphNode(i);
            graph.put(i, node);
            if(group[i] != -1) {
                if(!graphGroup.containsKey(group[i]))
                    graphGroup.put(group[i], new GraphGroupNode(group[i]));
                
                graphGroup.get(group[i]).node.add(node.node);
                node.group = group[i];
            } else {
                graphGroup.put(nonGroup, new GraphGroupNode(nonGroup));
                graphGroup.get(nonGroup).node.add(node.node);
                node.group = nonGroup;
                nonGroup++;
            }
        }
        
        for(int i=0; i< beforeItems.size(); i++) {
            List<Integer> before = beforeItems.get(i);
            
            GraphNode node = graph.get(i);
            int nodeGroup = node.group;
            for(int j: before) {
                if(graph.get(j).group == nodeGroup)
                    node.child.add(j);
                else {
                    //System.out.print(node.node + " " + nodeGroup + " " + graphGroup.get(nodeGroup) + " ");
                    graphGroup.get(nodeGroup).child.add(graph.get(j).group);
                }
            }
        }
        
        return new ReturnValue(graphGroup, graph);
    }
    
}

class ReturnValue {
    Map<Integer, GraphGroupNode> graphGroup;
    Map<Integer, GraphNode> graph;
    
    public ReturnValue(Map<Integer, GraphGroupNode> graphGroup, Map<Integer, GraphNode> graph) {
        this.graphGroup = graphGroup;
        this.graph = graph;
    }
}

class GraphGroupNode {
    int group;
    List<Integer> child;
    List<Integer> node;
    boolean visiting;
    boolean visited;
    
    public GraphGroupNode(int group) {
        child = new ArrayList<>();
        node = new ArrayList<>();
        this.group = group;
    }
}

class GraphNode {
    int node;
    List<Integer> child;
    boolean visiting;
    boolean visited;
    int group;
    public GraphNode(int node) {
        child = new ArrayList<>();
        this.node = node;
    }
}

/*

    create Group of m
    
    apply topological sort
    
    for every group apply topological sort
    
    apply topological sort

*/
