package ch.virt.svrestaurant.api;

/**
 * This class composes URLs for the Various SV restaurants
 * @author VirtCode
 * @version 1.0
 */
public class UrlManager {

    public static final String MAIN_PREFIX = "https://";
    public static final String MAIN_URL = ".sv-restaurant.ch";

    public static final String DE_LANG = "/de";
    public static final String DE_MENU_PLAN = "/menuplan";
    public static final String DE_ABOUT = "/ueber-uns";

    public static final String EN_LANG = "/en";
    public static final String EN_MENU_PLAN = "/menu";
    public static final String EN_ABOUT = "/about-us";

    /**
     * Enum, to hold supported Languages
     */
    public enum Lang {
        ENGLISH,
        GERMAN
    }

    private Lang language;
    private String subdomain;

    private String subplan = "";

    /**
     * Creates an UrlManager
     * @param language language of the website
     * @param subdomain subdomain of the website
     */
    public UrlManager(Lang language, String subdomain) {
        this.language = language;
        this.subdomain = subdomain;
    }

    /**
     * Creates an UrlManager
     * @param language language of the website
     * @param subdomain subdomain of the website
     * @param subplan submenuplan of the website
     */
    public UrlManager(Lang language, String subdomain, String subplan) {
        this.language = language;
        this.subdomain = subdomain;
        this.subplan = "/" + subplan;
    }

    /**
     * Creates the MenuPlan url
     * @return String webpage
     */
    public String composeMenuPlan(){
        switch (language){
            case GERMAN:
                return MAIN_PREFIX + subdomain + MAIN_URL + DE_LANG + DE_MENU_PLAN + subplan;

            case ENGLISH:
                return MAIN_PREFIX + subdomain + MAIN_URL + EN_LANG + EN_MENU_PLAN + subplan;
        }

        return null;
    }

    /**
     * Creates the AboutPage url
     * @return String about webpage
     */
    public String composeAbout(){
        switch (language){
            case GERMAN:
                return MAIN_PREFIX + subdomain + MAIN_URL + DE_LANG + DE_ABOUT;

            case ENGLISH:
                return MAIN_PREFIX + subdomain + MAIN_URL + EN_LANG + EN_ABOUT;
        }

        return null;
    }

    /**
     * Returns the language of the manager
     * @return language
     */
    public Lang getLanguage() {
        return language;
    }

    /**
     * Returns the subdomain of the manager
     * @return subdomain
     */
    public String getSubdomain() {
        return subdomain;
    }
}
