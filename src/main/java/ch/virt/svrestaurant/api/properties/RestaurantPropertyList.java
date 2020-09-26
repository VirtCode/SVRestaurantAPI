package ch.virt.svrestaurant.api.properties;

import org.jsoup.nodes.Element;

import java.util.ArrayList;

/**
 * This class holds a Property Container
 * @author VirtCode
 * @version 1.0
 */
public class RestaurantPropertyList {

    String title;
    String[] points;

    /**
     * Creates a Restaurant Property List
     * @param property element to read from
     */
    public RestaurantPropertyList(Element property){
        points = loadList(property.getElementsByClass("collapsible-container").get(0));
        title = property.getElementsByClass("label").get(0).text();
    }

    /**
     * Loads a collapsible container from the site
     * @param element element to load
     * @return properties of the element
     */
    private String[] loadList(Element element){
        org.jsoup.nodes.Element div = element.getElementsByClass("text").get(1);
        org.jsoup.nodes.Element list = div.getAllElements().get(1);
        ArrayList<String> properties = new ArrayList<>();
        int index = 0;
        for (org.jsoup.nodes.Element allElement : list.getAllElements()) {
            if(index != 0 && !allElement.toString().equals("<br>")) properties.add(allElement.text());
            index++;
        }
        return properties.toArray(new String[0]);
    }

    /**
     * Returns the title of that container
     * @return String title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns all Entries of that container
     * @return array entries / points
     */
    public String[] getPoints() {
        return points;
    }
}
