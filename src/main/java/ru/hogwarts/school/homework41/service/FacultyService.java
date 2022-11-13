package ru.hogwarts.school.homework41.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.homework41.exception.FacultyNotFoundException;
import ru.hogwarts.school.homework41.model.Faculty;
import ru.hogwarts.school.homework41.model.Student;
import ru.hogwarts.school.homework41.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> getFaculty(long id) {
        return facultyRepository.findById(id);
    }

    public Faculty updateFaculty(Faculty faculty) {
        Faculty oldFaculty = facultyRepository.findById(faculty.getId())
                .orElseThrow(FacultyNotFoundException::new);
        oldFaculty.setColor(faculty.getColor());
        oldFaculty.setName(faculty.getName());
        return facultyRepository.save(oldFaculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> getFacultiesByColor(String color) {
        return facultyRepository.getFacultiesByColor(color);
    }

    public Faculty findByNameOrColor(String name) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, name);
    }

    public Set<Student> getStudentsById(Long id) {
        Optional<Faculty> optional = facultyRepository.findById(id);
        if (optional.isPresent()) {
            Faculty facultyFromDb = optional.get();
            return facultyFromDb.getStudents();
        } else {
            return null;
        }
    }

}
