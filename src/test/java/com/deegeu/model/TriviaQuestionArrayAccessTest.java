/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deegeu.model;

import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author dspiess
 */
public class TriviaQuestionArrayAccessTest extends TestCase {
    
    public TriviaQuestionArrayAccessTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getQuestion method, of class TriviaQuestionArrayAccess.
     */
    public void testGetQuestion() {
        System.out.println("getQuestion");
        long index = 1;
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        TriviaQuestion expResult = (new TriviaQuestionBuilder())
                .id(1)
                .question("What was the first toy advertised on television?")
                .answerA("The Rubix Cube")
                .answerB("Mr. Potato Head")
                .answerC("Barbie")
                .answerD("A hula hoop")
                .correctAnswer("B")
                .hint("Use your head on this one")
                .lastUpdated(new Date())
                .build();
        TriviaQuestion result = instance.getQuestion(index);
        assertEquals("Trivia questions 1 do not match in ::getQuestion().", expResult, result);
    }

    /**
     * Test of getRandomQuestion method, of class TriviaQuestionArrayAccess.
     */
    public void testGetRandomQuestion() {
        System.out.println("getRandomQuestion");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        TriviaQuestion expResult = null;
        TriviaQuestion result = instance.getRandomQuestion();
        assertNotNull("A random question was not returned in ::getRandomQuestion().", result);
    }

    /**
     * Test of getQuestionList method, of class TriviaQuestionArrayAccess.
     */
    public void testGetQuestionList() {
        System.out.println("getQuestionList");
        long offset = 0L;
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        List<TriviaQuestion> result = instance.getQuestionList(offset);
        
        assertNotNull("Trivia question list not returned in ::getQuestionList.", result);
        assertEquals(10, result.size());
    }

    /**
     * Test of getQuestionListSize method, of class TriviaQuestionArrayAccess.
     */
    public void testGetQuestionListSize() {
        System.out.println("getQuestionListSize");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        long expResult = 10;
        long result = instance.getQuestionListSize();
        assertEquals("There should only be 10 trivia questions in ::getQuestionListSize.", expResult, result);
    }
    
}
