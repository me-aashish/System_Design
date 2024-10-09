# Startegy Pattern

- The Strategy Pattern is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one, and make them interchangeable. It lets the algorithm vary independently from the clients that use it.

- Key points:
- Encapsulation of algorithms: Different strategies (algorithms) are implemented as separate classes.
- Interchangeability: You can swap the strategy used by a client dynamically at runtime without altering the client's code.
- Simplifies code: It avoids complex conditional statements by promoting the use of different strategy classes.
- For example, in a payment system, you might have multiple payment methods like credit card, PayPal, or bank transfer. Each method can be implemented as a separate strategy, and the user can choose a strategy at runtime based on their preferred payment option.
