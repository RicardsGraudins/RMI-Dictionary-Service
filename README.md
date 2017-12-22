# RMI Dictionary Service
This repository contains code and information for my fourth-year (hons) undergraduate project for the module **Distributed Systems.**
The module is taught to undergraduate students at [GMIT](http://www.gmit.ie/) in the Department of Computer Science and Applied Physics for the course [B.S.c. (Hons) in Software Developement.](https://www.gmit.ie/software-development/bachelor-science-honours-software-development)
The lecturer is Patrick Mannion.

## Project Guidelines
> You are required to use the Servlet/JSP and Java RMI frameworks to develop a remote, asynchronous dictionary lookup service. A JSP page should provide users with the ability to specify a string which will be checked against the dictionary. The HTML form information should be dispatched to a servlet that adds the client request to an in-queue and then returns a job ID to the web client. The web client should poll the web server periodically (every 10 seconds) and query if the request has been processed. Client requests in the inQueue should be periodically removed and processed (every 10 seconds).
 
> The processing of a client request will require a RMI method invocation to a remote object which implements an interface called DictionaryService. The remote object which implements DictionaryService should check if the string received exists in the dictionary, and return the dictionary definition of the string if it does exist in the dictionary, or “String not found” if it does not exist in the dictionary. Once the result of the dictionary lookup has been computed by the remote object, the returned response should be added to the outQueue on the Tomcat server and returned to the original web client when they next poll the server. The following diagram depicts the overall system architecture: 

<p align="center">
  <img width="693" height="360" src="https://github.com/RicardsGraudins/RMI-Dictionary-Service/blob/master/Resources/Design.PNG">
</p>

## What is RMI:
RMI stands for Remote Method Invocation. It is a mechanism that allows an object residing in one system (JVM) to access/invoke an object running on another JVM. RMI is used to build distributed applications; it provides remote communication between Java programs. It is provided in the package java.rmi.

<p align="center">
  <img width="698" height="397" src="https://github.com/RicardsGraudins/RMI-Dictionary-Service/blob/master/Resources/RMI.png">
</p>

## What is Tomcat:
Apache Tomcat, often referred to as Tomcat Server, is an open-source Java Servlet Container developed by the Apache Software Foundation (ASF). Tomcat implements several Java EE specifications including Java Servlet, JavaServer Pages (JSP), Java EL, and WebSocket, and provides a "pure Java" HTTP web server environment in which Java code can run.

## What is a Servlet:
Servlets provide a component-based, platform-independent method for building Webbased applications, without the performance limitations of CGI programs. Servlets have access to the entire family of Java APIs, including the JDBC API to access enterprise databases.

## What is JSP:
Java Server Pages (JSP) is a server-side programming technology used to create web application just like Servlet technology. It can be thought of as an extension to servlet because it provides more functionality than servlet such as expression language, jstl etc.
A JSP page consists of HTML tags and JSP tags. The jsp pages are easier to maintain than servlet because we can separate designing and development. It provides some additional features such as Expression Language, Custom Tag etc.

## How to run:

## References:
* [Remote Method Invocation](https://www.tutorialspoint.com/java_rmi/index.htm)
* [Apache Tomcat](http://tomcat.apache.org/)
* [Servlets](https://www.tutorialspoint.com/servlets/)
* [JavaServer Pages](https://www.tutorialspoint.com/jsp/)
