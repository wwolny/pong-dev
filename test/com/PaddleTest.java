package com;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.PongElements.Paddle;

public class PaddleTest {

	@Test
	public void testPaddle() {
		Paddle pad1 = new Paddle(1, 500, 600);
		pad1.getHeight();		
	}
	
	@Test
	public void testGetPosX() {
		Paddle pad1 = new Paddle(1, 500, 600);
		if(pad1.getPosX() != 10) {
			fail("Paddle");
		} 
	}

	@Test
	public void testGetPosY() {
		Paddle pad1 = new Paddle(1, 500, 600);
		if(pad1.getPosY() != 250) {
			fail("Paddle");
		} 
	}

	@Test
	public void testGetWidth() {
		Paddle pad1 = new Paddle(1, 500, 600);
		if(pad1.getWidth() != 10) {
			fail("Paddle");
		} 
	}

	@Test
	public void testGetHeight() {
		Paddle pad1 = new Paddle(1, 500, 600);
		if(pad1.getHeight() != 100) {
			fail("Paddle");
		} 
	}

}
