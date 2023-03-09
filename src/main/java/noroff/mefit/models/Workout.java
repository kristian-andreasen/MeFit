package noroff.mefit.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String type;

    @Column(length = 5, nullable = false)
    private boolean complete;

    @ManyToMany(mappedBy = "workouts")
    private Set<Program> programs;

    @ManyToMany(mappedBy = "workouts")
    private Set<Goal> goals;

    @ManyToMany
    @JoinTable(
            name = "workout_set",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "set_id")
    )
    private Set<noroff.mefit.models.Set> sets ;




}