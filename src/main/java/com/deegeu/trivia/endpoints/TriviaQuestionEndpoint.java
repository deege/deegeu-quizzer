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
package com.deegeu.trivia.endpoints;

import com.deegeu.trivia.model.TriviaQuestion;
import com.deegeu.trivia.model.TriviaQuestionAccessible;
import com.deegeu.trivia.model.TriviaQuestionArrayAccess;
import java.util.Date;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST endpoint for trivia questions. This supports random trivia questions, a list of 
 * 10 questions, a random question, and a question count.
 * 
 * @author DJ Spiess
 */
@Path("/questions")
final public class TriviaQuestionEndpoint {
 
    final private Date questionsUpdatedDate = new Date();
    final private TriviaQuestionAccessible dataAccess = new TriviaQuestionArrayAccess();
    private static final int STARTING_OFFSET = 0;
    private static final int PAGE_SIZE = 4;
    
    /**
     * Returns a list of at most 10 questions. The optional query parameter offset
     * tells the method where in the list to start. If there are less than 10 
     * questions in the list from the offset point, only the remaining questions 
     * will be returned. If the offset is negative, the offset will start at 0. If 
     * the offset is greater than the list size, an empty list will be returned. The
     * header contains the list size, the number of questions returned, and the 
     * total number of questions.
     * 
     * @param uri
     * @param offset the starting point to get questions in list
     * @return at most 10 questions starting at the offset as JSON in a HTTP response 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getQuestions(@Context UriInfo uri, 
            @QueryParam("offset") @DefaultValue("0") long offset)  {
        // Calculate the effective offset
        long datasetSize = dataAccess.getQuestionListSize();
        long start = offset; 
        if (start < STARTING_OFFSET) {
            start = STARTING_OFFSET;
        }
        if (start >= datasetSize) {
            start = datasetSize;
        }
        
        // Setup navigation links
        Link selfLink = Link.fromUri(uri.getBaseUri() + "questions?offset={offset}")
                .rel("self").type(MediaType.APPLICATION_JSON)
                .build(offset);
        long nextOffset = (offset + PAGE_SIZE < datasetSize) 
                ? offset + PAGE_SIZE : PAGE_SIZE * (datasetSize / PAGE_SIZE);
        Link nextLink = Link.fromUri(uri.getBaseUri() + "questions?offset={offset}")
                .rel("next").type(MediaType.APPLICATION_JSON)
                .build(nextOffset);
        long prevOffset = (offset - PAGE_SIZE > STARTING_OFFSET) ? offset - PAGE_SIZE : STARTING_OFFSET;
        Link prevLink = Link.fromUri(uri.getBaseUri() + "questions?offset={offset}")
                .rel("prev").type(MediaType.APPLICATION_JSON)
                .build(prevOffset);
        Link firstLink = Link.fromUri(uri.getBaseUri() + "questions?offset={offset}")
                .rel("first").type(MediaType.APPLICATION_JSON)
                .build(STARTING_OFFSET);
        Link lastLink = Link.fromUri(uri.getBaseUri() + "questions?offset={offset}")
                .rel("last").type(MediaType.APPLICATION_JSON)
                .build(PAGE_SIZE * (datasetSize / PAGE_SIZE));
        Link countLink = Link.fromUri(uri.getBaseUri() + "questions/count")
                .rel("count").type(MediaType.APPLICATION_JSON)
                .build(); 
        Link rndLink = Link.fromUri(uri.getBaseUri() + "questions/random")
                .rel("random").type(MediaType.APPLICATION_JSON)
                .build();
        
        // Get the list of questions from starting point
        List<TriviaQuestion> list = dataAccess.getQuestionList(start);
        return Response.ok(list)
                       .header("question-count", datasetSize)
                       .header("current-question-list-size", list.size())
                       .header("offset", start)
                       .links(selfLink, nextLink, prevLink, firstLink, lastLink, 
                               countLink, rndLink)
                       .lastModified(questionsUpdatedDate)
                       .location(uri.getRequestUri())
                       .build();
    }
        
    /**
     * Returns the total number of trivia questions in the database.
     * 
     * @param uri
     * @return the question count as JSON in a HTTP response
     */
    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getQuestionCount(@Context UriInfo uri) {
        long numberOfQuestions = dataAccess.getQuestionListSize();
        return Response.ok(numberOfQuestions)
                       .header("question-count", numberOfQuestions)
                       .lastModified(questionsUpdatedDate)
                       .location(uri.getRequestUri())
                       .build();
    }
    
    /**
     * Returns a single question by id. If the query parameter is "random", a
     * random question is returned. If the id is not found, 404 is returned. If
     * the id cannot be parsed, 400 is returned.
     * 
     * @param uri
     * @param idString either an identifier or the word "random"
     * @return the question by id as JSON in a HTTP response
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestion(@Context UriInfo uri, 
            @PathParam("id") String idString) {
        Response response;
        if (idString.trim().equalsIgnoreCase("random")) {
            TriviaQuestion question = dataAccess.getRandomQuestion();
            response = Response.ok(question)
                               .lastModified(question.getLastUpdated())
                               .location(uri.getRequestUri())
                               .build();
        } else {
            try {
                long identifier = Long.parseLong(idString);
                if (identifier >= dataAccess.getQuestionListSize()) {
                    response = Response.status(Response.Status.NOT_FOUND).build();    
                } else {
                    TriviaQuestion question = dataAccess.getQuestionById(identifier);
                    response = Response.ok(question)
                            .lastModified(question.getLastUpdated())
                            .location(uri.getRequestUri())
                            .build();
                }
            } catch (NumberFormatException ne) {
                response = Response.status(Response.Status.BAD_REQUEST).build();
            }
            
        }
        return response;
    }
}
