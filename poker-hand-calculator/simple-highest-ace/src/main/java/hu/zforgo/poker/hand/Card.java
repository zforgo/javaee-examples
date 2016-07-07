package hu.zforgo.poker.hand;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final List<Character> types = Arrays.asList('A', 'B', 'C', 'D');
	public static final List<Integer> values = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

	private final char type;
	private final int value;

	public Card(char type, int value) {
		this.type = type;
		this.value = value; //TODO range check
	}

	public char getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Card{" +
				"type=" + type +
				", value=" + value +
				'}';
	}
}
