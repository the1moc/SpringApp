# Spring Web Application

- HATEOAS API
-  Simple Login Authentication Page (sprint boot security)
- MySQL database for persistent storage
- UI in ReacctJS
- Non-comprehensive UI tests (written in jasmine)

Things Completed

- [x] - Maven implemented
- [x] - API implemented - custom requests implemented to filter by shift day / time
- [x] - ReactJS simple UI created
- [x] - ReactJS style updated for table, added buttons for custom ajax filtering requests
- [x] - MySQL integration added, schema created and mock data added 
- [x] - MySQL database generation on startup implemented
- [x] - Webpack integrated
- [x] - Write first set of jasmine frontend tests
- [x] - Request queries written in pure SQL 

Things not done

- [ ] - Write more tests
- [ ] - Integrate jasmine tests with maven
- [ ] - Write custom login authentication page (prebuilt currently)
- [ ] - Combined day and time filter options into single query
- [ ] - Get more comfortable with HQL for code query generation

## **Running the application**

### Required
MySQL server instance and blank database running: localhost:3306/shiftdb - username = sa, password = spcol

**Any of these details can be changed in the application.properties file as per desire**

### Execution
Navigate to the root of the application, and run mvn spring-boot:run (opens to local port 8080)

Enter username and password (firstuser / password)

#### Available API endpoints
api/getAllShifts

api/getShiftsFor/{putDesiredNameHere}

api/getShiftsFor/{putFirstNameHere}/{putLastNameHere}

api/shiftsOnDay/{desiredDayHere}

api/shiftsAtTime/{desiredTimeHere}

## Test execution

Not currently implemented in maven or linking with webpack bundle, mvn jasmine:bdd to run tests (redundant currently)
