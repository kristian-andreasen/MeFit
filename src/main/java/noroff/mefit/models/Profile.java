package noroff.mefit.models;

import jakarta.persistence.*;


@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 5, nullable = false)
    private float weight ;

    @Column(length = 5, nullable = false)
    private float height ;

    @Column(length = 255, nullable = true)
    private String disability;

    @Column(name="medical_condition", length = 255, nullable = true)
    private String medicalConditions;


    /// Relations
    @OneToOne
    @JoinColumn(name = "user_id")
    private User_acc user_acc;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @OneToOne
    @JoinColumn(name = "program_id")
    private Program program;
}

