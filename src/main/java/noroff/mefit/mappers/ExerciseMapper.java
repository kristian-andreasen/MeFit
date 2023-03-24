package noroff.mefit.mappers;

import noroff.mefit.dtos.ExerciseDTO;
import noroff.mefit.models.Exercise;
import noroff.mefit.models.SetCount;
import noroff.mefit.services.SetCountService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {
    @Autowired
    protected SetCountService setCountService ;

    //@Mapping(target ="setCounts", source = "setCounts", qualifiedByName = "setCountsToIds")
    public abstract ExerciseDTO exerciseDTO(Exercise exercise);

    public abstract Collection<ExerciseDTO> exercisesToExercisesDto(Collection<Exercise> exercises);

   // @Mapping(target ="setCounts", source = "setCounts", qualifiedByName = "SetCountDTOIdsToSetCounts")
    public abstract Exercise exerciseDtoToExercise(ExerciseDTO exerciseDTO);

    @Named("setCountsToIds")
    Set<Integer> setCountsToIds(Set<SetCount> source) {
        if(source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }

/*    @Named("SetCountDTOIdsToSetCounts")
    Set<SetCount> SetCountDTOIdsToSetCounts(Set<Integer> id) {
        return id.stream()
                .map( i -> setCountService.findById(i))
                .collect(Collectors.toSet());
    }*/

    @Mapping(target = "id", ignore = true)
    //@Mapping(target ="setCounts", source = "setCounts", qualifiedByName = "SetCountDTOIdsToSetCounts")
    public abstract void updateExerciseFromDto(ExerciseDTO exerciseDTO, @MappingTarget Exercise exercise);



}
