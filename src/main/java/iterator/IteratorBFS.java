package iterator;

import structure.Structure.Node;
import structure.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class IteratorBFS implements Iterator<Node> {
    private Tree tree;
    Deque<Node> deque;

    public IteratorBFS(Tree tree) {
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
                deque.addAll(node.getChildren());
            }
        }
        return node;
    }
}
