# TrademeAPI:-
This repository contains the test automation code to test the TradeMe Sandbox API. 

## About Project:-
TradeMe Sandbox API Tests:

Using the TradeMe Sandbox environment API, the project does following:
1. Retrieves a list of charities and confirm that description contains a specific value.
2. Creates a new listing with relevant details in the given category and confirms the listing was created successfully. 

Documentation for the TradeMe sandbox API is here: https://developer.trademe.co.nz/api-reference

Project was built using RestAssured library and using BDD framework.

## Tools used:-
	1.IntelliJ Commnuity Edition 2021.3.3
	2.Cucumber 7.2.3
	3.JDK 18
	4.Apache Maven 3.8.5
	5.RestAssured 4.4.0

## Installation
Clone the repo:
**https://github.com/vipinmisra/TrademeApi.git**

## Instructions:-

Open a command-prompt:- 
Navigate to project directory where you would find src, pom.xml etc.

Run the below  execution command:-

**mvn clean test**

## Test Results:-
Execution reports are generated under ./target directory under project root directory.
