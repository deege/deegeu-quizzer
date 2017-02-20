/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deegeu.trivia.model;

import org.junit.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 *
 * @author dspiess
 */
public class TriviaQuestionArrayAccessTest {

    /**
     * Test of getQuestion method, of class TriviaQuestionArrayAccess.
     */
    @Test
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
        TriviaQuestion result = instance.getQuestionById(index);
        assertEquals("Trivia questions 1 do not match in ::getQuestion().", expResult.getId(), result.getId());
    }

    /**
     * Test of getRandomQuestion method, of class TriviaQuestionArrayAccess.
     */
    @Test
    public void testGetRandomQuestion() {
        System.out.println("getRandomQuestion");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        TriviaQuestion result = instance.getRandomQuestion();
        assertNotNull("A random question was not returned in ::getRandomQuestion().", result);
    }

    /**
     * Test of getQuestionList method, of class TriviaQuestionArrayAccess.
     */
    @Test
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
    @Test
    public void testGetQuestionListSize() {
        System.out.println("getQuestionListSize");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        long expResult = 11;
        long result = instance.getQuestionListSize();
        assertEquals("There should only be 11 trivia questions in ::getQuestionListSize.", expResult, result);
    }

    @Test
    public void getQuestionsBySpecifiedList(){

        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();

        List<TriviaQuestion> questionList = instance.getSpecifiedQuestionList(0L, 1L, 2L);

        List<Long> actual = questionList.stream()
                                        .map(TriviaQuestion::getId)
                                        .collect(Collectors.toList());

        List<Long> expected = Arrays.asList(0L, 1L, 2L);
        assertTrue(actual.containsAll(expected));

    }

}
