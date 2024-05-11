package dev.riley0122.rpe.Loader.McMeta.records;

import java.util.Optional;

public record McMetaData(
	McMetaDataPack pack,
	Optional<McMetaDataOverlays[]> overlays,
	Optional<McMetaDataFilter> filter
) {}
