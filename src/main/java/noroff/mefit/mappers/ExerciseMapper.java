package noroff.mefit.mappers;

import noroff.mefit.dtos.ExerciseDTO;
import noroff.mefit.models.Exercise;
import noroff.mefit.models.SetCount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {

    //@Mapping(target = "setCounts", ignore = true)
    //I simply can't get the next line to work (see 31:45 in video 2 of peyman's DTO vid->
    //@Mapping(target ="setCounts", source = "setCounts", qualifiedByName = "setCountsToIds")
    public abstract ExerciseDTO exerciseDTO(Exercise exercise);


    @Mapping(target = "setCounts", ignore = true)
    public abstract Exercise exerciseDtoToExercise(ExerciseDTO exerciseDTO);


    @Named("setCountsToIds")
    Set<Integer> setCountsToIds(Set<SetCount> source) {
        if(source == null)
            return null;
        return source.stream()
                .map(SetCount::getId).collect(Collectors.toSet());
    }



    @Mapping(target = "id", ignore = true)
    public abstract void updateExerciseFromDto(ExerciseDTO exerciseDTO, @MappingTarget Exercise exercise);



}
