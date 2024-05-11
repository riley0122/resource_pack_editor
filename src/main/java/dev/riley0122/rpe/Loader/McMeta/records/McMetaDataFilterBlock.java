package dev.riley0122.rpe.Loader.McMeta.records;

import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public record McMetaDataFilterBlock(
	@JsonProperty("namespace") Pattern namespace,
	@JsonProperty("path") Pattern path
) {}
