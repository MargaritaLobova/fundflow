package server;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
  private final UsersRepository repository;

  public UsersController(UsersRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/users")
  List<User> all() {
    return repository.findAll();
  }

  @PostMapping("/users")
  User newUser(@RequestBody User newUser) {
    return repository.save(newUser);
  }

  @GetMapping("/users/{id}")
  User one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/users/{id}")
  User replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {
    return repository.findById(id).map(user -> {
      user.setLogin(newUser.getLogin());
      user.setRole(newUser.getRole());
      user.setPassword(newUser.getPassword());
      return repository.save(user);
    })
        .orElseGet(() -> {
          newUser.setId(id);
          return repository.save(newUser);
        });
  }

  @DeleteMapping("/users/{id}")
  void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
