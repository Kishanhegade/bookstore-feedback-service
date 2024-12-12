package com.bridgelabz.feedbackservice.responsedto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FeedbackResponse {

    private Long feedbackId;
    private long userId;
    private long bookId;
    private int rating;
    private String comment;
    private LocalDate submittedDate;
}
