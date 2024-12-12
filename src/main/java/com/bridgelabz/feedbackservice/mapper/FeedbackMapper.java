package com.bridgelabz.feedbackservice.mapper;


import com.bridgelabz.feedbackservice.model.Feedback;
import com.bridgelabz.feedbackservice.requestdto.FeedbackRequest;
import com.bridgelabz.feedbackservice.responsedto.FeedbackResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FeedbackMapper {

    public Feedback mapToFeedback(FeedbackRequest feedbackRequest, Feedback feedback) {
        feedback.setRating(feedbackRequest.getRating());
        feedback.setComment(feedbackRequest.getComment());
        feedback.setSubmittedDate(LocalDate.now());
        return feedback;
    }

    public FeedbackResponse mapToFeedbackResponse(Feedback feedback) {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setFeedbackId(feedback.getFeedbackId());
        feedbackResponse.setBookId(feedback.getBookId());
        feedbackResponse.setUserId(feedback.getUserId());
        feedbackResponse.setComment(feedback.getComment());
        feedbackResponse.setRating(feedback.getRating());
        feedbackResponse.setSubmittedDate(feedback.getSubmittedDate());
        return feedbackResponse;
    }
}