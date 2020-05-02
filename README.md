# Project Name
[Wildlife-Survey-App](https://github.com/linusmbae/Wildlife-Survey-App.git)
# Author Name
Mbae Linus Mutugi
# Project Description
Project Wildlife-Survey-App will be used to calculate the number of animals in a forest.

# Project Setup
### Database Setup
Click this [link](https://www.postgresql.org/download/) to install postgreSQL if you don't have one.

for ubuntu users use the following in the terminal:

> sudo apt-get update

> sudo apt-get install postgresql postgresql-contrib libpq-dev

launch the postgreSQl using:

> psql

 ##### creating database
> CREATE DATABASE wildlife_tracker;

> CREATE TABLE animals (id serial PRIMARY KEY, name VARCHAR,type VARCHAR, gender VARCHAR, age VARCHAR, health VARCHAR);

 > CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

### cloning project

Click on the Hero Squad [Link](https://github.com/linusmbae/Wildlife-Survey-App.git) and fork Hero Squad repository to your github.

Copy the clone link.

Navigate through your local storage to your favourite directory using terminal.

Clone the App to your local storage and launch it.
 
 ## Live Link
 [Live Link]()
 
## Reach me
[Email](linusmutugi5178@gmail.com) 

# CopyRight & License
MIT License

Hero Squad

Copyright (c) [2020] [Linus Mutugi Mbae]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
