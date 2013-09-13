import java.io.*;
import java.util.HashMap;

public class Reader {
	public static int YELLOW = 0;
	public static int BLUE = 1;
	public static int RED = 2;
	public static int GREEN = 3;
	public static int ORANGE = 4;
	public static int WHITE = 5;
	
	HashMap<String, Integer> colorMap = new HashMap<String, Integer>();
	HashMap<Integer, String> otherMap = new HashMap<Integer, String>();
	
	// initialize
	public Reader()	{
		colorMap.put("y", YELLOW);
		colorMap.put("b", BLUE);
		colorMap.put("r", RED);
		colorMap.put("g", GREEN);
		colorMap.put("o", ORANGE);
		colorMap.put("w", WHITE);
		otherMap.put(YELLOW, "y");
		otherMap.put(BLUE, "b");
		otherMap.put(RED, "r");
		otherMap.put(GREEN, "g");
		otherMap.put(ORANGE, "o");
		otherMap.put(WHITE, "w");
	}
	
	
	// array of 6 2-dimensional arrays, in order
	public void write(int[][][] cube, String outfile) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
			for (int i = 0; i < 6; i++) {
				String line = "";
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						line += otherMap.get(cube[i][k][j]) + ",";
//						System.out.println("This happens");
					}
				}
//				System.out.println(line.substring(0, line.length() - 1));
				out.write(line.substring(0, line.length() - 1));
				out.newLine();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int[][][] read(String infile) {
		int[][][] cube = new int[6][3][3]; //top, left, front, right, bottom
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
			String line;
			int side = 0;
			while ((line = br.readLine()) != null && line.length() != 0) {
				String[] lineSplit = line.split(",");
				if (lineSplit.length != 9) {
					br.close();
					throw new Exception();
				}
				int j = 0;
				for (int i = 0; i < 3; i++) {
					cube[side][i][0] = colorMap.get(lineSplit[j]);
					j++;
				}
				for (int i = 0; i < 3; i++) {
					cube[side][i][1] = colorMap.get(lineSplit[j]);
					j++;
				}
				for (int i = 0; i < 3; i++) {
					cube[side][i][2] = colorMap.get(lineSplit[j]);
					j++;
				}
				side++;
			}
			br.close();
			return cube;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while reading file");
			return new int[0][0][0];
		}
	}
	
	// test
	public static void main(String[] args) {
		Reader r = new Reader();
		r.write(r.read("jumbled.txt"), "copy.txt");
	}
}
