package ch.virt.svrestaurant.api.menu;

import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a menu provided by a svrestaurant
 * @author VirtCode
 * @version 1.0
 */
public class Menu {
    private String title;
    private String ingredients;
    private HashMap<String, Float> prices;
    private String additionalInfo;
    private boolean vegetarian;

    /**
     * Scrapes the info of the menu item
     * @param menuItem dom element to scrap from
     */
    public Menu(Element menuItem){
        prices = new HashMap<>();
        this.title = menuItem.getElementsByClass("menu-title").get(0).text();
        this.ingredients = menuItem.getElementsByClass("menu-description").get(0).text();
        for (Element price : menuItem.getElementsByClass("price")) {
            prices.put(price.getElementsByClass("desc").get(0).text(), Float.parseFloat(price.getElementsByClass("val").get(0).text()));
        }
        this.additionalInfo = menuItem.getElementsByClass("menu-provenance").get(0).text();
        vegetarian = menuItem.getElementsByClass("label-vegetarian").size() > 0;
    }

    /**
     * Returns the title of the menu
     * @return title of the menu
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the ingredients of the menu (aka description)
     * @return ingredients of the menu (aka description)
     */
    public String getIngredients() {
        return ingredients;
    }

    /**
     * Returns the prices of the menu
     * @return prices of the menu
     */
    public HashMap<String, Float> getPrices() {
        return prices;
    }

    /**
     * Returns the additional info of the menu
     * @return additional info of the menu
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Returns whether the is vegetarian
     * @return is vegetarian
     */
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", prices=" + prices +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", vegetarian=" + vegetarian +
                '}';
    }
}
