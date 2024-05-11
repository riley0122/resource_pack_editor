package dev.riley0122.rpe.Loader.McMeta.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record McMetaDataFilter (
	@JsonProperty("block") McMetaDataFilterBlock[] block
) {}
