package com.demo.tutorial.feedback;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class FeedbackService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveFeedback(Feedback feedback) {
        entityManager.persist(feedback);
    }

    @Transactional
    public void saveAll(List<Feedback> feedbacks) {
        for (Feedback feedback : feedbacks) {
            entityManager.persist(feedback);
        }
    }

    public Feedback getFeedbackById(Long id) {
        Feedback query = entityManager.find(Feedback.class, id);
        return query;
    }

    public List<Feedback> getAll() {
        TypedQuery<Feedback> query = entityManager.createQuery("SELECT f FROM Feedback f", Feedback.class);
        System.out.println("query result : " + query);
        return query.getResultList();
    }

    @Transactional
    public void updateFeedback(Feedback updatedfeedback) {
        Feedback feedback = entityManager.find(Feedback.class, updatedfeedback.getId());
        feedback.setCommento(updatedfeedback.getCommento());
        feedback.setPerson(updatedfeedback.getPerson());
        entityManager.merge(feedback);
    }
}