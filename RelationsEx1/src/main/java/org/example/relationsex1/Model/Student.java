package org.example.relationsex1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String name;
    @NotEmpty(message = "major should be not empty")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String major ;
    @NotNull(message = "age should be not empty")
    @Column(columnDefinition = "int not null ")
    private Integer age;
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
