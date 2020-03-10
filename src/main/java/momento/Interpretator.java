package momento;

public class Interpretator {
    Browser browser;

    public String checkStatement(String string){
        if (string.startsWith("goto")){
            return goTo(string);
        } else if (string.startsWith("link")){
            return link(string);
        } else if (string.startsWith("back")){
            return back(string);
        } else if (string.startsWith("forward")){
            return forward(string);
        }

        return string;
    }

    private String goTo(String string){
        browser.goTo(string);
        return browser.getCurrentSite().getName();
    }

    private String link(String string){
        Site site = browser.getCurrentSite().getLinks().stream()
                .filter(p -> p.getName().equals(string.substring(0, string.indexOf(' '))))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There are not such sites"));

        browser.link(site);
        return browser.getCurrentSite().getName();
    }

    private String back(String string){
        browser.back();
        return browser.getCurrentSite().getName();
    }

    private String forward(String string){
        browser.forward();
        return browser.getCurrentSite().getName();
    }
}
