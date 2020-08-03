# Starbux Coffee - Backend API
This repository contains backend api for our online coffee place eCommerce startup. 

 1.This solution allows users to order drinks with toppings and verify cart details like total amount, discount etc. 
 
 2.This solution also provides api to admin to create/update/delete drinks/toppings and verify different reports related to User and Products.
 
# Prerequisites
Kindly ensure you have the following installed on your machine:

       1. Java 8

       2. Maven 3.5
 
       3. Docker
 
# Running the Application

1. Clone the repository

       git clone https://github.com/rahulkuma26/starbux-backend-api.git
  
2. Check into the cloned repository

       cd starbux-backend-api/
   
3. Run the application by executing setup.sh

       ./setup.sh
   
   Please allow for 10-15 mintues till your application is up and running as setup.sh contains two commands :
     1. Docker build command to build docker image from Dockerfile which will install Maven,copy the source code,build the application and extract the final jar.
     2. Run Integration and Unit test cases
     3. Run the docker image on port 8080
     
4. After complete setup your Application is running and you can access it using:

       http://localhost:8080/
       
5.  API Documentaion can be found here:

     http://localhost:8080/
     
6.  If you don't have docker setup in your local machine then please execute these Steps and skip step 3

          mvn compile
     
          mvn package
       
          java -jar target/api-0.0.1-SNAPSHOT.jar
          
          
# Endpoints:

This application provides 8 end points. Please refer to API Documentation for complete details.
 1.  To fetch all products details:
            /products
 2.  To fetch one particular product details:
            /product/{id}
 3.  To delete one existing product
            /product/{id}
 4.  To Update one existing product
            /product/{id}
 5.  To create one new product
           /product
          
 6. To Create new order and Update exsiting order 
            /order
          
 7. To fetch user related reports
            /report/user
 8. To fetch topping related reports
           /report/topping
 
