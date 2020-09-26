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

    private RestaurantPropertyList[] propertyCategories;

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

        Elements properties = element.getElementsByClass("collapsible");
        ArrayList<RestaurantPropertyList> propertyLists = new ArrayList<>();
        for (Element property : properties) {
            propertyLists.add(new RestaurantPropertyList(property));
        }

        propertyCategories = propertyLists.toArray(new RestaurantPropertyList[0]);
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
     * Returns a list of all property containers found
     * @return property containers
     */
    public RestaurantPropertyList[] getPropertyCategories() {
        return propertyCategories;
    }

    /**
     * Returns all the infos about the person that manages the restaurant
     * @return infos about the person that manages the restaurant
     */
    public RestaurantManager getRestaurantManager() {
        return restaurantManager;
    }
}
