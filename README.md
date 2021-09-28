# Fakturogen
 REST application that will allow our users to automatically generate recurring every month invoices. 

## Table of contents
* [Introduction](#Introduction)
* [Technologies](#Technologies)
* [Scope of functionalities](#Scope of functionalities)
* [Project status](#Project status)
* [Inspiration](#Inspiration)
* [Contact us!](#Contact us!)

## Introductionry
This repository contains a multi-module open source project. Our app is being crated in order to consolidate and
 develop our knowledge that we have gained during java programing course. It is also written as a response to 
 the market demand for a FV automation app. This is a REST application that uses endpoints of other programs
  dedicated to issuing sales documents. Our program logs into external app, downloads and analyses data in order 
  to propose to our users new documents that also can become an invoice template. Users will be able to edit and 
  choose which sales documents they want to send to external api. Just with one click they will be able to 
  generate FV for all chosen templates. 

## Technologies
* Java - version 11
* Spring Boot - 2.4.1 Release
* Spring Security
* Hibernate
* Lombok
* slf4j - version 1.7.30
* Jacskon - version 2.12.1

## Scope of functionalities
Features:
* User registration
* User login
* Downloading data from external api and saving it in our database
* Displaying new invoice templates proposals
* Displaying the list of invoice templates that have been issued within the last 3 months
* Sending user-selected templates to external api for creating FV
* Archiving templates option

To-do list:
* Connection to other external programs for invoices
* Creation of graphical user interface

## Project status
Project is: _in progress_

## Inspiration
Inspiration for creating this repository was work of one of our team members who was loosing a lot of time
every month to create recurring invoices. This project gave us not only the opportunity to introduce improvements 
and automation to theis process, but also allowed us to broaden our knowledge and to experience working in a 
development team.  

## Contact us!
* [@KrzKos](krzysztof.kostkiewicz@gmail.com)
* [@ewa-git](ewa.gitit@gmail.com)
* [@rowinskidamian](damian.rowinski@gmail.com)

