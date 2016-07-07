package hu.zforgo.poker.hand;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public enum Hands {

	HIGH {
		@Override
		public boolean applicable(List<Card> hand) {
			return true;
		}
	},

	PAIR {
		@Override
		public boolean applicable(List<Card> hand) {
			return hand.stream().collect(
					Collectors.groupingBy(Card::getValue, Collectors.counting()))
					.entrySet().stream().filter(e -> e.getValue() > 1)
					.findFirst().isPresent();
		}

	},

	TWO_PAIR {
		@Override
		public boolean applicable(List<Card> hand) {
			return hand.stream().collect(
					Collectors.groupingBy(Card::getValue, Collectors.counting()))
					.entrySet().stream().filter(e -> e.getValue() > 1)
					.count() > 1;
		}

	},

	DRILL {
		@Override
		public boolean applicable(List<Card> hand) {
			return hand.stream().collect(
					Collectors.groupingBy(Card::getValue, Collectors.counting()))
					.entrySet().stream().filter(e -> e.getValue() > 2)
					.findFirst().isPresent();
		}
	},

	STRAIGHT {
		@Override
		public boolean applicable(List<Card> hand) {
			Optional<Card> r = hand.stream()
					.sorted((c1, c2) -> Integer.compare(c1.getValue(), c2.getValue()))
					.reduce((c1, c2) -> c2.getValue() - c1.getValue() == 1 ? c2 : DUMMY);
			return r.orElse(DUMMY).getValue() > 0;
		}
	},

	FLUSH {
		@Override
		public boolean applicable(List<Card> hand) {
			return hand.stream().collect(
					Collectors.groupingBy(Card::getType, Collectors.counting()))
					.size() == 1;
		}
	},

	FULL {
		@Override
		public boolean applicable(List<Card> hand) {
			return TWO_PAIR.applicable(hand) && DRILL.applicable(hand);
		}
	},

	POKER {
		@Override
		public boolean applicable(List<Card> hand) {
			return hand.stream().collect(
					Collectors.groupingBy(Card::getValue, Collectors.counting()))
					.entrySet().stream().filter(e -> e.getValue() > 3)
					.findFirst().isPresent();
		}
	},

	STRAIGHT_FLUSH {
		@Override
		public boolean applicable(List<Card> hand) {
			return STRAIGHT.applicable(hand) && FLUSH.applicable(hand);
		}
	},

	ROYAL_FLUSH {
		@Override
		public boolean applicable(List<Card> hand) {
			return STRAIGHT_FLUSH.applicable(hand) &&
					hand.stream()
							.reduce(BinaryOperator.minBy((c1, c2) -> Integer.compare(c1.getValue(), c2.getValue()))).orElse(DUMMY).getValue() == 10;
		}
	};

	private static final Card DUMMY = new Card('X', 0);

	public abstract boolean applicable(List<Card> hand);

}
