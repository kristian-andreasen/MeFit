package noroff.mefit.mappers;

import noroff.mefit.dtos.ExerciseGetDTO;
import noroff.mefit.models.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {

    public abstract ExerciseGetDTO exerciseDTO(Exercise exercise);

    public abstract Collection<ExerciseGetDTO> exercisesToExercisesDto(Collection<Exercise> exercises);

    public abstract Exercise exerciseDtoToExercise(ExerciseGetDTO exerciseDTO);

    @Mapping(target = "id", ignore = true)
    public abstract void updateExerciseFromDto(ExerciseGetDTO exerciseDTO, @MappingTarget Exercise exercise);



}
