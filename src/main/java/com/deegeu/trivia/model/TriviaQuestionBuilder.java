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

import java.util.Date;
import java.util.HashSet;

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
        if ((id < 0) 
                || ("".equals(this.question) || this.question.trim().isEmpty())
                || ("".equals(this.answerA) || this.answerA.trim().isEmpty())
                || ("".equals(this.answerB) || this.answerB.trim().isEmpty())
                || ("".equals(this.answerC) || this.answerC.trim().isEmpty())
                || ("".equals(this.answerD) || this.answerD.trim().isEmpty())
                || ("".equals(this.correctAnswer) || this.correctAnswer.trim().isEmpty())
                || ("".equals(this.hint) || this.hint.trim().isEmpty())
                || (this.lastUpdated == null)
                ) {
            throw new IllegalStateException("TriviaQuestion builder not in buildable state.");
        }
        
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
        if (id < 0) {
            throw new IllegalArgumentException("Id can't be less than 0");
        }
        this.id = id;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#question} 
     * @param question the trivia question for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder question(String question) {
        if (question == null || question.trim().isEmpty()) {
           throw new IllegalArgumentException("Question cannot be null or empty."); 
        }
        this.question = question;
        return this;
    }
     
    /**
     * Setter for {@link TriviaQuestionBuilder#answerA} 
     * @param answerA the first possible answer for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerA(String answerA) {
        if (answerA == null || answerA.trim().isEmpty()) {
           throw new IllegalArgumentException("Answer A cannot be null or empty."); 
        }
        this.answerA = answerA;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#answerB} 
     * @param answerB the second possible answer for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerB(String answerB) {
        if (answerB == null  || answerB.trim().isEmpty()) {
           throw new IllegalArgumentException("Answer B cannot be null or empty."); 
        }
        this.answerB = answerB;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#answerC} 
     * @param answerC the unique id for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerC(String answerC) {
        if (answerC == null  || answerC.trim().isEmpty()) {
           throw new IllegalArgumentException("Answer C cannot be null or empty."); 
        }
        this.answerC = answerC;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#answerD} 
     * @param answerD the unique id for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder answerD(String answerD) {
        if (answerD == null  || answerD.trim().isEmpty()) {
           throw new IllegalArgumentException("Answer D cannot be null or empty."); 
        }
        this.answerD = answerD;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#correctAnswer} 
     * @param correctAnswer the correct answer for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder correctAnswer(String correctAnswer) {
        if (correctAnswer == null  || correctAnswer.trim().isEmpty()) {
           throw new IllegalArgumentException("Correct answer cannot be null or empty."); 
        }
        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        if (!set.contains(correctAnswer)) {
           throw new IllegalArgumentException("Correct answer must be 'A', 'B', 'C' or 'D'."); 
        }
        this.correctAnswer = correctAnswer;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#hint} 
     * @param hint the hint for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder hint(String hint) {
        if (hint == null  || hint.trim().isEmpty()) {
           throw new IllegalArgumentException("Hint cannot be null or empty."); 
        }
        this.hint = hint;
        return this;
    }
    
    /**
     * Setter for {@link TriviaQuestionBuilder#lastUpdated} 
     * @param lastUpdated the date the question was last updated for the {@link TriviaQuestion}
     * @return a {@link TriviaQuestionBuilder} instance
     */
    public TriviaQuestionBuilder lastUpdated(Date lastUpdated) {
        if (lastUpdated == null) {
           throw new IllegalArgumentException("Date cannot be null."); 
        }
        this.lastUpdated = lastUpdated;
        return this;
    }
}
