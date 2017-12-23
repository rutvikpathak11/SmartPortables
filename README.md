# SmartPortables
Store Manager can login to website with below credentials:
userid : admin
password : admin

A customer can register on the website and then login, if not below are the credentials for customer login:
userid : meet
password : meet

Before running the application, CLASSPATH variable should be set with MySQL jar for database connection.

Copy all above files in a folder named 'SmartPortables' and copy the SmartPortables folder store in 'C:\apache-tomcat-7.0.34\webapps' in your system.

All the servlets are stored in WEB-INF folder and they can be compiled together with 'javac *.java' command in the command prompt.

'Home' is the first servlet to start the application and move forward. After compiling the servlets, application can be run from 'http://localhost/SmartPortables/Home' in browser.

'Assignment5BestBuyDeals.ipynb' file will create DealMatches.txt, which contains the tweets from the twitter under the screen name BestBuy_Deals which matches with the products available in the MySQL dataase and shows only those products' tweets.

When the SmartPortables application is started by TOMCAT server, it will read any 2 tweets from the DealMatches.txt file and will show them on the Home page of the application.

A customer can login to the website and check deals on the Home page and later buy it.
