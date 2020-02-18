package structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

public class Structure {

    @JsonIgnoreProperties({"parent"})
    public static class Node {

        private String name;
        private ArrayList<Node> children;
        private Node parent;
        private Type type;
        private int priority;

        public String getName() {
            return name;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public Node getParent() {
            return parent;
        }

        public Type getType() {
            return type;
        }

        public int getPriority() {
            return priority;
        }

        public void addChildren(Node node){
            children.add(node);
        }

        public static Builder builder(){
            return (new Node().new Builder());
        }

        public class Builder{
            public Builder() {
            }

            public Builder name(String name){
                Node.this.name = name;
                return this;
            }

            public Builder children(ArrayList<Node> children){
                Node.this.children = children;
                return this;
            }

            public Builder parent(Node parent){
                Node.this.parent = parent;
                return this;
            }

            public Builder type(Type type){
                Node.this.type = type;
                return this;
            }

            public Builder priority(int priority){
                Node.this.priority = priority;
                return this;
            }

            public Node build(){
                return Node.this;
            }

        }
    }

    public enum Type{
        COUNTRY,
        REGION,
        DISTRICT,
        CITY,
        STREET,
        HOUSE
    }
}
