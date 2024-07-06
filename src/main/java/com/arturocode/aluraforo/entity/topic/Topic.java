package com.arturocode.aluraforo.entity.topic;

import com.arturocode.aluraforo.entity.course.Course;
import com.arturocode.aluraforo.entity.response.Response;
import com.arturocode.aluraforo.entity.user.User;
import com.arturocode.aluraforo.util.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Response> responses;


    public Topic(DataRegisterTopic dataRegisterTopic) {
        this.title = dataRegisterTopic.title();
        this.message = dataRegisterTopic.message();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        this.creationDate = LocalDateTime.parse(formattedDateTime, formatter);
        this.status = Status.OPEN;
    }

    public void updateTopic(DataUpdateTopic dataUpdateTopic, Course course, User user) {
        if (dataUpdateTopic.title() != null) {
            this.title = dataUpdateTopic.title();
        }

        if (dataUpdateTopic.message() != null) {
            this.message = dataUpdateTopic.message();
        }
        if (dataUpdateTopic.status() != null) {
            this.status = Status.fromString(dataUpdateTopic.status());
        }

        if (user != null) {
            this.user = user;
        }

        if (course != null) {
            this.course = course;
        }
    }
}