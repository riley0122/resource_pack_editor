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
		
		if (parsedData != null) {
			this.pack = parsedData.pack();
			if (parsedData.overlays() != null) {				
				this.overlays = parsedData.overlays().orElse(null);
			}
			if (parsedData.filter() != null) {				
				this.filter = parsedData.filter().orElse(null);
			}
		}
	}
}
