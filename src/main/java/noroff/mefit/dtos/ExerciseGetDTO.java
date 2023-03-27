package noroff.mefit.dtos;

import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
public class ExerciseGetDTO {

        private int id;

        private String name;

        private String description;

        private String muscle_group;

        private String imageURL;

        private String videoURL;

}
