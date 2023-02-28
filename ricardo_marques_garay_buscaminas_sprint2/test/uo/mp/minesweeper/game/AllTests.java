package uo.mp.minesweeper.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uo.mp.minesweeper.game.board.AllTestsBoard;
import uo.mp.minesweeper.game.square.AllTestsSquare;

@RunWith(Suite.class)
@SuiteClasses({AllTestsBoard.class, AllTestsSquare.class})
public class AllTests {

}
