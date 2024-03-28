package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api/users")
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/{id}/posts")
    //public String index() { /* код */ };

    public ResponseEntity<List<Post>> show(@PathVariable int id) {
        var page = posts.stream().filter(p -> p.getUserId() == id).toList();
        //var page = posts.stream().filter(p -> p.getUserId() == Integer.valueOf(id)).toList();
        //var page = posts.stream().filter(p -> p.getUserId().equals(id));
        //        .findFirst();
        //return page;
        return ResponseEntity.ok().body(page);
    }

    @PostMapping("/{id}/posts") // создание нового поста
    public ResponseEntity<Post> create(@PathVariable int id, @RequestBody Post data) {
        data.setUserId(id);
        posts.add(data);
        //return page;
        return ResponseEntity.status(201).body(data);
    }
}
// END
