package spring.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.UserResponseDto;
import spring.model.User;
import spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return getFromUser(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getFromUser)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public void saveUsers() {
        User bob = new User();
        bob.setLogin("Bobby");
        bob.setPassword("123");
        userService.add(bob);
        User alice = new User();
        alice.setLogin("Alice");
        alice.setPassword("321");
        userService.add(alice);
        User frank = new User();
        frank.setLogin("Frank");
        frank.setPassword("1111");
        userService.add(frank);
        User john = new User();
        john.setLogin("John");
        john.setPassword("2222");
        userService.add(john);
    }

    private UserResponseDto getFromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setLogin(user.getLogin());
        return userResponseDto;
    }
}
