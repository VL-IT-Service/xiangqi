## Xiangqi
Xiangqi China Chess in JAVA with Object-Oriented Data Model

for rules refer to https://en.wikipedia.org/wiki/Xiangqi

This project aims at building a xinagqi server that can respond to String encoding the moves of the players.

Phase 1:
Build the model and implement all the moves and the check wether a move is valid or not.  
Use JUnit tests to verify that all GameToken are moving according to the rules.

GameServer - the class to represent the server itself

GameBoard - a class that stores the board and knows, where (on which position) each GameToken is

GameToken - an abstract class representing the single token (General, Advisor, Elephant, etc.)

This is inherited by several classes that implement the special behavoir of the respecive GameToken. This means mainly that it knows the rule how to move across the board and it knows it's String representation

See UML diagram for the class model.


Board is represented similar to FEN (Forsyth-Edwards-Notation) String, which can be imported and exported from the GameBoard. 
The start configuration of the board is represented by the string "rheagaehr/9/1c5c1/s1s1s1s1s/9/9/S1S1S1S1S/1C5C1/9/RHEAGAEHR"

Red is upperCase letters Black is lowerCase. Number represent empty fields. "/" means a new row

G General

A Advisor

E Elephant

H Horse

R Rook

C Cannon

S Soldier
