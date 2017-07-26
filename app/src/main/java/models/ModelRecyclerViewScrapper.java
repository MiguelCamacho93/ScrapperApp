package models;

/**
 * Created by Miguel Camacho on 25/07/2017.
 */

public class ModelRecyclerViewScrapper {
    private String title;
    private String thumbnailUrl;
    private String link;
    private String text;

    public ModelRecyclerViewScrapper() {

    }

    public ModelRecyclerViewScrapper(String title, String thumbnailUrl, String link, String text) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.link = link;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
