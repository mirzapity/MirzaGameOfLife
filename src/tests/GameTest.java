package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juegovida.*;

class GameTest {
	
	private Game game = new Game();

	/**
	 * comprueba que todas las filas sean arrays con el valor false despues de hacer clear.
	 */
	@Test
	void testGameClear() {
		game.clear();
		int width = game.getMatrizWidth();
		int height = game.getMatrizHeight();
		for (int i=0;i < width;i++)
			if (!Arrays.equals(game.getMatriz()[i], new boolean[height])) {
				fail("Row " + i + " is not correct");
			}
	}
	
	/**
	 * este metodo testea si establecer el tamaño de la matriz funciona correctamente
	 */
	@Test
	void testSetWidthHeight() {
		game.setWidthHeight(10,20);
		assertEquals(game.getMatrizWidth(), 10);
		assertEquals(game.getMatrizHeight(), 20);
	}
	
	@Test
	void testSetCellAlive() {
		game.setCellAlive(0, 0, true);
		assertTrue(game.getMatriz()[0][0]);

		game.setCellAlive(0, 0, false);
		assertFalse(game.getMatriz()[0][0]);
	}
	
	/**
	 * Este metodo testea el que una celula con 3 vecinos cobre vida
	 */
	@Test
	void testNextIteration() {
		game.setWidthHeight(3, 3);
		game.setCellAlive(0, 0, true);
		game.setCellAlive(0, 1, true);
		game.setCellAlive(1, 0, true);
		game.nextIteration();
		assertTrue(Arrays.equals(game.getMatriz()[0], new boolean[] {true, true, false}));
		assertTrue(Arrays.equals(game.getMatriz()[1], new boolean[] {true, true, false}));
		assertTrue(Arrays.equals(game.getMatriz()[2], new boolean[] {false, false, false}));
	}

}
