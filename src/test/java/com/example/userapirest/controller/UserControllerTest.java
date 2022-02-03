package com.example.userapirest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.userapirest.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.example.userapirest"})
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest  {
    @MockBean
    private UserController userController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        User user = this.obtenerObjeto();

        Mockito.when(userController.getAllUsers())
                .thenReturn((ResponseEntity<List<User>>) Collections.singletonList(user));

        this.mockMvc.perform(get("/users/list-users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    private User obtenerObjeto() {
        User user = new User();
        user.setUser_id(1L);
        user.setName("Juan Pérez");
        user.setEmail("test@mockito.com");
        user.setPassword("123456");

        return user;
    }
}