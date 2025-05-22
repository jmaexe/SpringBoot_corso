package com.demo.tutorial.feedback;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.tutorial.person.Person;
import jakarta.transaction.Transactional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public void saveAll(List<Feedback> feedbacks) {
        for (Feedback feedback : feedbacks) {
            feedbackRepository.save(feedback);
        }
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    public void updateFeedback(Long id, String commento, Person person) {
        feedbackRepository.save(new Feedback(id, person, commento));
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }

}