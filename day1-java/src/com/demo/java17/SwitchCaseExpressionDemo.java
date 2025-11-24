package com.demo.java17;

public class SwitchCaseExpressionDemo {

	public static void main(String[] args) {

		Day day = Day.WEDNESDAY;

		int numLetters=switch (day) {
		case MONDAY, FRIDAY, SUNDAY->6;
		case THURSDAY, SATURDAY->7;
		case WEDNESDAY->9;
		default->
			throw new IllegalArgumentException("Unexpected value: ");
		};

		System.out.println(numLetters);
	}

}
