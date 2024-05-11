package dev.riley0122.rpe.Loader.McMeta.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record McMetaDataOverlaysEntry(
	@JsonProperty("formats") int[] formats,
	@JsonProperty("directory") String directory
) {}
