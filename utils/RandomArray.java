package utils;

public class RandomArray {
	public float[] randomGenerator(int min, int max) {
		float[] arr = new float[max];
		// define the range
		float range = max - min + 1;
		// generate random numbers within 1 to 10

		for (int i = 0; i < max; i++) {
			arr[i] = (float) Math.floor(((Math.random() * range) + min) * 100) / 100;
		}

		return arr;
	}
}