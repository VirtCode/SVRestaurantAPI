package ch.virt.svrestaurant.api.menu;

import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * This class represents a week of menues on the website
 * @author VirtCode
 * @version 1.0
 */
public class MenuWeek {

    private MenuDay[] days;

    /**
     * Creates a week and scrapes it from the website
     * (it is not going to be parsed if there is something wrong with the website)
     * @param element Dom element
     */
    public MenuWeek(Element element) {
        Date[] dates = extractDates(element.getElementsByClass("no-bullets").get(0));
        Element[] days = element.getElementsByClass("menu-plan-grid").toArray(new Element[0]);

        if (dates.length == days.length){
            this.days = new MenuDay[dates.length];
            for (int i = 0; i < this.days.length; i++) {
                this.days[i] = new MenuDay(dates[i], days[i]);
            }
        }
    }

    /**
     * Extracts the Dates out of the website
     * @param bullets bullets where de dates are located
     * @return dates
     */
    private Date[] extractDates(Element bullets){
        ArrayList<Date> dates = new ArrayList<>();
        for (Element element : bullets.getElementsByClass("date")) {
            String[] args = element.text().split("\\.");
            if (args.length < 2) continue;

            int day = Integer.parseInt(args[0]);
            int month = Integer.parseInt(args[1]);
            int year;

            if (Calendar.getInstance().get(Calendar.MONTH) == Calendar.DECEMBER && month - 1 == Calendar.JANUARY) year = Calendar.getInstance().get(Calendar.YEAR) + 1;
            else year = Calendar.getInstance().get(Calendar.YEAR);



            dates.add(new Date(year, month - 1, day));
        }
        return dates.toArray(new Date[0]);
    }

    /**
     * Returns the day acording to the date given
     * @param date day of date
     * @param month month of date
     * @param year year of date
     * @return day with menu data
     */
    public MenuDay getDay(int date, int month, int year){
        for (MenuDay day : days) {
            Date d = day.getDate();
            if (d.getDate() == date && d.getMonth() == month && d.getYear() == year) return day;
        }
        return null;
    }

    /**
     * Returns all the days in the week
     * @return days in the week
     */
    public MenuDay[] getDays(){
        return days;
    }
}
