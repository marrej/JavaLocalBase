import java.util.*;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {

    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Set<Integer> nonTraversedNodes = new HashSet<>();

    private List<Integer> dfsStack = new ArrayList<>();

    private List<Node> actualComponentNodes = new ArrayList<>();
    private Map<Integer, Component> components = new HashMap<>();
    private Integer componentCounter = 0;

    private Integer indegreeCounter = 0;

    public String testMethod() {
        return "method";
    }

    public Integer doKosarajuSimplified(List<List<Integer>> edges, List<Integer> nodes) {
        return new Kosaraju(edges, nodes).solve();
    }

    public Integer doKosaraju(List<List<Integer>> edges, List<Integer> nodes) {
        this.nonTraversedNodes = new HashSet<>(nodes);
        this.initAllNodes(nodes);
        this.initAllEdges(edges);

        this.doForwardDFS();
        this.nonTraversedNodes = new HashSet<>(nodes);
        this.doTransposedDFS();

        return indegreeCounter;
    }

    private void doTransposedDFS() {
        while (this.dfsStack.size() > 0) {
            var popFromTop = this.dfsStack.get(this.dfsStack.size()-1);
            actualComponentNodes = new ArrayList<>();
            this.recursiveTrDFS(popFromTop);

            if (this.actualComponentNodes.size() > 0) {
                var component = new Component(componentCounter);
                component.nodes.addAll(actualComponentNodes);
                component.indegree = this.getIndegree(component.nodes);
                if (component.indegree == 0 ) this.indegreeCounter++;
                this.components.put(componentCounter, component);
                componentCounter++;
            }
        }
    }

    private boolean recursiveTrDFS(Integer nodeId) {
        this.dfsStack.remove(nodeId);
        this.nonTraversedNodes.remove(nodeId);

        var node = this.nodeMap.get(nodeId);
        this.actualComponentNodes.add(node);
        var isSeparateComponent = true;

        if (node.parents.size() >= 0 && node.children.size() >= 0) {
            for (var parent: node.parents) {
                if (this.nonTraversedNodes.contains(parent.id)) {
                    isSeparateComponent = isSeparateComponent && this.recursiveTrDFS(parent.id);
                } else {
                    isSeparateComponent = false;
                }
            }
        }

        if (isSeparateComponent) {
            var component = new Component(componentCounter);
            component.nodes.add(node);
            component.indegree = this.getIndegree(component.nodes);
            if (component.indegree == 0 ) this.indegreeCounter++;
            this.components.put(componentCounter, component);
            componentCounter++;
            this.actualComponentNodes = new ArrayList<>();
        }

        return isSeparateComponent;
    }

    private Integer getIndegree(Set<Node> nodes) {
        var indegreeCount = 0;

        for (var node: nodes) {
            for (var parent: node.parents) {
                if (!nodes.contains(parent)) indegreeCount++;
            }
        }

        return indegreeCount;
    }

    private void doForwardDFS() {
        while (this.nonTraversedNodes.size() > 0) {
            var firstNode = this.nonTraversedNodes.stream().findFirst().get();
            this.recursiveFwDFS(firstNode);
        }
    }

    private void recursiveFwDFS(Integer nodeId) {
        this.nonTraversedNodes.remove(nodeId);
        var node = this.nodeMap.get(nodeId);
        for (var child: node.children) {
            if (this.nonTraversedNodes.contains(child.id)) this.recursiveFwDFS(child.id);
        }

        this.dfsStack.add(node.id);
    }

    private void initAllEdges(List<List<Integer>> edges) {
        for (var edge: edges) {
            var from = edge.get(0);
            var to = edge.get(1);

            var parent = this.nodeMap.get(from);
            var child = this.nodeMap.get(to);

            parent.children.add(child);
            child.parents.add(parent);
        }
    }

    private void initAllNodes(List<Integer> nodes) {
        for (var node: nodes) {
            nodeMap.put(node, new Node(node));
        }
    }
}


class Component {
    public Integer id = 0;
    public Set<Node> nodes = new HashSet<>();
    public Integer indegree = 0;

    public Component(Integer id) {
        this.id = id;
    }
}

class Node {
    public Integer id = 0;
    public Set<Node> parents = new HashSet<>();
    public Set<Node> children = new HashSet<>();

    public Node(Integer id) {
        this.id = id;
    }
}


class Kosaraju {
    public List<List<Integer>> edges;
    public List<Integer> nodes;

    private List<Integer> adjecencyList[];
    private Set<Integer> componentList = new HashSet<>();

    private Set<Integer> nonVisitedNodes = new HashSet<>();
    private List<Integer> stackToTraverse = new ArrayList<>();

    private Integer zeroIndegreeComponents = 0;

    private List<ComponentDef> allComponents = new ArrayList<>();

    public Kosaraju(List<List<Integer>> edges, List<Integer> nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public Integer solve() {
        this.initializeGraph();
        this.doForwardPass();
        this.transposeGraph();
        this.doBackwardPass();
        return this.getDisconnectedComponents();
    }

    private Integer getDisconnectedComponents() {
        var amountOfStarters = 0;
        for (var component: this.allComponents) {
            if (component.indegree ==0 ) amountOfStarters++;
        }
        return amountOfStarters;
    }

    private void initializeGraph() {
        this.adjecencyList = new List[this.nodes.size()+1];

        for (var i = 1; i <= this.nodes.size(); i++) {
            this.adjecencyList[i] = new ArrayList<>();
            nonVisitedNodes.add(i);
        }

        for (var edge: this.edges) {
            var from = edge.get(0);
            var to = edge.get(1);
            this.adjecencyList[from].add(to);
        }
    }

    private void doForwardPass() {
        while (nonVisitedNodes.size() > 0) {
            var node = nonVisitedNodes.stream().findFirst().get();
            this.forwardDFS(node);
        }
    }

    private void forwardDFS(Integer node) {
        this.nonVisitedNodes.remove(node);
        var adjacentList = this.adjecencyList[node];
        for (var adjacent: adjacentList) {
            if (nonVisitedNodes.contains(adjacent)) this.forwardDFS(adjacent);
        }
        this.stackToTraverse.add(node);
    }

    private void transposeGraph() {
        for (var i=1; i<= this.nodes.size() ; i++ ) {
            this.adjecencyList[i]= new ArrayList<Integer>();
            nonVisitedNodes.add(i);
        }

        for (var edge: this.edges) {
            var from = edge.get(0);
            var to = edge.get(1);

            this.adjecencyList[to].add(from);
        }
    }

    private void doBackwardPass() {
        while (this.stackToTraverse.size() > 0) {
            var node = this.stackToTraverse.get(this.stackToTraverse.size()-1);
            this.stackToTraverse.remove(node); // CHECK IF THIS REMOVES CORRECTLY
            if (this.nonVisitedNodes.contains(node)) this.doDFS(node);
            this.addNewComponent();
        }
    }

    private void addNewComponent() {
        if (this.componentList.size() > 0) {
            var component = new ComponentDef();
            component.indegree = this.getComponentIndegree();
            component.nodes = new HashSet<>(this.componentList);
            this.allComponents.add(component);
            this.componentList = new HashSet<>();
        }
    }

    private Integer getComponentIndegree() {
        var indegree = 0;
        for (var node: this.componentList) {
            for (var child: this.adjecencyList[node]) {
                if (!this.componentList.contains(child)) indegree++;
            }
        }
        return indegree;
    }

    private void doDFS(Integer node) {
        this.nonVisitedNodes.remove(node);
        for ( var child: this.adjecencyList[node]) {
            if (this.nonVisitedNodes.contains(child)) this.doDFS(child);
        }
        this.componentList.add(node);
    }
}

class ComponentDef {
    public Integer indegree = 0;
    public Set<Integer> nodes = new HashSet<>();
}

