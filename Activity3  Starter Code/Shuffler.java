
/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 *
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
				" consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
				" consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		perfectShuffle(values2);
		System.out.println(flip());
		int[] array1 = {1, 2, 3, 4, 5, 6};
		int[] array2 = {2, 4, 5, 99, 1, 3};
		System.out.println(arePermutations(array1, array2));
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 *
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int[] shuffled = new int[values.length];
		int k = 0;
		for (int j = 0; j < values.length / 2; j++) {
			shuffled[k] = values[j];
			k += 2;
		}
		int m = 1;
		for (int l = values.length / 2; l < values.length; l++) {
			shuffled[m] = values[l];
			m += 2;
		}
		for (int b = 0; b < values.length; b++) {
			values[b] = shuffled[b];
		}

	}


	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 *
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int random = 0;
		int[] shuffle = new int[values.length];
		for(int i = 0; i < values.length; i++) {
			shuffle[i] = values[i];
		}
		for(int i = 0; i < values.length; i++) {
			random = (int)(Math.random()*values.length);

			while(shuffle[random]==-1) {
				random = (int)(Math.random()*values.length);
			}
			values[i] = shuffle[random];
			shuffle[random] = -1;

		}
	}
	public static String flip() {
		int flip = (int)(Math.random()*3);
		if(flip < 2) {
			return "heads";
		} else {
			return "tails";
		}
	}
	public static Boolean arePermutations(int[] array1, int[] array2) {
		int equal = 0;
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array2.length; j++) {
				if(array1[i] == array2[j]) {
					equal++;
				}
			}
		}
		if(equal == array1.length) {
			return true;
		} else {
			return false;
		}
	}
}
