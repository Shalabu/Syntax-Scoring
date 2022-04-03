# Syntax-Scoring
Advent of code --- Day 10: Syntax Scoring ---

## The Problem
Scan a given string and detect the corrupted chunks, then calculate the syntax errors points 
based on the error character, more information can be found [here](https://adventofcode.com/2021/day/10).

## The Solution
The Solution is based on using a stack to push chunks opening characters and popping them back if their 
closing counterpart if found, then if the stack is empty, a chunk is valid, otherwise calculate the incorrect closing part.

## Assumptions

### Program function
 - The program finishes processing a line when detecting the first corrupted chunk.
 - The Program ignores the incomplete chunks.

### Output Range
The range of points is the range of Java Integer MAX