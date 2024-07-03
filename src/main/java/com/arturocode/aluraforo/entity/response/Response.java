package com.arturocode.aluraforo.entity.response;

import com.arturocode.aluraforo.entity.user.User;
import com.arturocode.aluraforo.entity.topic.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    private String solution;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

}