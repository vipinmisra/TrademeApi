# TrademeAPI:-
This repository contains the test automation code to test the TradeMe API Test. 

## About Project:-
Part1:TradeMe API Test

Using the TradeMe Sandbox environment API, the code does following:
1. Retrieve a list of charities and confirm that "St John" is included in the list.
2. Create a new listing with any relevant details in the category 0002-0356-0032-2273- and confirm the listing was created successfully. 
3. Confirm that above values always match with input test data

Documentation for the TradeMe sandbox API is here: https://developer.trademe.co.nz/api-reference

Project built with restassured BDD framework.

## Tools used:-
	1.IntelliJ Commnuity Edition
	2.Cucumber
	3.JDK 18
	4.Apache Maven 3.8.5

## Installation
Clone the repo:
**https://github.com/vipinmisra/TrademeApi.git**

## Instructions:-

Open a command-prompt:- 
Navigate to project directory where you would find src , pom.xml etc.

Run the below  execution command:-

**mvn clean test**

## Test Results:-
Execution reports are generated under ./target directory under project root directory.
