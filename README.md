
## Book My Show - MVC Architecture Project

This project demonstrates the implementation of an MVC (Model-View-Controller) architecture for a "Book My Show" application. Below is an overview of the key components and their interactions within this architecture.

### Overview

In the MVC architecture, the view represents the application's front end, which interacts with users. When a user interacts with the view, a request is sent to the Controller via an API form. The Controller processes the request, validates the information, and passes it to the Service layer. The Service layer contains the business logic and interacts with the Repository layer to retrieve or save data. The Repository layer communicates with the database where data is stored in models like `Movie`, `Theatre`, and `Ticket`.

### Key Principles

1. **View to Controller Communication:** The view communicates with the controller.
2. **Controller to Service Communication:** The controller communicates with the service.
3. **Service to Repository Communication:** The service communicates with the repository.
4. **No Direct Communication:** The view should not directly communicate with the repository, and the controller should not communicate directly with the repository.

### DTOs and Mappers

To manage sensitive data and minimize exposure, Data Transfer Objects (DTOs) are used. DTOs contain only the necessary attributes for the front end. The service layer returns DTOs to the controller instead of models, ensuring that sensitive information is not exposed.

### Project Structure

#### Controllers

1. **CityController:**
    - Manages city-related operations such as retrieving and updating city information.

2. **InitController:**
    - Handles initialization tasks for the application.

3. **TheatreController:**
    - Manages theatre-related operations, including retrieving, creating, and updating theatre information.

4. **TicketController:**
    - Handles ticket-related operations such as booking, retrieving, and updating ticket information.

#### DTOs

- **BookTicketRequestDTO:** Request body for booking a ticket.
- **CityRequestDTO:** Request body for city-related operations.
- **TheatreRequestDTO:** Request body for theatre-related operations.

#### Models

- **Actor:** Represents an actor involved in a movie.
- **Auditorium:** Represents an auditorium within a theatre.
- **City:** Represents a city where theatres are located.
- **Movie:** Represents a movie.
- **Payment:** Represents a payment transaction.
- **Seat:** Represents a seat in an auditorium.
- **Show:** Represents a show for a movie.
- **ShowSeat:** Represents the seat assignment for a show.
- **Theatre:** Represents a theatre.
- **Ticket:** Represents a booking ticket.
- **User:** Represents a user of the application.

#### Repositories

1. **ActorRepository:** Interface for actor data operations.
2. **AuditoriumRepository:** Interface for auditorium data operations.
3. **CityRepository:** Interface for city data operations.
4. **MovieRepository:** Interface for movie data operations.
5. **PaymentRepository:** Interface for payment data operations.
6. **SeatRepository:** Interface for seat data operations.
7. **ShowRepository:** Interface for show data operations.
8. **TheatreRepository:** Interface for theatre data operations.
9. **TicketRepository:** Interface for ticket data operations.
10. **UserRepository:** Interface for user data operations.

#### Services

1. **CityService:** Handles business logic for cities.
2. **InitService:** Manages initialization tasks for the application.
3. **ShowSeatService:** Handles business logic for show seat assignments.
4. **TheatreService:** Manages business logic for theatres.
5. **TicketService:** Handles business logic for tickets.

### Seat Booking Approach

In this project, we use the **optimistic locking technique** to handle seat bookings. This approach ensures that multiple users can attempt to book the same seat concurrently without conflicts, thereby maintaining data consistency and integrity.

#### How Optimistic Locking Works

1. **Versioning:** Each seat record in the database includes a version number.
2. **Read:** When a user attempts to book a seat, the current version number of the seat record is read.
3. **Update:** The booking is processed only if the version number has not changed since the initial read. This check is done during the update operation.
4. **Conflict Handling:** If the version number has changed (indicating that another user has modified the record), the booking fails, and the user is informed to try again.

This technique reduces the chances of data conflicts and ensures a smooth booking experience.

### In-Memory Data Persistence

For this project, we use **in-memory data persistence** to store data temporarily during the application's runtime. This approach is suitable for testing and development purposes, providing faster data access and manipulation without the need for a persistent database.

#### InitService

The **InitService** is responsible for populating all the necessary data into memory for running the project. This service initializes essential entities such as cities, theatres, movies, shows, seats, and more, ensuring that the application is ready to use from the start.

### Conclusion

This project showcases an MVC architecture with a clear separation of concerns, using DTOs for secure data transfer and mappers for data conversion. It ensures that each layer interacts only with its adjacent layers, promoting a clean and maintainable codebase. The "Book My Show" application efficiently handles movie listings, theatre management, ticket bookings, and user management, providing a robust framework for similar projects. The implementation of the optimistic locking technique for seat bookings ensures data integrity and a seamless user experience. Additionally, the use of in-memory data persistence allows for efficient testing and development, with the InitService ensuring the application is pre-populated with necessary data for immediate use.

---

This detailed README outlines the project's architecture, principles, structure, functionalities, the seat booking approach using optimistic locking, the use of in-memory data persistence, and the role of the InitService. Follow the steps mentioned earlier to update your GitHub README file with this content. If you need further assistance, feel free to ask!
