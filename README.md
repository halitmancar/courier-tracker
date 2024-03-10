# Courier Tracker

This project is a RESTful web application developed in Java, designed to process and log streaming geolocation data of couriers. It provides functionalities centered around tracking courier locations in relation to Migros store locations and calculating total travel distances.

## Prerequisites

Before you begin, ensure you meet the following requirements:

- **Java Development Kit (JDK)**: JDK 21 is required to run the application. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or use [OpenJDK](https://jdk.java.net/21/).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Cloning the Repository

To clone the Courier Tracker repository, open your terminal or command prompt and run the following command:

```sh
git clone https://github.com/halitmancar/courier-tracker.git
```

This command clones the repository to your local machine. Once cloning is complete, navigate to the project directory:

```sh
cd courier-tracker
```

### Running the Application

With JDK 21 installed and the repository cloned to your machine, you can run the application using the following command in the terminal from the project directory:

```sh
java -jar target/courier-tracker.jar
```

This command starts the Courier Tracker application. Once the application is running, you can utilize its features and explore its functionalities through the Swagger UI and access the database through the H2 console.

## Usage

### Swagger UI

The project includes a Swagger UI, which provides a web-based user interface for interacting with the API's endpoints, allowing you to execute API methods directly from the browser. To access the Swagger UI:

- Open a web browser and navigate to [http://localhost:8797/swagger-ui/index.html#/](http://localhost:8797/swagger-ui/index.html#/).

This interface provides detailed information about the API's endpoints, including request parameters, response objects, and the ability to try out the API directly from your browser.

### Application Endpoints

The application exposes a variety of endpoints, each serving a distinct purpose in the context of courier tracking and store proximity detection. Below is a detailed list of these endpoints and their functionalities:

- **Tracking Endpoint**
    - `/track`: Receives live geolocation data (time, courier ID, latitude, longitude) for couriers. This is the primary endpoint for logging courier movements in relation to store locations.

- **Simulation Control Endpoints**
    - `/test/start`: Starts a simulation where predefined couriers begin sending geolocation updates to the `/track` endpoint. The simulation mimics couriers moving near and around store locations, with each courier sending a request simultaneously. After each cycle, the timestamp is incremented by 10 seconds, and the process repeats until the simulation is explicitly stopped.
    - `/test/stop`: Halts the ongoing simulation of courier movements, stopping the sequence of automated requests to the `/track` endpoint.

- **Zone Entry Logging Endpoint**
    - `/zone-entry`: Retrieves a log of all instances where couriers have entered a 100-meter radius of Migros stores. This endpoint helps in monitoring courier-store interactions over time.

- **Distance Calculation Endpoints**
    - `/total-distance/getTotalTravelDistance`: Accepts a `courierId` as an input parameter and returns the total distance traveled by the specified courier, measured in meters. This function allows for the tracking of individual courier movement over time.
    - `/total-distance/getAllTotalTravels`: Provides a comprehensive list of all couriers, detailing their last known locations and the total distances they have traveled. This endpoint offers an overview of courier activity within the system.

- **Courier Log Retrieval Endpoint**
    - `/courier/getLogs`: Given a `courierId`, returns a detailed log of all location updates recorded for the specified courier. This endpoint is useful for auditing and detailed tracking of courier movements.

### Accessing the Database

The application uses an in-memory H2 database for development and testing purposes. You can access the H2 Console to explore the database schema, run queries, and interact with the data directly. To access the H2 Console:

- Open a web browser and navigate to [http://localhost:8797/h2-console/](http://localhost:8797/h2-console/).

When prompted for connection settings, use the following parameters to log in:

- **JDBC URL**: `jdbc:h2:mem:db;DB_CLOSE_DELAY=-1`
- **Username**: `sa`
- **Password**: (leave this field empty)

Make sure to adjust the JDBC URL if your project's configuration specifies a different in-memory database name.

## Contact

Halit Mancar - [Gmail](mailto:halitmancar@gmail.com)

Project Link: [https://github.com/halitmancar/courier-tracker](https://github.com/halitmancar/courier-tracker)
