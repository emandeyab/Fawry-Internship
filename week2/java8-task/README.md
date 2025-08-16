# Java 8 Streams & Lambda Task

## Overview
This project demonstrates the use of **Java 8 Streams** and **Lambda expressions** using two examples:

1. **StreamsExample** – Working with a list of `Author` objects and their `Book`s:
   - Print all authors
   - Filter active authors
   - Filter authors with published books
   - Calculate average book price
   - Combine filters for active authors with published books

2. **LambdaExample** – Working with a list of `User` objects:
   - List all users
   - Filter users based on conditions (active, age)
   - Sort users by name or age
   - Combine filters and sorting using lambdas

The project uses **functional interfaces** such as:
- `Consumer<T>`
- `Predicate<T>`
- `Function<T,R>`
- `ToIntFunction<T>`
- `Comparator<T>`

