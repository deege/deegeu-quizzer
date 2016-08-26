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
import java.util.Objects;

/**
 * Represents a trivia question. This class is immutable and should be created by
 * the builder {@link TriviaQuestionBuilder}.
 * 
 * @author dspiess
 */
final public class TriviaQuestion {
    final private long id;
    final private String question;
    final private String answerA;
    final private String answerB;
    final private String answerC;
    final private String answerD;
    final private String correctAnswer;
    final private String hint;
    final private Date lastUpdated;
    
    /**
     * Constructor. Intentionally package scope. This class should be created by
     * the builder {@link TriviaQuestionBuilder}.
     * 
     * @param id
     * @param question
     * @param answerA
     * @param answerB
     * @param answerC
     * @param answerD
     * @param correctAnswer
     * @param hint 
     */
    TriviaQuestion(long id, String question, 
            String answerA, String answerB, String answerC, String answerD,
            String correctAnswer, String hint, Date lastUpdated) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.lastUpdated = new Date(lastUpdated.getTime());
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return the answerA
     */
    public String getAnswerA() {
        return answerA;
    }

    /**
     * @return the answerB
     */
    public String getAnswerB() {
        return answerB;
    }

    /**
     * @return the answerC
     */
    public String getAnswerC() {
        return answerC;
    }

    /**
     * @return the answerD
     */
    public String getAnswerD() {
        return answerD;
    }

    /**
     * @return the correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }
    
    /**
     * @return the date this question was last updated
     */
    public Date getLastUpdated() {
        return new Date(this.lastUpdated.getTime());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.question);
        hash = 71 * hash + Objects.hashCode(this.answerA);
        hash = 71 * hash + Objects.hashCode(this.answerB);
        hash = 71 * hash + Objects.hashCode(this.answerC);
        hash = 71 * hash + Objects.hashCode(this.answerD);
        hash = 71 * hash + Objects.hashCode(this.correctAnswer);
        hash = 71 * hash + Objects.hashCode(this.hint);
        hash = 71 * hash + Objects.hashCode(this.lastUpdated);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TriviaQuestion other = (TriviaQuestion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answerA, other.answerA)) {
            return false;
        }
        if (!Objects.equals(this.answerB, other.answerB)) {
            return false;
        }
        if (!Objects.equals(this.answerC, other.answerC)) {
            return false;
        }
        if (!Objects.equals(this.answerD, other.answerD)) {
            return false;
        }
        if (!Objects.equals(this.correctAnswer, other.correctAnswer)) {
            return false;
        }
        if (!Objects.equals(this.hint, other.hint)) {
            return false;
        }
        if (!Objects.equals(this.lastUpdated, other.lastUpdated)) {
            return false;
        }
        return true;
    }
}
