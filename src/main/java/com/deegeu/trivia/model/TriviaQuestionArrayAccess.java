/*
 * The MIT License
 *
 * Copyright 2016 DJ Spiess.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.deegeu.trivia.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Accesses the trivia question "database". This is used to test out the rest of
 * the functionality. The database is an {@link ArrayList}.
 * 
 * @author DJ Spiess
 */
public class TriviaQuestionArrayAccess implements TriviaQuestionAccessible {
    private List<TriviaQuestion> questionList;
    static private final int MAX_NUMBER_OF_QUESTIONS_PER_PAGE = 10;
    
    /**
     * Constructor. Loads the array with trivia questions.
     */
    public TriviaQuestionArrayAccess() {
        this.loadQuestionArray();
    }
    
    @Override
    public TriviaQuestion getQuestionByIndex(long index) {
        // Force conversion from long to an int intentionally.
        return ((int) index < questionList.size()) ? questionList.get((int) index) : null;
    }
    
    @Override
    public TriviaQuestion getQuestionById(long id) {
        for (TriviaQuestion question: questionList) {
            if (question.getId() == id) {
                return question;
            }
        }
        return null;
    }
    
    @Override
    public TriviaQuestion getRandomQuestion() {
        int index = (new Random()).nextInt(questionList.size());
        return questionList.get(index);
    }
    
    @Override
    public List<TriviaQuestion> getQuestionList(long offset) {
        long start = offset; 
        if (start < 0) {
            start = 0;
        }
        if (start >= questionList.size()) {
            start = questionList.size();
        }
        long end = start + MAX_NUMBER_OF_QUESTIONS_PER_PAGE;
        if (end >= questionList.size()) {
            end = questionList.size();
        }
        
        return questionList.subList((int) start, (int) end);
    }

    @Override
    public List<TriviaQuestion> getSpecifiedQuestionList(long... id) {

        // Convert the var args into a List
        final List<Long> ids = Arrays.stream(id)
                                     .boxed()
                                     .collect(Collectors.toList());

        // Filter the question list to only have question with the given ids
        return this.questionList.stream()
                                .filter(p -> ids.contains(p.getId()))
                                .collect(Collectors.toList());

    }
    
    @Override
    public long getQuestionListSize() {
        return questionList.size();
    }

    /*
        Creates trivia questions and adds them to an array.
    */
    private void loadQuestionArray() {
        questionList = new ArrayList<>();
        questionList.add((new TriviaQuestionBuilder())
            .id(0)
            .question("How many feet are in a mile?")
            .answerA("5260")
            .answerB("5270")
            .answerC("5280")
            .answerD("5290")
            .correctAnswer("C")
            .hint("The altitude of Denver, Colorado")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(1)
            .question("What was the first toy advertised on television?")
            .answerA("The Rubix Cube")
            .answerB("Mr. Potato Head")
            .answerC("Barbie")
            .answerD("A hula hoop")
            .correctAnswer("B")
            .hint("Use your head on this one")
            .lastUpdated(new Date())
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(2)
            .question("The martial art of kung fu originated in which country?")
            .answerA("Viet Nam")
            .answerB("United States")
            .answerC("Japan")
            .answerD("China")
            .correctAnswer("D")
            .hint("Name most likely derives from the name of the Qin dynasty")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(3)
            .question("Which 1979 film included a spaceship called Nostromo?")
            .answerA("The Emperor Strikes Back")
            .answerB("Alien")
            .answerC("The Black Hole")
            .answerD("Star Trek: The Motion Picture")
            .correctAnswer("B")
            .hint("Not from this world")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(4)
            .question("Which country lies on the border between Spain and France?")
            .answerA("Andorra")
            .answerB("Luxemborg")
            .answerC("England")
            .answerD("Portugal")
            .correctAnswer("A")
            .hint("Go with your first guess")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(5)
            .question("CERN launched the very first website in what year?")
            .answerA("1985")
            .answerB("1960")
            .answerC("1990")
            .answerD("1995")
            .correctAnswer("C")
            .hint("Not before Star Wars")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(6)
            .question("What is the largest animal currently on Earth?")
            .answerA("Elephant")
            .answerB("Polar Bear")
            .answerC("Blue Whale")
            .answerD("Box Jellifish")
            .correctAnswer("C")
            .hint("Stick to the seas")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(7)
            .question("What was first feature length animated film?")
            .answerA("Akira")
            .answerB("Snow White and the Seven Dwarfs")
            .answerC("Cinderella")
            .answerD("Bambi")
            .correctAnswer("B")
            .hint("Bad apples")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(8)
            .question("The assasination that is said to have lead to World War I, occured in what city?")
            .answerA("Paris")
            .answerB("Sarajevo")
            .answerC("Belgrade")
            .answerD("Rome")
            .correctAnswer("B")
            .hint("Go east")
            .lastUpdated(new Date())    
            .build()
        );
        questionList.add((new TriviaQuestionBuilder())
            .id(9)
            .question("World War I flying ace Manfred von Richthofen is known by what nickname?")
            .answerA("Snoopy")
            .answerB("Bob")
            .answerC("The Manchurian Candidate")
            .answerD("The Red Baron")
            .correctAnswer("D")
            .hint("Royalty")
            .lastUpdated(new Date())    
            .build()
        );
        
        questionList.add((new TriviaQuestionBuilder())
            .id(10)
            .question("The Lone Star State is the nickname for which U.S. State?")
            .answerA("California")
            .answerB("Colorado")
            .answerC("Texas")
            .answerD("Alaska")
            .correctAnswer("C")
            .hint("Don't 'mess' this one up")
            .lastUpdated(new Date())    
            .build()
        );
    }

}
