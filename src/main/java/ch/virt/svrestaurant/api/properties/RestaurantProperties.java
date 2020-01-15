package ch.virt.svrestaurant.api.properties;

import ch.virt.svrestaurant.api.properties.RestaurantManager;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * This class scrapes the about properties from the website
 * @author VirtCode
 * @version 1.0
 */
public class RestaurantProperties {

    private String[] indoorProperties;
    private String[] outdoorProperties;
    private String teaserText;
    private RestaurantManager restaurantManager;

    /**
     * Scrapes the properties of the restaurant from the about site element
     * @param element element to scrape
     */
    public RestaurantProperties(Element element){
        restaurantManager = new RestaurantManager(element.getElementsByClass("contactbox").get(0));

        Element teaser = element.getElementsByClass("text").get(0);
        if (teaser != null){
            StringBuilder stringBuilder = new StringBuilder();
            for (Element allElement : teaser.getAllElements()) {
                stringBuilder.append(allElement.text());
                stringBuilder.append("\n");
            }
            teaserText = stringBuilder.toString();
        }

        Elements properties = element.getElementsByClass("collapsible-container");
        if (properties.size() >= 1){
            indoorProperties = loadList(properties.get(0));
            if (properties.size() >= 2) outdoorProperties = loadList(properties.get(1));

        }
    }

    /**
     * Loads a collapsible container from the site
     * @param element element to load
     * @return properties of the element
     */
    private String[] loadList(Element element){
        Element div = element.getElementsByClass("text").get(1);
        Element list = div.getAllElements().get(1);
        ArrayList<String> properties = new ArrayList<>();
        int index = 0;
        for (Element allElement : list.getAllElements()) {
            if(index != 0 && !allElement.toString().equals("<br>")) properties.add(allElement.text());
            index++;
        }
        return properties.toArray(new String[0]);
    }

    /**
     * Returns the outdoor properties aka the second properties
     * (in most restaurants they are accessible and are the terasse properties)
     * @return outdoor properties aka the second properties
     */
    public String[] getIndoorProperties() {
        return indoorProperties;
    }

    /**
     * Returns the indoor properties aka the main properties
     * (for almost every restaurant accessible)
     * @return indoor properties aka the main properties
     */
    public String[] getOutdoorProperties() {
        return outdoorProperties;
    }

    /**
     * Returns the teaser text that describes the restaurant
     * (but it isn't on every project site)
     * @return teaser text that describes the restaurant
     */
    public String getTeaserText() {
        return teaserText;
    }

    /**
     * Returns all the infos about the person that manages the restaurant
     * @return infos about the person that manages the restaurant
     */
    public RestaurantManager getRestaurantManager() {
        return restaurantManager;
    }
}
