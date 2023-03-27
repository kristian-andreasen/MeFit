package noroff.mefit.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "workouts")
    private Set<Program> programs;

    @ManyToMany(mappedBy = "workouts")
    private Set<Goal> goals;

    @ManyToMany
    @JoinTable(
            name = "workout_exercise",
            joinColumns = {@JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "exercise_id")}
    )
    private Set<Exercise> exercises;

    @JsonGetter("programs")
    public List<Integer> jsonGetPrograms(){
        if(programs!= null){
            return programs.stream().map(s -> s.getId())
                    .collect(Collectors.toList());
        }
        return null;
    }

    @JsonGetter("goals")
    public List<Integer> jsonGetGoals(){
        if(goals!= null){
            return goals.stream().map(s -> s.getId())
                    .collect(Collectors.toList());
        }
        return null;
    }
}
