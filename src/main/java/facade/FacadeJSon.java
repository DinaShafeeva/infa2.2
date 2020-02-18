package facade;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import structure.Structure.Node;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FacadeJSon implements Facade {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void writeTree(Node node) {
        try(FileWriter writer = new FileWriter("json.txt", false))
        {
            String json = mapper.writeValueAsString(node);
            writer.write(json);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }



    @Override
    public List<Node> readTree(String fileName) {
        try(FileReader reader = new FileReader(fileName))
        {
            JsonNode jsonNodeParser = mapper.readTree(reader);
            List<Node> list = new ArrayList<>();
            for (JsonNode jsonNode1 : jsonNodeParser){
                Node node = mapper.readValue(jsonNode1, Node.class);
                list.add(node);
                System.out.println(node.getName());
            }
            return list;

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
