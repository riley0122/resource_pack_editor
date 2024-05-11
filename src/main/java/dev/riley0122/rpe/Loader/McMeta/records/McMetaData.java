package dev.riley0122.rpe.Loader.McMeta.records;

import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

public record McMetaData(
	@JsonProperty("pack") McMetaDataPack pack,
	@JsonInclude(JsonInclude.Include.NON_ABSENT) @JsonProperty("overlays") Optional<McMetaDataOverlays[]> overlays,
	@JsonInclude(JsonInclude.Include.NON_ABSENT) @JsonProperty("filter") Optional<McMetaDataFilter> filter
) {}
