package com.blessy.attendance.model;

import com.blessy.application.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance_register")
public class AttendanceRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate start_date;

    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate end_date;
}
