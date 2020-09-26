package ch.virt.svrestaurant.api;

import ch.virt.svrestaurant.api.menu.MenuWeek;
import ch.virt.svrestaurant.api.properties.RestaurantProperties;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Represents a sv restaurant
 * @author VirtCode
 * @version 1.0
 */
public class Restaurant {

    UrlManager urls;

    private String name;

    private MenuWeek week;
    private RestaurantProperties properties;

    /**
     * Creates a restaurant
     * @param subdomain subdomain of the restaurant (before the .sv-restaurant.ch) without the https stuff
     */
    public Restaurant(String subdomain, UrlManager.Lang language){
        urls = new UrlManager(language, subdomain);
    }
    public Restaurant(String subdomain, UrlManager.Lang language, String subplan){
        urls = new UrlManager(language, subdomain, subplan);
    }

    /**
     * Scrapes the menu information from the website
     * @throws IOException exception when no internet connection
     */
    public void fetchMenus() throws IOException {
        Document doc = Jsoup.connect(urls.composeMenuPlan()).get();
        week = new MenuWeek(doc.getElementsByClass("menu-plan-wrap").get(0));
    }

    /**
     * Scrapes the restaurant information from the website
     * @throws IOException exception when no internet connection
     */
    public void fetchData() throws IOException {
        Document doc = Jsoup.connect(urls.composeAbout()).get();
        name = doc.title().substring("Uber uns - ".length());
        properties = new RestaurantProperties(doc.getElementsByClass("l-content").get(0));
    }

    /**
     * Returns the subdomain of the restaurant
     * @return subdomain of the restaurant
     */
    public String getSubdomain() {
        return urls.getSubdomain();
    }

    /**
     * Returns the name of the restaurant
     * (depends on fetchData)
     * @return name of the restaurant
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the week with the menus
     * (depends on fetchMenus)
     * @return week with the menus
     */
    public MenuWeek getMenuWeek() {
        return week;
    }

    /**
     * Returns the properties of the restaurant
     * (depends on fetchData)
     * @return properties of the restaurant
     */
    public RestaurantProperties getProperties() {
        return properties;
    }
}
