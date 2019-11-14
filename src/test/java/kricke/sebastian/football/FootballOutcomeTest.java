package kricke.sebastian.football;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests calculation method of football outcome model.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
class FootballOutcomeTest {

	@Test
	void testDifferenceCalculationBySpecificConstructorPositive() {
		FootballOutcome testOutcome = new FootballOutcome(39,18);
		Integer expectedDifference = 21;		
		
		assertEquals(expectedDifference, testOutcome.getDifference(), "Wrong goal difference was calculated by specific constructor.");
	}
	
	@Test
	void testDifferenceCalculationBySpecificConstructorNegative() {
		FootballOutcome testOutcome = new FootballOutcome(28,44);
		Integer expectedDifference = -16;		
		
		assertEquals(expectedDifference, testOutcome.getDifference(), "Wrong goal difference was calculated by specific constructor.");
	}
	
	@Test
	void testDifferenceCalculationBySetGoals() {
		FootballOutcome testOutcome = new FootballOutcome();
		testOutcome.setGoals(3);
		Integer expectedDifference = 3;		
		
		assertEquals(expectedDifference, testOutcome.getDifference(), "Wrong goal difference was calculated by setGoals.");
	}
	
	@Test
	void testDifferenceCalculationBySetGoalsAllowed() {
		FootballOutcome testOutcome = new FootballOutcome();
		testOutcome.setGoalsAllowed(2);
		Integer expectedDifference = -2;		
		
		assertEquals(expectedDifference, testOutcome.getDifference(), "Wrong goal difference was calculated by setGoalsAllowed.");
	}
	
	@Test
	void testDifferenceCalculationBySetGoalsInOut() {
		FootballOutcome testOutcome = new FootballOutcome();
		testOutcome.setGoals(39);
		testOutcome.setGoalsAllowed(18);
		Integer expectedDifference = 21;		
		
		assertEquals(expectedDifference, testOutcome.getDifference(), "Wrong goal difference was calculated by setGoals and setGoalsAllowed.");
	}

}
