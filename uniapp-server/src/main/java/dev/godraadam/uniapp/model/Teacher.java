package dev.godraadam.uniapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher extends ApplicationUser {
    
    @OneToOne(mappedBy = "teacher")
    private Curriculum curriculum;
    private Role role = Role.TEACHER;
}
