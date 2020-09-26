package ch.virt.svrestaurant.api.menu;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a single day with its provided menus
 * @author VirtCode
 * @version 1.0
 */
public class MenuDay {

    private Date date;
    private Menu[] menus;

    /**
     * Scrapes all the menu items from the day
     * @param date date of menu
     * @param element dom element to scrape
     */
    public MenuDay(Date date, Element element){
        ArrayList<Menu> items = new ArrayList<>();
        for (Element item : element.getElementsByClass("menu-item")) {
            items.add(new Menu(item));
        }
        this.date = date;
        this .menus = items.toArray(new Menu[0]);
    }

    /**
     * Returns the date of the day
     * @return date of the day
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the menus at the day
     * @return menus at the day
     */
    public Menu[] getMenus(){
        return menus;
    }


}
