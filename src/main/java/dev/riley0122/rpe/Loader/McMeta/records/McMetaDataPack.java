package dev.riley0122.rpe.Loader.McMeta.records;

import java.util.Optional;

public record McMetaDataPack(
	int pack_format,
	String description,
	Optional<int[]> supported_formats
) {}
