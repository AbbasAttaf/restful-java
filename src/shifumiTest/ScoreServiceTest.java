package shifumiTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import shifumi.ScoreService;

@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceTest {
	
	@Mock
	private ScoreService ss = new ScoreService();
	 
	@Test
	public void getWinsTest() {/*
	   assertEquals(0,ss.getWins());
	   assertEquals(0,ss.increaseWins());
	   assertEquals(1,ss.getWins());*/
		
		ss.increaseWins();
		Mockito.verify(ss).increaseWins();
		assertEquals(0,ss.getWins());
	   
		Mockito.when(ss.getWins()).thenReturn(1);
		assertEquals(1,ss.getWins());
	}
	
	@Test
	public void getLossesTest() {
		
		ss.increaseLosses();
		Mockito.verify(ss).increaseLosses();
		assertEquals(0,ss.getLosses());
	   
		Mockito.when(ss.getLosses()).thenReturn(1);
		assertEquals(1,ss.getLosses());
	}
	
	@Test
	public void getTiesTest() {
		
		ss.increaseTies();
		Mockito.verify(ss).increaseTies();
		assertEquals(0,ss.getTies());
	   
		Mockito.when(ss.getTies()).thenReturn(1);
		assertEquals(1,ss.getTies());
	}
	
	@Test
	public void getScoreTest() {
		ss.update(1,1,1);
		Mockito.verify(ss).update(1,1,1);
		
		Mockito.when(ss.getScore()).thenReturn("{ \"wins\":\"1\", \"losses\":\"1\", \"ties\": \"1\"}");
		assertEquals("{ \"wins\":\"1\", \"losses\":\"1\", \"ties\": \"1\"}",ss.getScore());
	}

	
	
}
