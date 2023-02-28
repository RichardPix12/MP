package uo.mp.minesweeper.game.board;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConstructorTest.class, FlagTest.class, GetStatusTest.class, StepOnTest.class, UnveilTest.class,
		UnFlagTest.class })
public class AllTestsBoard {

}
