package com.example.spid.postgres.demo.service;

import com.example.spid.postgres.demo.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    @Mock
    UserService userService;

    @BeforeAll
    void setUp() throws Exception {
        User user = new User();
        user.setId(1);

        when(userService.getUserById(1)).thenReturn(Optional.of(user));
        when(userService.getUserById(anyInt())).thenThrow(new RuntimeException("Exception"));
    }

    @Test
    public void testDatabase() {
        assertInstanceOf(User.class, userService.getUserById(1).get());
        assertThrows(Exception.class, () -> userService.getUserById(2).get());
    }
}