package noroff.mefit.dtos;

import lombok.*;
import noroff.mefit.models.SetCount;

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

        private Set<SetCount> setCounts;
}
