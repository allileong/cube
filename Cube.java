import java.util.Random;

public class Cube {

	static final int yellow = 1;
	static final int blue = 2;
	static final int red = 3;
	static final int green = 4;
	static final int orange = 5;
	static final int white = 6;

	private static int[][] top;
	private static int[][] left;
	private static int[][] front;
	private static int[][] right;
	private static int[][] back;
	private static int[][] bottom;

	public Cube(int[][][] cube) {
		Random rand = new Random();
		top = cube[0];
		left = cube[1];
		front = cube[2];
		right = cube[3];
		back = cube[4];
		bottom = cube[5];

	}

	//CUBE ORIENTATION -------------------------------------------------------------------------------
	public void rotate_left(){
		int[][] old_top = top;
		int[][] old_left = left;
		int[][] old_front = front;
		int[][] old_right = right;
		int[][] old_back = back;
		int[][] old_bottom = bottom;

		back = old_left;
		left = old_front;
		front = old_right;
		right = old_back;
		top = clockwise(old_top);
		bottom = counterclockwise(old_bottom);
	}

	public void rotate_right(){

		int[][] old_top = top;
		int[][] old_left = left;
		int[][] old_front = front;
		int[][] old_right = right;
		int[][] old_back = back;
		int[][] old_bottom = bottom;

		front = old_left;	
		left = old_back;
		back = old_right;
		right = old_front;
		top = counterclockwise(old_top);
		bottom = clockwise(old_bottom);

	}

	public void rotate_up(){
		int[][] old_top = top;
		int[][] old_left = left;
		int[][] old_front = front;
		int[][] old_right = right;
		int[][] old_back = back;
		int[][] old_bottom = bottom;

		front = old_bottom;
		bottom = old_back;
		back = old_top;
		top = old_front;
		right = clockwise(old_right);
		left = counterclockwise(old_left);

	}

	public void rotate_down(){
		int[][] old_top = top;
		int[][] old_left = left;
		int[][] old_front = front;
		int[][] old_right = right;
		int[][] old_back = back;
		int[][] old_bottom = bottom;

		front = old_top;
		top = old_back;
		back = old_bottom;
		bottom = old_front;
		left = clockwise(old_left);
		right = counterclockwise(old_right);

	}

	public void cube_clockwise(){
		int[][] old_top = top;
		int[][] old_left = left;
		int[][] old_front = front;
		int[][] old_right = right;
		int[][] old_back = back;
		int[][] old_bottom = bottom;

		front = clockwise(old_front);
		back = counterclockwise(old_back);
		top = clockwise(old_left); 
		right = clockwise(old_top);
		left = clockwise(old_bottom);
		bottom = clockwise(old_right);
	}

	public void cube_counterclockwise(){
		int[][] old_top = top;
		int[][] old_left = left;
		int[][] old_front = front;
		int[][] old_right = right;
		int[][] old_back = back;
		int[][] old_bottom = bottom;

		front = counterclockwise(old_front);
		back = clockwise(old_back);
		top = counterclockwise(old_right); 
		right = counterclockwise(old_bottom);
		left = counterclockwise(old_top);
		bottom = counterclockwise(old_left);
	}

	public int[][] clockwise(int[][] face){
		int[][] old_face = face;
		face[0][0] = old_face[0][2];
		face[1][0] = old_face[0][1];
		face[2][0] = old_face[0][0];
		face[0][1] = old_face[1][2];
		face[1][1] = old_face[1][1];
		face[2][1] = old_face[1][0];
		face[0][2] = old_face[2][2];
		face[1][2] = old_face[2][1];
		face[2][2] = old_face[2][0];
		return face;
	}

	public int[][] counterclockwise(int[][] face){
		int[][] old_face = face;
		face[0][0] = old_face[2][0];
		face[1][0] = old_face[2][1];
		face[2][0] = old_face[2][2];
		face[0][1] = old_face[1][0];
		face[1][1] = old_face[1][1];
		face[2][1] = old_face[1][2];
		face[0][2] = old_face[0][0];
		face[1][2] = old_face[0][1];
		face[2][2] = old_face[0][2];
		return face;
	}

	// BASIC MOVES -------------------------------------------------------------------------------
	public void right_up(){
		int[] temp = front[2];
		front[2] = bottom[2];
		bottom[2] = back[2];
		back[2] = top[2];
		top[2] = temp;

		// ROTATE RIGHT FACE CLOCKWISE
		clockwise(right);

	}

	public void right_down(){
		int[] temp = front[2];
		front[2] = top[2];
		top[2] = back[2];
		back[2] = bottom[2];
		bottom[2] = temp;

		// ROTATE RIGHT FACE COUNTERCLOCKWISE
		counterclockwise(right);

	}

	public void middle_up(){
		// ROTATE_UP
		rotate_up();

		left_down();
		right_down();

		// ROTATE_DOWN
		rotate_down();

	}

	public void middle_down(){
		//ROTATE_DOWN
		rotate_down();

		left_up();
		right_up();

		//ROTATE_UP
		rotate_up();

	}

	public void left_up(){
		int[] temp = front[0];
		front[0] = bottom[0];
		bottom[0] = back[0];
		back[0] = top[0];
		top[0] = temp;

		// ROTATE LEFT FACE COUNTERCLOCKWISE
		counterclockwise(left);
	}

	public void left_down(){
		int[] temp = front[0];
		front[0] = top[0];
		top[0] = back[0];
		back[0] = bottom[0];
		bottom[0] = temp;

		// ROTATE LEFT FACE CLOCKWISE
		clockwise(left);

	}

	//FANCY MOVES -------------------------------------------------------------------------------
	public void top_row_left() {
		cube_clockwise();
		right_up();
		cube_counterclockwise();
	}

	public void middle_row_left() {
		cube_clockwise();
		middle_up();
		cube_counterclockwise();
	}

	public void bottom_row_left() {
		cube_clockwise();
		left_up();
		cube_counterclockwise();
	}

	public void top_row_right() {
		cube_clockwise();
		right_down();
		cube_counterclockwise();
	}

	public void middle_row_right(){
		cube_clockwise();
		middle_down();
		cube_counterclockwise();
	}

	public void bottom_row_right(){
		cube_clockwise();
		left_down();
		cube_counterclockwise();
	}

	public void front_face_counterclockwise(){
		rotate_right();
		right_down();
	}

	public void front_face_clockwise(){
		rotate_right();
		right_up();
		rotate_left();
	}

	public void middle_face_counterclockwise(){
		rotate_right();
		middle_down();
		rotate_left();
	}

	public void middle_face_clockwise(){
		rotate_right();
		middle_up();
		rotate_left();
	}

	public void back_face_counterclockwise(){
		rotate_right();
		left_down();
		rotate_left();
	}

	public void back_face_clockwise(){
		rotate_right();
		left_up();
		rotate_left();
	}

	public int[][][] toWrite() {
		int[][][] result = {top, left, front, right, back, bottom};
		return result;
	}
	
	public void jumble(int n) {
		int numMoves = 12;
		for (int i = 0; i < n; i++) {
			switch (rand.nextInt(numMoves)) {
			case 0: rotate_left();
				break;
			case 1: rotate_right();
				break;
			case 2: rotate_down();
				break;
			case 3: cube_clockwise();
				break;
			case 4: cube_counterclockwise();
				break;
			case 5: right_up();
				break;
			case 6: right_down();
				break;
			case 7: middle_up();
				break;
			case 8: middle_down();
				break;
			case 9: left_up();
				break;
			case 10: left_down();
				break;
			case 11: rotate_up();
				break;
			}
		}
	}

	public static void main(String[] args){
		Reader r = new Reader();
		Cube c = new Cube(r.read("solved.txt"));
		r.write(c.toWrite(), "result.txt");
		c.cube_counterclockwise();

		r.write(c.toWrite(), "result2.txt");
	}


}
