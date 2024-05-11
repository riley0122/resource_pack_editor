package dev.riley0122.rpe.Loader.McMeta.records;

import java.util.regex.Pattern;

public record McMetaDataFilterBlock(
	Pattern namespace,
	Pattern path
) {}
