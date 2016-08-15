# Mars Rover Kata

Mars Rover kata is about implementation of the rover move system command.

Develop an api that moves a rover around on a grid.

- You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
- The rover receives a character array of commands.
- Implement commands that move the rover forward/backward (f,b).
- Implement commands that turn the rover left/right (l,r).
- Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.
- Implement wrapping from one edge of the grid to another. (planets are spheres after all)


Implementation

Recommended approach to solve this kata is by using TDD.
