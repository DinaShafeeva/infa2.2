package iterator;

import structure.Structure.Node;
import structure.Tree;
import java.util.Iterator;
import java.util.Stack;

public class IteratorDFS implements Iterator<Node> {
    private Tree tree;
    private Node node;
    private Stack<Node> stack, stack2;

    public IteratorDFS(Tree tree) {
        this.tree = tree;
        node = tree.getRoot();
        stack = new Stack<>();
        stack2 = new Stack<>();
        stack.add(tree.getRoot());
        fillStack();
    }

    private void fillStack() {
        while (!stack.empty()) {
            node = stack.pop();
            if (node.getChildren() != null) {
                stack.addAll(node.getChildren());
            }
            stack2.push(node);
        }
    }

        @Override
        public boolean hasNext () {
            return !stack2.isEmpty();
        }

        @Override
        public Node next() {
             node = stack2.pop();
            return node;
        }
}
