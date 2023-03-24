package noroff.mefit.mappers;

import noroff.mefit.dtos.ExerciseDTO;
import noroff.mefit.dtos.SetCountDto;
import noroff.mefit.models.Exercise;
import noroff.mefit.models.SetCount;
import noroff.mefit.services.ExerciseService;
import noroff.mefit.services.SetCountService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper( componentModel = "spring")
public abstract class SetCountMapper {


    @Autowired
    protected ExerciseService exerciseService ;


    @Mapping(target = "exercise", source = "exercise.id")
    public abstract SetCountDto setCountToSetCountDto(SetCount setCount);

    //todo rename to setCountsToSetCountDTOs maybe for enhanced readability
    public abstract Collection<SetCountDto> setCountsTosetCountDtos(Collection<SetCount> setCounts);

    // SetcountDTO to Setcount
    @Mapping(target ="exercise", source = "exercise", qualifiedByName = "exerciseDtoIdsToExercise")
    public abstract SetCount setCountDtoToSetCount(SetCountDto setCountDto);

    @Named("exerciseDtoIdsToExercise")
    Exercise mapExerciseDtoIdsToExercise(int id) {
        return exerciseService.findById(id);
    }

    //@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target ="exercise", source = "exercise", qualifiedByName = "exerciseDtoIdsToExercise")
    public abstract SetCount updateSetCountFromSetCountDto(SetCountDto setCountDto, @MappingTarget SetCount setCount);

}
