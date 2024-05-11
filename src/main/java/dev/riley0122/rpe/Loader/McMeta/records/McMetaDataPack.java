package dev.riley0122.rpe.Loader.McMeta.records;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public record McMetaDataPack(
	@JsonProperty("pack_format") int pack_format,
	@JsonProperty("description") String description,
	@JsonInclude(JsonInclude.Include.NON_ABSENT) @JsonProperty("supported_formats") Optional<int[]> supported_formats
) {}
