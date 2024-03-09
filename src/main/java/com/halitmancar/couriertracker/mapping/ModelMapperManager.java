package com.halitmancar.couriertracker.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperManager {
	
	private static ModelMapper modelMapper;


	private ModelMapperManager() {
	}

	//Singleton
	public static ModelMapper getMapper(){
		if (modelMapper==null){
			modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		}
		return modelMapper;
	}
}
