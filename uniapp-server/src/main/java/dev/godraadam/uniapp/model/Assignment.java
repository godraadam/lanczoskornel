package dev.godraadam.uniapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "assignments")
@Getter
@Setter
public class Assignment extends BaseModel {
    
    @ManyToOne
    @JoinColumn(name = "LAB_ID", nullable = false)
    private Laboratory laboratory;
    private LocalDateTime deadline;
    private String description;
}
