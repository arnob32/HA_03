## 🧳✈️ Airport Smart Luggage Management System

### An intelligent system to track, manage, and secure passenger luggage throughout the airport journey—from check-in to claim.
This project demonstrates advanced Exception Handling and Unit Testing concepts in Java within a real-world use case.

## 🧠 Project Overview

The Airport Smart Luggage Management System is designed to make luggage handling faster, safer, and smarter at airports.
It uses modern technologies to monitor every bag’s journey — from check-in to loading, flight transfer, and baggage claim — while handling unexpected system or data errors gracefully.

This project also focuses on robust exception handling and comprehensive unit testing as part of a Java Capstone assignment.

## 👨‍💻 Task Distribution 

**Team 7**
      1. Nawshad Fahim - MDT 7216629 ( LogManager.java, Main.java)
      2. Md Shariful Islam - MDT-7213424
      3. Ibrahim Khalil - MDT 7213232 (QueueManage.java, askSimulator.java)
      4. Raju Naidu - MDT 7213668 (ChargingStation.java, LogService.java, chargingQueue.java, AGV.java)


## 🎯 Main Objectives
      ✅ Ensure accurate luggage tracking using RFID and database records.
      
      ✅ Prevent luggage loss by maintaining real-time status and alerts.
      
      ✅ Handle system errors gracefully (missing files, invalid data, device issues).
      
      ✅ Apply Cooncurrency and multitreading techniques:

   
## Question Answers:
### Question 1: provide a comparison of the concurrency models(Procs & Cons)

Concurrency Model: 
The term for a program that coordinates and manages multiple processes at the same time is called a concurrency model. It describes how tasks share data, interact, and coordinate when they run at the same time. Three types of concurrency exist in programming.

1. Shared-state (threads): The shared-state (threads) concurrency model allows multiple threads to share the same memory—data—while they run at the same time. Since all threads can read and write the same variables, they need to use various methods to help prevent errors or conflicts (like race conditions) that might occur when other threads are changing data.

Pros:

      ❖ Simple to develop and use. Most programming languages (like Java) have some thread support.
   
      ❖ Ideal for multitasking. Threads allow several tasks at once (like background tasks).
   
      ❖ Can increase speed. Threads are very useful for improving the performance of input/output-bound programs that wait on data or responses from the network.

Cons:

      ● Conflicts of data (race conditions). Threads can attempt to modify the same data at the same time.
   
      ● Difficult to debug. Errors like deadlocks are hard to identify and fix.
   
      ● Need for synchronization. Additional constructs are needed to guarantee its access to shared data.
   
      ● Higher memory usage. Each thread adds a layer of memory usage to the operating system stack.
   




2. Separate-state model: In this paradigm, every task (or actor) has its own private data; thus, there is no shared memory. Task: exchange information by sending messages to one another. 

Advantages:

      ❖ No shared data issues—no race conditions or data corruption.
   
      ❖ Easier to reason about—each actor works in its own independent way.
   
      ❖ Good scalability—works well with distributed and parallel systems.

Disadvantages: 

      ● Delay in messages – There is a time delay in communication because tasks are sending messages to one another rather than sharing memory. 
   
      ● More complicated design—needs planning to determine how the actors will talk to one another.
   
      ● Memory overhead – Each actor maintains its own state.
   
3.Event loop/asynchronous: The event loop architecture has a single thread that operates on an event loop to handle multiple tasks by reacting to asynchronous things happening, like a user input, network requests, or file reads. Instead of waiting for a previously started task to finish, the event loop can begin a new task while waiting. This is an advantage in the event loop, and it is quick and responsive.

Some pros of using an event loop:

      - Low memory footprint—you typically only have a few threads that can handle many tasks.
      
      - Fast for I/O tasks - Very suitable when performing network or file I/O
      
      - Highly scalable—can handle thousands of connections simultaneously.

Disadvantages of event loop:

      - Difficult for CPU-bound work - Less suitable for tasks that take a lot of processing time.
      
      - Messy code—The code can become messy and complex to write and understand (especially with callbacks).
      
      - Difficult error handling: Error handling for asynchronous processing can also be complex.
  
### Question 2: Explain differences between Concurrency vs Parallelism 
Concurrency vs Parallelism :
Concurrency implies performing many processes at the same time. Parallelism means performing processes in lockstep, with multiple processors (or CPU cores) performing processes at the same time.

Goal: The goal of concurrency is to increase responsiveness and manage many tasks efficiently. The goal of parallelism is to increase processing speed and performance.

Best for: Concurrency works best with I/O-bound tasks like requests over the web or user inputs. Parallelism works best with CPU-bound tasks like simulations or data processing.
Example: A concurrent system may be a web server servicing multiple clients simultaneously. A parallel system may be a data program that processes information faster by utilizing multiple cores.
### Question 3: Explain the usage of Blocking Concurrency Algorithms and Non-blocking Concurrency Algorithms

Blocking:

Blocking algorithms cause a thread to pause until there is a sufficient condition or resource before it continues execution. Non-blocking algorithms use atomic operations or retry so the thread can continue to run, rather than waiting.

Blocking Until the task completes or the resource is available, the blocking algorithm holds the thread until it can continue. Helpful in basic web servers, desktop applications, or small systems where resource use has not become an issue.

Pros: It is easier to program and understand.

Cons: Because the thread wastes time from waiting, it can take longer in a large system.

Non-blocking:

Non-blocking algorithms, often utilizing atomic operations, allow the thread to keep running and retry at a later time. Used for higher-performance applications such as databases, real-time systems, and servers that service thousands of users at once.

Pros: Performance is improved because it is faster and does not require waiting.

Cons: It is more difficult to develop and test.



## Recorded Screencast Vidoe Link: [https://drive.google.com/file/d/14M_wuXevugLJyWOArIQyXnKLBygcE6nh/view?usp=sharing]

## 👨‍💻 Author

**Team 7**
1. Md Shariful Islam MDT-7213424

2. Nawshad Fahim MDT 7216629

3. Ibrahim Khalil MDT 7213232

4. Raju Naidu MDT 7213668
