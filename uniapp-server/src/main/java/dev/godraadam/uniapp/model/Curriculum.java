package dev.godraadam.uniapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curricula")
@Getter
@Setter
public class Curriculum extends BaseModel {
    
    private String title;

    @OneToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @OneToMany(mappedBy = "curriculum")
    private List<Laboratory> laboratories;

    @OneToMany(mappedBy = "curriculum")
    private List<Enrollment> enrollments;

}
