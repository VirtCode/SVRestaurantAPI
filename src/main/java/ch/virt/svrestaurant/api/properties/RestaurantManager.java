package ch.virt.svrestaurant.api.properties;

import org.jsoup.nodes.Element;

/**
 * This class represents the scraped data from the restaurant manager
 * @author VirtCode
 * @version 1.0
 */
public class RestaurantManager {

    private String rank;
    private String name;
    private String email;

    /**
     * Scrapes the contact info from the website
     * @param contactbox box with the info
     */
    public RestaurantManager(Element contactbox) {
        rank = contactbox.getAllElements().get(1).text();
        Element info = contactbox.getElementsByClass("contact-info").get(0);
        name = info.getAllElements().get(1).text();
        if (info.getAllElements().size() >= 2){
            email = info.getAllElements().get(2).getAllElements().get(0).text();
        }
    }

    /**
     * Returns the rank of the manager
     * @return rank of the manager
     */
    public String getRank() {
        return rank;
    }

    /**
     * Returns the name of the manager
     * @return name of the manager
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email of the manager if provided
     * @return email of the manager if provided
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "RestaurantManager{" +
                "rank='" + rank + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
