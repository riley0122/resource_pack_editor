package dev.riley0122.rpe.Loader.McMeta;

import java.io.File;
import java.nio.file.FileSystems;

import dev.riley0122.rpe.Loader.McMeta.records.*;

public class McMeta {
	public McMetaDataPack pack;
	public McMetaDataOverlays[] overlays;
	public McMetaDataFilter filter;
	
	public McMeta(File folder) {
		String data = "";
		File metaFile = FileSystems.getDefault().getPath(folder.getAbsolutePath(), "pack.mcmeta").toFile();
		
		if (!metaFile.exists()) {
			McMetaMaker.run(folder);
			data = McMetaMaker.data;
		} else {
			McMetaReader.run(folder);
			data = McMetaReader.data;
		}
		
		McMetaData parsedData = McMetaParser.parse(data);
		
		this.pack = parsedData.pack();
		this.overlays = parsedData.overlays().orElse(null);
		this.filter = parsedData.filter().orElse(null);
	}
}
