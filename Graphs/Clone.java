public class Clone {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        return clone(node, visited);
    } 
    private Node clone(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor, visited));
        }
        return newNode;
    }
}
