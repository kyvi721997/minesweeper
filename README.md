### Brief

Add the mine counts to a completed Minesweeper board.

Minesweeper is a popular game where the user has to find the mines using numeric hints that indicate how many mines are directly adjacent (horizontally, vertically, diagonally) to a square.

In this exercise you have to create some code that counts the number of mines adjacent to a given empty square and replaces that square with the count.

The board is a rectangle composed of blank space (' ') characters. A mine is represented by an asterisk ('\*') character.

If a given space has no adjacent mines at all, leave that square blank.

## Examples

For example you may receive a 5 x 4 board like this (empty spaces are represented here with the '·' character for display on screen):

```
·*·*·
··*··
··*··
·····
```

And your code will transform it into this:

```
1*3*1
13*31
·2*2·
·111·
```


### Running the tests

You can run all the tests by entering the following in your terminal:

```sh
$ gradle test
```

### Evaluation Criteria

- Java best practices
- Show us your work through your commit history
- Completeness: Did you complete the features? Are all the tests running?
- Correctness: Does the functionality act in sensible, thought-out ways?
- Maintainability: Is it written in a clean, maintainable way?

### CodeSubmit

Please organize, design, and document your code as if it were going into production - then push your changes 
to the master branch. After you have pushed your code, you may submit the assignment on the assignment page.

All the best and happy coding,

The BeTech Team