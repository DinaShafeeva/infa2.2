package momento;

public class TextAdvertisement implements Position {
    private Site site;

    @Override
    public void goToAdv(Browser browser) {
        browser.link(site);
    }

    @Override
    public void show(Browser browser) {
    }

    public TextAdvertisement(Site site) {
        this.site = site;
    }
}
