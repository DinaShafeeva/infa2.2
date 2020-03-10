package momento;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringData {
    private List<Entity> sites;

    public List<Entity> getPages() {
        return sites;
    }

    public void setPages(List<Entity> sites) {
        this.sites = sites;
    }

    public Set<Site> convertStringToSites() {
        Set<Site> converted = new HashSet<>();
        for (Entity site : sites) {
            converted.add(new Site(site.getName()));
        }
        for (Entity entity : sites) {
            Site site = converted.stream().filter(x -> x.getName().equals(entity.getName())).findFirst().get();
            for (String link : entity.getLinks()) {
                site.getLinks().add(converted.stream().filter(x -> x.getName().equals(link)).findFirst().get());
            }
            initPositions(new VideoFactory(), entity.getVideoAdv(), converted, site);
            initPositions(new TextFactory(), entity.getTextAdv(), converted, site);
        }
        return converted;
    }

    private void initPositions(Factory factory, List<Entity.RawPosition> list, Set<Site> pages, Site current) {
        for (Entity.RawPosition rawPosition : list) {
            Site adv = pages.stream().filter(x -> x.getName().equals(rawPosition.getAdv())).findFirst().get();
            Position position = factory.create(adv);
            current.getPositions().put(rawPosition.position, position);
        }
    }

    public static class Entity {
        private String       name;
        private List<String> links;
        private List<RawPosition> textAdv;
        private List<RawPosition> videoAdv;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getLinks() {
            return links;
        }

        public void setLinks(List<String> links) {
            this.links = links;
        }

        public List<RawPosition> getTextAdv() {
            return textAdv;
        }

        public void setTextAdv(List<RawPosition> textAdv) {
            this.textAdv = textAdv;
        }

        public List<RawPosition> getVideoAdv() {
            return videoAdv;
        }

        public void setVideoAdv(List<RawPosition> videoAdv) {
            this.videoAdv = videoAdv;
        }

        public static class RawPosition {
            private Integer position;
            private String  adv;

            public Integer getPosition() {
                return position;
            }

            public void setPosition(Integer position) {
                this.position = position;
            }

            public String getAdv() {
                return adv;
            }

            public void setAdv(String adv) {
                this.adv = adv;
            }
        }
    }
}
