package maven.maven_pjt.biz.note;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import maven.maven_pjt.biz.note.entity.Note;
import maven.maven_pjt.biz.user.UserService;
import maven.maven_pjt.biz.user.dto.UserRequestDto;
import maven.maven_pjt.biz.user.dto.UserSignInDto;
import maven.maven_pjt.biz.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NoteControllerTest{
    @InjectMocks
    private NoteController noteController;

    @Mock
    private NoteService noteService;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
    }

    @DisplayName("전체 게시글 조회")
    @Test
    void getAllNotesSuccess() throws Exception {
        User user = User.builder()
                .userId("kyong0409")
                .id(3)
                .email("kyong0409@mail.com")
                .name("kyong")
                .password("1234")
                .department("ktwiz")
                .lastChangeDate(LocalDate.now())
                .rankName("M1")
                .startDate(LocalDate.now())
                .useAccount(false)
                .authority("ROLE_USER")
                .build();

        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userId(user.getUserId())
                .password(user.getPassword())
                .build();

        Note firstNote = Note.builder()
                .title("첫 번째 가짜노트")
                .content("가짜지롱")
                .userId(3)
                .build();

        Note secondNote = Note.builder()
                .title("두 번째 가짜노트")
                .content("진짜지롱")
                .userId(3)
                .build();

        ResultActions actions = mockMvc.perform(
                MockMvcRequestBuilders.get("/notes")
                        .header("X-AUTH-TOKEN", userService.login(userRequestDto).getAccessToken())
        );

        MvcResult result = actions.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        List<Note> response = new Gson().fromJson(result.getResponse().getContentAsString());

        Assertions.assertThat()
    }
}
