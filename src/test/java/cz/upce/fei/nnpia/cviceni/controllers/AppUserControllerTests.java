package cz.upce.fei.nnpia.cviceni.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.upce.fei.nnpia.cviceni.entities.AppUser;
import cz.upce.fei.nnpia.cviceni.service.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AppUserController.class)
class AppUserControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AppUserService appUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllAppUser() throws Exception {
        AppUser user1 = new AppUser(1L, "user1", "password1", true, LocalDateTime.now(), LocalDateTime.now(), null, null);
        AppUser user2 = new AppUser(2L, "user2", "password2", true, LocalDateTime.now(), LocalDateTime.now(), null, null);
        List<AppUser> userList = Arrays.asList(user1, user2);

        when(appUserService.getAllObjects()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/app-user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].username").value("user1"))
                .andExpect(jsonPath("$[1].username").value("user2"));
    }

    @Test
    void testGetAppUserById() throws Exception {
        AppUser user = new AppUser(1L, "user1", "password1", true, LocalDateTime.now(), LocalDateTime.now(), null, null);

        when(appUserService.getObjectById(1L)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/app-user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("user1"));
    }

    @Test
    void testCreateUser() throws Exception {
        AppUser newUser = new AppUser(null, "newUser", "newPassword", true, LocalDateTime.now(), LocalDateTime.now(), null, null);

        mockMvc.perform(MockMvcRequestBuilders.post("/app-user/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
