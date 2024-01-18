# Flow Work Earth - project phase 2.

This solution was created during Flow Academy's (https://flowacademy.hu/) Junior Java Developer course. The task was to build a school registration system in java. The UI was the Linux Terminal.

# Table of contents

- [Overview](#overview)
  - [Requirements](#requirements)
- [My process](#my-process)
  - [Built with Java](#built-with)
  - [What I learned](#what-i-learned)
  - [Continued development](#continued-development)
- [Author](#author)
- [Acknowledgments](#acknowledgments)

## Overview

### Requirements - given by Flow Academy

Flow Work Earth - project phase 2.
School System
Your task is to build a school registration system.
Recommended classes: Name, Subject, Grade, Student, Teacher, ClassDiary

1. create queryable data in a JSON file
2. when starting the program, decide what we want to do
a) entering a grade in the diary
b) student search/query (displayed on the console)
i. basic info query
ii. grade point average (can also be requested broken down by subject)
c) class search/query (displayed on console)
i. basic info query
ii. grade point average (can also be requested broken down by subject)
3. admission of new students, recording of data
4. Absences can be recorded, this should also be entered in the diary with the student's name and reason
5. (optional) expand the relationship between teachers and subjects, it can be 1-to-many relationship (one
a teacher can belong to several subjects and vice versa)
In addition to these, you can create extended functionalities as you like!

Deadline and the date of the project presentation: **2023-11-29 17:00**

### Main feaures of the finished project

- CRUD operations in the meaning of a school system: creating/modifying/deleting/archiving users
- different menus due to login based on the user's type: student, teacher, admin
- teachers can registrate student class diaries (absent students and the reason of absence)
- teachers can registrate marks to different subjects (available actually 10 different subject defined as enums)
- all data - marks, absenses - is available for students or classes too
- possible to treat classes and students as archived: in this case their data are save to different json-files and handled by this way in the future


## My process

### Built with Java

- OOP
- Streams
- IO
- Exception handling
- Collections (Map, List)
- JSON serialization-deserialization

### What I learned

In this project phase one of the most important skills was to order the different features by importance, because there was only 2 weeks for it. It was also beneficial for practicing time management as well. The solid fundementals of using JSON-s was one of the biggest technical challenge due to the numerous classes. After the first project phase (where I made a minesweeper application with 2 of my classmates together) this time I put the emphasize on to create clean code too.


### Continued development

The application was made during the course, where the used language was hungarian, for this reason I wanted to modify the program to be used as a bilingual application: therefore I have to translate its menus and add a langauge choice option. It would be also very useful the develop and design the application's UI to be able to used from a web-environment.


## Author

- LinkedIn - [Balázs Máté](https://www.linkedin.com/in/bal%C3%A1zs-m%C3%A1t%C3%A9-946021219/)
- GitHub - [@balamat](https://github.com/balamat)


## Acknowledgments

I want to thank all the mentors for giving tips and good advices about how to build up this system during the consultation occasions.

