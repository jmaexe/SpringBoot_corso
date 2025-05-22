package com.demo.tutorial.feedback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tutorial.person.Person;
import com.demo.tutorial.person.PersonService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    private PersonService personService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllFeedbacks() {
        List<Feedback> lista = feedbackService.getAll();
        for (Feedback feedback : lista) {
            System.out.println("Feedback: " + feedback.getUserId());
        }
        if (lista.isEmpty()) {
            return new ResponseEntity<String>("lista vuota", HttpStatus.OK);
        }

        return new ResponseEntity<List<Feedback>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getFeedbackById(@PathVariable Long id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback == null) {
            return new ResponseEntity<String>("Not found with this id :" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Found " + feedback, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFeedbackById(@PathVariable Long id, @RequestBody FeedbackDTO feedbackDTO) {
        Feedback f = feedbackService.getFeedbackById(id);
        if (f == null) {
            return new ResponseEntity<String>("Not found with this id :" + id, HttpStatus.NOT_FOUND);
        }
        if (feedbackDTO.getCommento().isEmpty()) {
            feedbackDTO.setCommento(f.getCommento());
        }
        Person p = personService.findById(feedbackDTO.getUserId());
        feedbackService.updateFeedback(id, feedbackDTO.getCommento(), p);
        return new ResponseEntity<String>("Edited feedback " + id + " with new values ", HttpStatus.OK);
    }

    @PostMapping("/add-feedback")
    public ResponseEntity<String> addFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        // Person p = personService.getPersonPerId(feedbackDTO.getUserId());
        Person p = personService.findById(feedbackDTO.getUserId());
        if (p == null) {
            return new ResponseEntity<String>("Dati feedback errati!" + feedbackDTO, HttpStatus.BAD_REQUEST);
        }
        Feedback feedback = new Feedback(p, feedbackDTO.getCommento());
        feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok("Feedback aggiunto !");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        Feedback f = feedbackService.getFeedbackById(id);
        if (f == null) {
            return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
        }
        feedbackService.deleteById(id);
        return ResponseEntity.ok("Feedback " + id + " eliminato !");
    }

}
