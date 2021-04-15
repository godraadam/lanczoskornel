package dev.godraadam.uniapp.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "laboratories")
@Getter
@Setter
public class Laboratory extends BaseModel {
    
    private Integer number;
    private String title;
    private LocalDateTime date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "CURRICULUM_ID")
    private Curriculum curriculum;

    @OneToMany(mappedBy = "laboratory")
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "laboratory")
    private List<Attendance> attendances;
}
