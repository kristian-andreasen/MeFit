package noroff.mefit.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import noroff.mefit.dtos.ExerciseGetDTO;
import noroff.mefit.mappers.ExerciseMapper;
import noroff.mefit.models.Exercise;
import noroff.mefit.services.ExerciseService;
import noroff.mefit.services.ExerciseServiceImpl;
import noroff.mefit.util.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ExerciseMapper exerciseMapper;


    public ExerciseController(ExerciseServiceImpl exerciseService, ExerciseMapper exerciseMapper) {
        this.exerciseService = exerciseService;
        this.exerciseMapper = exerciseMapper;
    }

    @Operation(summary = "Get all exercises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExerciseGetDTO.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "Exercise does not exist with supplied ID",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public ResponseEntity getAll(){
            Collection<ExerciseGetDTO> exerciseGetDTOs = exerciseMapper.exercisesToExercisesDto(
                    exerciseService.findAll());
            return ResponseEntity.ok(exerciseGetDTOs);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "Get a exercise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExerciseGetDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Exercise does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) {

            ExerciseGetDTO exerciseGetDTO = exerciseMapper.exerciseDTO(exerciseService.findById(id)
            );
            return ResponseEntity.ok(exerciseGetDTO);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "Adding a new exercise")
    @PostMapping()
    public ResponseEntity<Exercise> add(@RequestBody Exercise exercise) {
        Exercise exerciseToAdd = exerciseService.add(exercise);
        URI location = URI.create("api/v1/exercises/" + exerciseToAdd.getId());
        return ResponseEntity.created(location).body(exerciseToAdd);
    }


}
