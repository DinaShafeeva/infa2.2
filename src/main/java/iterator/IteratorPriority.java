package iterator;

import structure.Structure.Node;
import structure.Tree;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class IteratorPriority implements Iterator<Node> {

    private Tree tree;
    private Deque<Node> deque;
    private Comparator<Node> comparator = ((o1, o2) -> o2.getPriority() - o1.getPriority());

    public IteratorPriority(Tree tree) {
        this.tree = tree;
        deque = new ArrayDeque<>();
        deque.add(tree.getRoot());
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    @Override
    public Node next() {
        Node node = deque.pollFirst();
        if (node.getChildren() != null){
            if (!node.getChildren().isEmpty()){
                ArrayList<Node> newList = node.getChildren().stream().sorted(comparator).collect(Collectors.toCollection(ArrayList::new));
                deque.addAll(newList);
            }
        }
        return node;
    }
}
