package exercise;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts") // список всех постов
    public ResponseEntity<List<Post>> index(@RequestParam(defaultValue = "10") Integer limit) {
        //return posts.stream().limit(limit).toList();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts.stream().limit(limit).toList());
    }

    @GetMapping("/posts/{id}") // просмотр конкретного поста
    public ResponseEntity<Post> show(@PathVariable String id) {
        var page = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        //return page;
        return ResponseEntity.of(page);
    }

    @PostMapping("/posts") // создание нового поста
    public ResponseEntity<Post> create(@RequestBody Post page) {
        posts.add(page);
        //return page;
        return ResponseEntity.status(201).body(page);
    }

    @PutMapping("/posts/{id}") // обновление поста
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        var maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePost.isPresent()) {
            var post = maybePost.get();
            post.setId(data.getId());
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
            return ResponseEntity.ok().body(data);
        }
        else {
            return ResponseEntity.status(204).body(data);
        }
    }

    @DeleteMapping("/posts/{id}") // удаление поста
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
    // END
}
