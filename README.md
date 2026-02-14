This project implements a console-based tennis match scoring application in Java.

The application models a real tennis match, including:
  - Point scoring (Love, 15, 30, 40, Deuce, Advantage)
  - Game scoring
  - Set scoring (win by 2 games)
  - Match scoring (configurable best-of-N sets)
  - Console interaction

Core Components: 
  - Player - represents a tennis player
  - Game - Implements the tennis game scoring rules
  - Set - Implementation that manages the games within a set
  - Match - Implementation that manages the sets within a match
  - TennisMatchController - Handles console input/output

How to run: 
  - Open a console and navigate to \ExerciseProjects\TennisGameApplicationDemo\src>
  - Run `javac *.java` to compile the project
  - Run `java TennisMatchController` to start the application
