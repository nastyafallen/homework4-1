package ru.hogwarts.school.homework41;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.homework41.controller.StudentController;
import ru.hogwarts.school.homework41.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Homework41ApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    void createGetUpdateDeleteStudent() throws Exception{
        Student student = new Student(8L, "test", 99);
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, Student.class))
                .isEqualTo(student);
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/find?id=" + student.getId(), Student.class))
                .isEqualTo(student);
        student.setName("test2");
        student.setAge(88);
        this.restTemplate.put("http://localhost:" + port + "/student", student);
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/find?id=" + student.getId(), Student.class))
                .isEqualTo(student);
        this.restTemplate.delete("http://localhost:" + port + "/student/" + student.getId());
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/find?id=" + student.getId(), Student.class))
                .isNull();
    }

    /*@Test
    void getStudentsByAgeAndFindByAgeBetween() {
        Student student = new Student("test", 10, null, null);
        student.setId(10L);
        this.restTemplate.postForObject("http://localhost:" + port + "/student", student, Student.class);
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/filter?age=10", List.class))
                .isNotEmpty();
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student?age1=10&age2=11", List.class))
                .isNotEmpty();
        this.restTemplate.delete("http://localhost:" + port + "/student/" + student.getId());
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/find?id=" + student.getId(), Student.class))
                .isNull();

    }

    @Test
    void getFacultyById() {
        Student student = new Student(1L, "test", 10);
        Faculty faculty = new Faculty(1L, "Random", "Random");
        student.setFaculty(faculty);
        this.restTemplate.postForObject("http://localhost:" + port + "/student", student, Student.class);
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/1/faculty", Faculty.class))
                .isEqualTo(faculty);
    }
*/
}
