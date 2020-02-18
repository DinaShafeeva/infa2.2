package facade;

import structure.Structure.Node;

import java.util.List;

public interface Facade {
    void writeTree(Node node);
    List<Node> readTree(String fileName);
}
