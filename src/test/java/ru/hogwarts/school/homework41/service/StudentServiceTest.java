package ru.hogwarts.school.homework41.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.hogwarts.school.homework41.model.Student;
import ru.hogwarts.school.homework41.repository.FacultyRepository;
import ru.hogwarts.school.homework41.repository.StudentRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StudentServiceTest {
    @Mock
    private StudentRepository repositoryMock;

    @Mock
    private FacultyRepository facultyRepository;

    private StudentService out;

    Student student1 = new Student(8L, "test", 99);

    @BeforeEach
    public void initOut() {
        out = new StudentService(repositoryMock, facultyRepository);
    }

    @Test
    void createStudent() {
        Mockito.when(repositoryMock.save(student1)).thenReturn(student1);
        assertThat(out.createStudent(student1)).isEqualTo(student1);
    }

    @Test
    void getStudent() {
        Mockito.when(repositoryMock.findStudentById(8L)).thenReturn(Optional.of(student1));
        assertThat(out.getStudent(8L)).isEqualTo(student1);
    }

    @Test
    void updateStudent() {
        Mockito.when(repositoryMock.save(student1)).thenReturn(student1);
        Mockito.when(repositoryMock.findStudentById(8L)).thenReturn(Optional.of(student1));
        Student student2 = new Student(8L, "test2", 34);
        out.updateStudent(student2);
        assertThat(out.getStudent(8L).getName()).isEqualTo("test2");
        assertThat(out.getStudent(8L).getAge()).isEqualTo(34);
    }

    /*@Test
    void deleteStudent() {
        Mockito.when(repositoryMock.save(student1)).thenReturn(student1);
        Mockito.when(repositoryMock.findStudentById(8L)).thenReturn(Optional.of(student1));
        assertThat(out.getStudent(8L)).isEqualTo(student1);
        out.deleteStudent(8L);
        assertThat(out.getStudent(8L)).isNull();
    }*/

    /*@Test
    void getStudentsByAge() {
        List<Student> expected = new ArrayList<>();
        Student student2 = new Student("test2", 34, null, null);
        Student student3 = new Student("test3", 1, null, null);
        expected.add(student3);
        Mockito.when(repositoryMock.save(student1)).thenReturn(student1);
        Mockito.when(repositoryMock.getStudentsByAge(1)).thenReturn(expected);
        out.createStudent(student1);
        out.createStudent(student2);
        out.createStudent(student3);
        assertThat(out.getStudentsByAge(1)).isEqualTo(expected);
    }

    @Test
    void findByAgeBetween() {
        List<Student> expected = new ArrayList<>();
        Student student2 = new Student("test2", 34, null, null);
        Student student3 = new Student("test3", 1, null, null);
        expected.add(student3);
        Mockito.when(repositoryMock.save(student1)).thenReturn(student1);
        Mockito.when(repositoryMock.findByAgeBetween(0, 10)).thenReturn(expected);
        out.createStudent(student1);
        out.createStudent(student2);
        out.createStudent(student3);
        assertThat(out.findByAgeBetween(0, 10)).isEqualTo(expected);
    }

    @Test
    void getFacultyById() {
        Student student2 = new Student("test2", 39, null, null);
        Faculty testFaculty = new Faculty(9L, "RandomFaculty", "black");
        student2.setFaculty(testFaculty);
        Mockito.when(repositoryMock.save(student2)).thenReturn(student2);
        Mockito.when(repositoryMock.findStudentById(88L)).thenReturn(Optional.of(student2));
        out.createStudent(student2);
        assertThat(out.getFacultyById(88L)).isEqualTo(testFaculty);
    }*/
}
