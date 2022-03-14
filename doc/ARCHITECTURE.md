# ARCHITECTURE

## What is this?
This document describes high-level architecture of FundFlow crowdfunding platform.

**Goals and Limitations**
  - **Basic functional requirements**
    - User registration
    - Authorization
    - Become a backer
    - Become a founder
    - create a new project
    - editing design information
    - set the name of the project
    - search by project name
    - sort projects by category
    - view popular projects
    - view my investments
    - invest
    - link the wallet to the project
  - **Basic non-functional requirements**
    - The web application and the server must respond quickly to user actions.
    - The web application must ensure the protection of user data and their wallets.
  - **Architectural goals**
    - Ability to easily expand the list of project attributes.
    - Ability to see changes in projects in real time
    - Implement RESTful microservice architecture 

## What we use.
For backend we use Java + Spring <br />
https://spring.io/ <br />
For the frontend we use JavaScript + React. <br />
https://reactjs.org/ <br />
https://github.com/facebook/react/ <br />

## Modules
Here we briefly talk about our programming modules, simply - our architecture.

* #### back-app/
This is out back-end module. It's written on Go language and contains realizations of our server, user authorization. To be completed.

* #### register-form-v2/
Our frontend module. Contains almost all needed stuff for our site. To be completed.
