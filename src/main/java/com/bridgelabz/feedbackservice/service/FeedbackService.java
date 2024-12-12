package com.bridgelabz.feedbackservice.service;

import com.bridgelabz.feedbackservice.mapper.FeedbackMapper;
import com.bridgelabz.feedbackservice.model.Feedback;
import com.bridgelabz.feedbackservice.repository.FeedbackRepository;
import com.bridgelabz.feedbackservice.requestdto.FeedbackRequest;
import com.bridgelabz.feedbackservice.responsedto.FeedbackResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {

    private FeedbackMapper feedbackMapper;
    private FeedbackRepository feedbackRepo;


    public FeedbackResponse submitFeedback(long userId, long bookId, FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackMapper.mapToFeedback(feedbackRequest,new Feedback());
        feedback.setUserId(userId);
        feedback.setBookId(bookId);
        feedback = feedbackRepo.save(feedback);
        return feedbackMapper.mapToFeedbackResponse(feedback);
    }


    public List<FeedbackResponse> getFeedbackForBook(Long bookId) {
        return feedbackRepo.findAllByBookId(bookId)
                .stream()
                .map(feedback ->
                        feedbackMapper.mapToFeedbackResponse(feedback)).toList();
    }
}
