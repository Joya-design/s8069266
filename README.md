# s8069266

# NIT3213 Android Application Project

## Overview
This project is an Android application that demonstrates API integration, user interface design, and Android development best practices.
 
The app has three main screens: 
Login, Dashboard, and Details. It interacts with the 'vu-nit3213-api' to authenticate users and retrieve data, and it showcases the use of Dependency Injection and unit testing.

## Features
- Login Screen: Allows users to authenticate with their first name and student ID. Upon successful login, users are navigated to the Dashboard screen.
- Dashboard Screen: Displays a list of entities retrieved from the API using `RecyclerView`. Each item can be clicked to view more details.
- Details Screen: Provides a detailed view of a selected entity from the Dashboard, showing all related information, including a description.

## API Details
- Base URL: `https://nit3213-api-h2b3-latest.onrender.com`
- Login Endpoint: `/footscray/auth`, `/sydney/auth`, or `/ort/auth`
  - Method: POST
  - Request Body:
    ```json
    {
      "username": "YourFirstName",
      "password": "sYourStudentID"
    }
    ```
  - Successful Response:
    ```json
    {
      "keypass": "topicName"
    }
    ```

- Dashboard Endpoint: `/dashboard/{keypass}`
  - Method: GET
  - Successful Response:
    ```json
    {
      "entities": [
        {
          "property1": "value1",
          "property2": "value2",
          "description": "Detailed description"
        }
      ],
      "entityTotal": 7
    }
    ```

## Project Structure
- LoginActivity: Handles user login and authentication.
- DashboardActivity: Displays a list of entities using a `RecyclerView`.
- DetailsActivity: Shows detailed information about a selected entity.
- View Models: Handles data fetching and UI logic using MVVM architecture.
- Dependency Injection: Uses Hilt for injecting dependencies.
- Unit Tests: Tests critical components such as View Models.

## Technical Requirements
- Dependency Injection: Hilt is used for injecting dependencies and managing application scope.
- Recycler View: Displays the list of entities on the Dashboard screen.
- Unit Testing: Unit tests for View Models are included using JUnit.
- Clean Code: The project follows clean architecture principles with separation of concerns.
- Git: Meaningful commit messages and a well-documented commit history are maintained.

## Installation and Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Joya-design/Nit3213(final).git
