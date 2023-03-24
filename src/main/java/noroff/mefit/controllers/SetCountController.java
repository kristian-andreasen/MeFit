package noroff.mefit.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import noroff.mefit.dtos.SetCountDto;
import noroff.mefit.mappers.SetCountMapper;
import noroff.mefit.models.SetCount;
import noroff.mefit.services.SetCountService;
import noroff.mefit.services.SetCountServiceImpl;
import noroff.mefit.util.ApiErrorResponse;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/set_counts")
public class SetCountController {
    private final SetCountService setCountService;
    private final SetCountMapper setCountMapper;

    public SetCountController(SetCountServiceImpl setCountService, SetCountMapper setCountMapper) {
        this.setCountService = setCountService;
        this.setCountMapper = setCountMapper;
    }


    @Operation(summary = "Get all setCounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = SetCountDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "SetCount does not exist with supplied ID",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public ResponseEntity getAll() {
        try {
            Collection<SetCountDto> setCountDtos = setCountMapper.setCountsTosetCountDtos(
                    setCountService.findAll()
            );
            return ResponseEntity.ok(setCountDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get a setCount by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SetCountDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "setCount does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
             SetCountDto setCountDto = setCountMapper.setCountToSetCountDto(setCountService.findById(id));
            return ResponseEntity.ok(setCountDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Adding a new setCount")
    @PostMapping()
    public ResponseEntity<SetCountDto> add(@RequestBody SetCountDto setCountDto) {
        SetCount setCountDtoToSetCount = setCountMapper.setCountDtoToSetCount(setCountDto);
        SetCount setCountToAdd = setCountService.add(setCountDtoToSetCount); // no need to create new object
        URI location = URI.create("api/v1/set_counts/" + setCountToAdd.getId());

        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Updates a setCount")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "setCount successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "setCount not found with supplied ID",
                    content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity<SetCountDto> update( @PathVariable int id, @RequestBody SetCountDto setCountDto) {
        SetCount existingSetCount = setCountService.findById(id);
        if(id != setCountService.findById(id).getId()) {
            return ResponseEntity.badRequest().build();
        }
        setCountMapper.updateSetCountFromSetCountDto(setCountDto,existingSetCount );
        setCountService.update(existingSetCount);
        return ResponseEntity.ok(setCountMapper.setCountToSetCountDto(existingSetCount));
    }


}
