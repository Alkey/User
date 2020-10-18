import com.user.config.AppConfig;
import com.user.model.User;
import com.user.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User bob = new User();
        bob.setLogin("Bobby");
        bob.setPassword("123");
        userService.add(bob);
        User alice = new User();
        alice.setLogin("Alice");
        alice.setPassword("321");
        userService.add(alice);
        userService.listUsers().forEach(System.out::println);
    }
}
