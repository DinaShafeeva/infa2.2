package momento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Site {
    private String name;
    private List<Site> links;
    private Map<Integer, Position> positions;

    public String getName() {
        return name;
    }

    public List<Site> getLinks() {
        return links;
    }

    public Map<Integer, Position> getPositions() {
        return positions;
    }

    public Site(String name, List<Site> links, Map<Integer, Position> positions) {
        this.name = name;
        this.links = links;
        this.positions = positions;
    }

    public Site(String name) {
        this(name, new ArrayList<>(), new HashMap<>());
    }
}
