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

import java.util.List;

/**
 * Interface for the data access to a trivia question database.
 * 
 * @author DJ Spiess
 */
public interface TriviaQuestionAccessible {
    /**
     * Returns a {@link TriviaQuestion} by index.
     * 
     * @param index the index of the trivia question
     * @return an trivia question by index
     */
    TriviaQuestion getQuestionByIndex(long index);
    
    /**
     * Returns a {@link TriviaQuestion} by index.
     * 
     * @param id the identifier of the trivia question
     * @return an trivia question by index
     */
    TriviaQuestion getQuestionById(long id);
    
    /**
     * Returns a random {@link TriviaQuestion}
     * 
     * @return a random trivia question
     */
    TriviaQuestion getRandomQuestion();
    
    /**
     * Returns a list of at most 10 {@link TriviaQuestion} starting at the offset
     * 
     * @param offset the starting point
     * @return a list of at most 10 questions starting the offset
     */
    List<TriviaQuestion> getQuestionList(long offset);
    
    /**
     * Returns a list of at most 10 {@link TriviaQuestion} starting at the offset
     * 
     * @param id
     * @return a list of at most 10 questions starting the offset
     */
    List<TriviaQuestion> getSpecifiedQuestionList(long... id);
    
    /**
     * Returns the total number of {@link TriviaQuestion} in the database
     * 
     * @return the number of trivia questions
     */
    long getQuestionListSize();
}
