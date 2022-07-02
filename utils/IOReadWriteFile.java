package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOReadWriteFile {

	public boolean isNewFile(String fileName) {
		File file = new File(fileName);
		// Check if the file already exists
		try {
			file.createNewFile();
			return true;
		} catch (IOException e) {
			return false;
		}

	}

	public boolean isDeleteFile(String fileName) {
		File file = new File(fileName);
		boolean isDelete = file.delete();
		if (isDelete) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isWriteFile(String fileName, float[] array, String number) {
		BufferedWriter bufferedWriter = null;
		// Input data and write to text file
		try {
			if (number == null) {
				bufferedWriter = new BufferedWriter(new FileWriter(fileName, false));
				for (int i = 0; i < array.length; i++) {
					// Write array to the text file
					bufferedWriter.write(array[i] + " ");
				}
				bufferedWriter.write("\n");
			} else {
				bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
				// Write String to the text file
				bufferedWriter.write(number + " ");
			}
			bufferedWriter.flush();
		} catch (IOException exception) {
			return false;
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				System.out.println("Not close file.");
			}
		}

		return true;
	}

	public float[] readFile(String fileName) {
		float[] array = null;
		FileInputStream fis = null;
		BufferedReader bufferedReader = null;

		// Read file into an ArrayList
		try {
			fis = new FileInputStream(fileName);
			bufferedReader = new BufferedReader(new InputStreamReader(fis));
			String strLine = bufferedReader.readLine();
			String[] text = strLine.split(" ");
			array = new float[text.length];

			for (int i = 0; i < array.length; i++) {
				array[i] = Float.parseFloat(text[i]);
			}

		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
		} catch (IOException ex) {
			System.out.println("Error.");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				System.out.println("Not close file.");
			}
		}
		return array;
	}
}