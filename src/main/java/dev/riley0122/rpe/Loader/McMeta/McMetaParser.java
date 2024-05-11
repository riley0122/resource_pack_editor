package dev.riley0122.rpe.Loader.McMeta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.riley0122.rpe.Loader.McMeta.records.*;
import dev.riley0122.rpe.Screens.AlertScreen;
import dev.riley0122.rpe.Screens.LoadingScreen;

public class McMetaParser {
	public static McMetaData parse(String data) {
		LoadingScreen.UpdateStatus("Parsing pack.mcmeta");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(data);
			if (!node.has("pack")) {
				AlertScreen.error("Invalid pack.mcmeta", "pack.mcmeta doesn't have the required 'pack' field!");
				LoadingScreen.UpdateStatus("Invalid pack.mcmeta!");
				return null;
			}
			
			McMetaDataPack packData = mapper.readValue(node.get("pack").toString(), McMetaDataPack.class);
			
			return new McMetaData(packData, java.util.Optional.empty(), java.util.Optional.empty());
		} catch (JsonMappingException e) {
			LoadingScreen.UpdateStatus("Failed to map pack.mcmeta values!");
			AlertScreen.error("Failed to map pack.mcmeta values!", e.getMessage());
			System.out.println("data: " + data + "\n\n");
			return null;
		} catch (JsonProcessingException e) {
			AlertScreen.error("Failed to process pack.mcmeta!", e.getMessage());
			LoadingScreen.UpdateStatus("Failed to process pack.mcmeta!");
			return null;
		}
	}
}
