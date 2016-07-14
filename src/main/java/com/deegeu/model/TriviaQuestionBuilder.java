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
package com.deegeu.model;

import java.util.Date;

/**
 * Builder class for the {@link TriviaQuestion} class.
 * 
 * @author DJ Spiess
 */
public class TriviaQuestionBuilder {
    private long id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    private String hint;
    private Date lastUpdated;
    
    /**
     * Empty constructor
     */
    public TriviaQuestionBuilder() {
        // empty
    }
    
    /** 
     * Builder for {@link TriviaQuestion}
     * 
     * @return a {@link TriviaQuestion} instance.
     */
    public TriviaQuestion build() {
        return new TriviaQuestion(
                this.id, 
                this.question,
                this.answerA,
                this.answerB,
                this.answerC,
                this.answerD,
                this.correctAnswer,
                this.hint,
                this.lastUpdated
        );
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#id} 
     * @param id the unique id for the {@link TriviaQuestion}
     * @return 
     */
    public TriviaQuestionBuilder id(long id) {
        this.id = id;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#question} 
     * @param question the trivia question for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder question(String question) {
        this.question = question;
        return this;
    }
     
    /**
     * Setter for {@link TriviaQuestionBuilder#answerA} 
     * @param answerA the first possible answer for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerA(String answerA) {
        this.answerA = answerA;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#answerB} 
     * @param answerB the second possible answer for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerB(String answerB) {
        this.answerB = answerB;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#answerC} 
     * @param answerC the unique id for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerC(String answerC) {
        this.answerC = answerC;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#answerD} 
     * @param answerD the unique id for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerD(String answerD) {
        this.answerD = answerD;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#correctAnswer} 
     * @param correctAnswer the correct answer for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder correctAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#hint} 
     * @param hint the hint for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder hint(String hint) {
        this.hint = hint;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#lastUpdated} 
     * @param lastUpdated the date the question was last updated for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder lastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }
}
