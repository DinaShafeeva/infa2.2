package momento;

public class VideoAdvertisement implements Position {
    private Site site;

    public VideoAdvertisement(Site site) {
        this.site = site;
    }

    @Override
    public void goToAdv(Browser browser) {
        browser.link(site);
    }

    @Override
    public void show(Browser browser) {
        this.goToAdv(browser);
    }
}
