package noroff.mefit.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Column(name="image_url", nullable = true)
    private String imageURL;

    @Column(name="repetitions", nullable = true)
    private int repetitions;

    @Column(name="sets", nullable = true)
    private int sets;

    @ManyToMany(mappedBy = "exercises")
    private Set<Workout> workouts;
}
