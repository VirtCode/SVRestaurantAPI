package ch.virt.svrestaurant.test;

import ch.virt.svrestaurant.api.Restaurant;
import ch.virt.svrestaurant.api.menu.Menu;
import ch.virt.svrestaurant.api.menu.MenuDay;

import java.io.IOException;

/**
 * @author VirtCode
 * @version 1.0
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        Restaurant restaurant = new Restaurant("");
        restaurant.fetchData();
        restaurant.fetchMenues();
        System.out.println(restaurant.getName());
        for (MenuDay arg : restaurant.getMenuWeek().getDays()) {
            System.out.println(arg.getDate());
            for (Menu menue : arg.getMenues()) {
                System.out.println(menue);
            }
        }
    }
}
