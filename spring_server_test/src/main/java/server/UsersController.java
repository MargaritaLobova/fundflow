package server;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
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
  private final UserModelAssembler assembler;

  public UsersController(UsersRepository repository, UserModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/users")
  CollectionModel<EntityModel<User>> all() {

    List<EntityModel<User>> users = repository.findAll().stream()
        .map(assembler::toModel).collect(Collectors.toList());

    return CollectionModel.of(users, linkTo(methodOn(UsersController.class).all()).withSelfRel());
  }

  @PostMapping("/users")
  User newUser(@RequestBody User newUser) {
    return repository.save(newUser);
  }

  @GetMapping("/users/{id}")
  EntityModel<User> one(@PathVariable Long id) {
    User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

    return assembler.toModel(user);
  }

  @PutMapping("/users/{id}")
  ResponseEntity<?> replaceUser(@RequestBody User newUser, @PathVariable Long id) {
  User updatedUser = repository.findById(id).map(user -> {
      user.setLogin(newUser.getLogin());
      user.setRole(newUser.getRole());
      user.setPassword(newUser.getPassword());
      return repository.save(user);
    })
        .orElseGet(() -> {
          newUser.setId(id);
          return repository.save(newUser);
        });

    EntityModel<User> entityModel = assembler.toModel(updatedUser);

    return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @DeleteMapping("/users/{id}")
  ResponseEntity<?> deleteUser(@PathVariable Long id) {
    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
