package hu.zforgo.poker.hand;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Calculator {

	private static <T1, T2, R> Function<T1, Stream<R>> crossWith(Supplier<? extends Stream<T2>> that, BiFunction<? super T1, ? super T2, ? extends R> combiner) {
		return t1 -> that.get().map(t2 -> combiner.apply(t1, t2));
	}

	private static List<Card> buildDeck() {
		return Card.types.stream()
				.flatMap(crossWith(Card.values::stream, Card::new))
				.collect(Collectors.collectingAndThen(toList(), list -> {
					Collections.shuffle(list);
					return list;
				}));

	}

	public static void calculate() {
		List<Card> /*deck = buildDeck().subList(0, 5);*/


				deck = Stream.of(
				new Card('X', 10),
				new Card('X', 11),
				new Card('X', 12),
				new Card('X', 13),
				new Card('X', 14)
		).collect(Collectors.toList());

		Optional<Hands> h = Stream.of(Hands.values()).filter(e -> e.applicable(deck)).reduce((h1, h2) -> h2);
		System.out.println(h.get().name());
	}

	public static void main(String... args) {
		calculate();
	}
}
