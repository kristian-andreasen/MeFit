package noroff.mefit.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
public class Profile {
    @Id
    @Column(length = 100, nullable = false)
    private String id;
    @Column(length = 60, nullable = true)
    private String email;
    @Column(nullable = true)
    private String role;
    @Column(length = 50, nullable = true)
    private String first_name;
    @Column(length = 50, nullable = true)
    private String last_name;

    @Column
    private int age;

    @Column(length = 5, nullable = true)
    private float weight ;

    @Column(length = 5, nullable = true)
    private float height ;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "goal_id")
    private Set<Goal> goals;

    @OneToOne
    private Application application;

    @ManyToOne
    //@JoinColumn(name = "program_id")
    private Program program;

    @JsonGetter("program")
    public Integer jsonGetProgram(){
        if(program!= null){
            return program.getId();
        }
        return null;
    }
    @JsonGetter("goals")
    public List<Integer> jsonGetGoal(){
        if(goals!= null){
            return goals.stream().map(s -> s.getId())
                    .collect(Collectors.toList());
        }
        return null;
    }
    @JsonGetter("address")
    public Integer jsonGetAddress(){
        if(address!= null){
            return address.getId();
        }
        return null;
    }





}

