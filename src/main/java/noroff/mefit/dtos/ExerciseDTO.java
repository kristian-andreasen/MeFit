package noroff.mefit.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class ExerciseDTO {
        private int id;
        private String name;
        private String description;
        private String muscle_group;
        private String imageURL;
        private String videoURL;
        private Set<Integer> setCounts;
}
