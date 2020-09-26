# SVRestaurantAPI
## About
This API provides its user with the information about a sv-restaurant and with its menuplan, that is scraped from their website.
### Disclaimer
This project is in no way associated with the SV-Group nor is it official in any point.
## Version
The current version is **1.1.1**
## Features
* Get the Menuplan
    * All Menus
    * All Days
* Get the Info about the Restaurant
    * Name
    * Properties
    * Information about the Manager
## Usage
### Getting the Library
To get the latest version of the library, you could add the dependency to your build.gradle file via jitpack.
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compile 'com.github.VirtCode:SVRestaurantAPI:[Version]'
}
```
Or you could download a built Jar in the release section.
### In Code
First you need to get your subdomain of your target restaurant. You can get yours by looking it up in the domain to your menuplan.<br>
```https://[subdomain].sv-restaurant.ch/```<br>
Second, you should also provide the language the website is written in. To do that, you can have a look at the url of the menuplan.<br>
```...sv-restaurant.ch/[lang]...``` ("en" is English, "de" is German)<br>
Optionally, you could provide the submenuplan name for your restaurant. That is also found in the url of the menuplan. If you don't have one, just ignore that parameter. If you ignore it, it just refers to the first submenuplan.<br>
```...sv-restaurant.ch/en/menu/[submenuplan]``` or ```...sv-restaurant.ch/de/menuplan/[submenuplan]```<br>
Now you can create your Restaurant:
```java
Restaurant restaurant = new Restaurant("[your-subdomain]", [UrlManager.Lang.ENGLISH or UrlManager.Lang.GERMAN], Optional: "[your-submenuplan]");
```
After that you can start scraping the data:
```java
restaurant.fetchData(); //scrapes the information about the restaurant
restaurant.fetchMenus(); //scrapes the menuplan from the restaurant
```
Now you can access this data:
```java
restaurant.getName(); //Get the name of the restaurant
restaurant.getMenuWeek(); //Returns all the data about the meunues currently online
restaurant.getProperties(); //Returns all the additional information about the restaurant the api can scrape
```
From now on, it should be really self-explanatory how to get the individual pieces of information out of it. Additionally, you could still refer to the javadoc.
## License
This project is licensed under the MIT License. Please consider reading the LICENSE file for more information.