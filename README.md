# SVRestaurantAPI
## About
This API provides its user with the information about an sv-restaurant and with its menuplan, that is scraped from their website.
## Version
The current version is **1.0**
## License
This project is licensed under the MIT License. Please consider reading the LICENSE file for more information.
## Features
* Get the Menuplan
    * All Menues
    * All Days
* Get the Info about the Restaurant
    * Name
    * Properties
    * Information about the Manager
## Usage
### Getting the JAR
To get the latest version of the library, download the latest release in the release section.
### In Code
First you need to get your subdomain of your target restaurant. You can get yours by looking it up in the domain to your men plan.<br>
```https://[subdomain].sv-restaurant.ch/```<br>
Now you can create your Restaurant:
```java
Restaurant restaurant = new Restaurant("[your-subdomain]");
```
After that you can start scraping the data:
```java
restaurant.fetchData(); //scrapes the information about the restaurant
restaurant.fetchMenues(); //scrapes the menuplan from the restaurant
```
Now you can access this data:
```java
restaurant.getName(); //Get the name of the restaurant
restaurant.getMenuWeek(); //Returns all the data about the meunues currently online
restaurant.getProperties(); //Returns all the additional information about the restaurant the api can scrape
```
From now on, it should be really self explanatory how to get the induvidual pieces of information out of it. But if you still don't get it, you can have a look at the javadoc.