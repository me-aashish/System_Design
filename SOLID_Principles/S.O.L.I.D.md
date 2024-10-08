# SOLID Principles in Java Spring Boot

## 1. Single Responsibility Principle (SRP)

**Definition**: A class should have one, and only one, reason to change.

**Example**:

```java
// Before SRP: A class that handles both business logic and data persistence
public class UserService {
    public void registerUser(User user) {
        // business logic
        // save user to database
    }
}

// After SRP: Separate responsibilities into UserService and UserRepository
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        // business logic
        userRepository.save(user); // delegate saving responsibility
    }
}

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

## 2. Open/Closed Principle (OCP)

**Definition**: Software entities/Class should be open for extension but closed for modification.

**Example**:

```java
// Before OCP: Modifying the class to add new payment methods
@Service
public class PaymentService {
    public void processPayment(String paymentType) {
        if (paymentType.equals("creditCard")) {
            // process credit card payment
        } else if (paymentType.equals("paypal")) {
            // process PayPal payment
        }
    }
}

// After OCP: Adding new payment methods without modifying PaymentService
public interface PaymentProcessor {
    void process();
}

@Service
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void process() {
        // process credit card payment
    }
}

@Service
public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void process() {
        // process PayPal payment
    }
}

@Service
public class PaymentService {
    private final List<PaymentProcessor> paymentProcessors;

    public PaymentService(List<PaymentProcessor> paymentProcessors) {
        this.paymentProcessors = paymentProcessors;
    }

    public void processPayments() {
        paymentProcessors.forEach(PaymentProcessor::process);
    }
}
```

## 3. Liskov Substitution Principle (LSP)

**Definition**: Subtypes must be substitutable for their base types without affecting the correctness of the program.

**Example**:

```java
// Before LSP: Subclass that violates the behavior of the base class
public class Bird {
    public void fly() {
        // flying behavior
    }
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}

// After LSP: Use an abstract class or interface to enforce proper behavior
public interface Bird {
    void move();
}

public class FlyingBird implements Bird {
    @Override
    public void move() {
        // flying behavior
    }
}

public class Ostrich implements Bird {
    @Override
    public void move() {
        // walking behavior
    }
}
```

## 4. Interface Segregation Principle (ISP)

**Definition**: No client should be forced to depend on methods it does not use.

**Example**:

```java
// Before ISP: Fat interface with unnecessary methods
public interface Worker {
    void work();
    void eat();
}

public class Developer implements Worker {
    @Override
    public void work() {
        // coding
    }

    @Override
    public void eat() {
        // unnecessary method for Developer
    }
}

// After ISP: Separate interfaces for different responsibilities
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public class Developer implements Workable {
    @Override
    public void work() {
        // coding
    }
}
```

## 5. Dependency Inversion Principle (DIP)

**Definition**:High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Example**:

```java
// Before DIP: High-level service depends on a low-level concrete class
@Service
public class NotificationService {
    private final EmailService emailService;

    public NotificationService() {
        this.emailService = new EmailService(); // tightly coupled
    }

    public void sendNotification(String message) {
        emailService.sendEmail(message);
    }
}

// After DIP: High-level service depends on abstraction
public interface MessageService {
    void sendMessage(String message);
}

@Service
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        // send email
    }
}

@Service
public class NotificationService {
    private final MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService; // loosely coupled
    }

    public void sendNotification(String message) {
        messageService.sendMessage(message);
    }
}
```
