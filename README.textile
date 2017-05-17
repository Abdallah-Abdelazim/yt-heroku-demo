1. Download Heroku CLI: https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
2. Commands:
>>	heroku login
>>	git init
>>	git add .
>>	git commit -m "First Commit"
>>	heroku create <app-name>
>>	git push heroku master
>>	heroku open

------> Now the website should work if you do not have any databases in it
------> To Enably MySQL Database: (This adds Postgres database addon)
>>	heroku addons:create heroku-postgresql

Add this dependency in maven pom file (used for Postgres database addon that will enable our database to work):

<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>9.4-1201-jdbc4</version>
</dependency>

------------------------------------------------------------------------------
Then edit the connection attributes in application.properties file to contain:

spring.datasource.url=${JDBC_DATABASE_URL}
spring.datasource.username=${JDBC_DATABASE_USERNAME}
spring.datasource.password=${JDBC_DATABASE_PASSWORD}
spring.jpa.show-sql=false
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create

*** Important note: 
It's important that at first time you leave this last line and set it "create" so that your database gets created. 
After that change it to "update" and commit and push once more. (i.e. git add . && git commit -m "application.properties edited" && git push heroku master)

______________________________________________________________________
This tutorial is based on the following two articles (and other):
https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
