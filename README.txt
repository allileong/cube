Welcome.

HOWTO: modify the main() function in Cube.java to make moves on the cube.
Create a Cube object, and call methods within cube to move it around. The moves are located in the MOVES sections.
Create a Reader object, and call read and write with the text file name (as in the file) to write and read.

REPRESENTATION: Rubik's cube is represented as 6 2-d arrays, each representing a face. 

BASIC MOVES: Basic methods are only called on the front face, and include rotating the right column up/down and rotating the left column up/down.

ORIENTATION MOVES: Methods for changing the view/orientation of the cube. Include rotate_left, rotate_right, cube_clockwise, etc.

COMPLEX MOVES: 
To account for more complex moves such as rotating the back face, the view of the cube may be adjusted by methods such as rotate_left, rotate_right, cube_clockwise, cube_counterclockwise, etc.
Complex moves may be achieved by rotating the cube to a more appropriate orientation, and then performing one or more of the 4 basic moves.

OUTPUT FILES:
Starting with solved.txt (the solved one we were given):

randomizedcube-1000moves.txt: a solvable cube

jumbled.txt was the jumbled cube we were given.
