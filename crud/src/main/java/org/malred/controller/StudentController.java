package org.malred.controller;

import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;
import org.malred.model.Student;
import org.malred.repository.StudentRepository;

import java.util.Optional;

@Controller(value = "/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository student;

    @Get("/all")
    public Iterable<Student> all() {
        return student.findAll();
    }

    @Post("/create")
    public Student createWithBody(@Body Student student) {
        return this.student.save(student);
    }

    @Put("/update")
    public Student updateWithBody(@Body Student student) {
        Optional<Student> studentByRoll = this.student.findById(student.getRoll());
        Student entity = studentByRoll.get();
        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        entity.setStandard(student.getStandard());
        return this.student.update(entity);
    }

    @Delete("/delete")
    public Iterable<Student> deleteWithBody(@Body Student student) {
        Optional<Student> studentByRoll = this.student.findById(student.getRoll());
        Student entity = studentByRoll.get();
        this.student.delete(entity);
        return this.student.findAll();
    }
}
