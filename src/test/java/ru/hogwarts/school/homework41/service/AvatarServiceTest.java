package ru.hogwarts.school.homework41.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.hogwarts.school.homework41.model.Avatar;
import ru.hogwarts.school.homework41.model.Student;
import ru.hogwarts.school.homework41.repository.AvatarRepository;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AvatarServiceTest {/*
    @Mock
    private AvatarRepository repositoryMock;
    private AvatarService out;
    private StudentService outStudent;
    private final byte[] arg = new byte[1024];
    private final Student student1 = new Student("test", 99, null, null);
    private final Avatar avatar1 = new Avatar(0L, "test1", 1, "jpeg", arg, student1);

    @BeforeEach
    public void initOut() {
        out = new AvatarService(repositoryMock, outStudent);
    }

    @Test
    void findAvatar() {
        Mockito.when(repositoryMock.findAvatarByStudentId(0L)).thenReturn(Optional.of(avatar1));
        assertThat(out.findAvatar(0L)).isEqualTo(avatar1);
    }

*/
}