## NewsParser
In this project, I have used spring-boot to develop a microservice application.

### Service: NewsScrapper
This service scraps the EconomicTimes website for fetching the latest news.<br/>
This service runs every minute to find for any latest available on the website.<br/>
URL: https://economictimes.indiatimes.com/news/latest-news

### Controller: NewsController
This controller routes the latest news scrapped by the service to the view(HTML) using thymleaf.

### Home Page View
![Home PageView](https://github.com/adsk261095/NewsParser/blob/master/Images/page_view.PNG)
