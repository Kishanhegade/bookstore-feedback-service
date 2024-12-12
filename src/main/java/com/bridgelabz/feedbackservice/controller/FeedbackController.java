package com.bridgelabz.feedbackservice.controller;


import com.bridgelabz.feedbackservice.requestdto.FeedbackRequest;
import com.bridgelabz.feedbackservice.responsedto.FeedbackResponse;
import com.bridgelabz.feedbackservice.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity<FeedbackResponse> submitFeedback(@RequestHeader("userId") String authHeader,
                                                           @RequestParam long bookId,
                                                           @RequestBody FeedbackRequest feedbackRequest) {

        long userId = Long.parseLong(authHeader);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.submitFeedback(userId, bookId, feedbackRequest));
    }

    @GetMapping("/feedback/{bookId}")
    public ResponseEntity<List<FeedbackResponse>> getFeedbackForBook(@PathVariable long bookId) {
        List<FeedbackResponse> feedback = feedbackService.getFeedbackForBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(feedback);
    }

}
