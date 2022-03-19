package com.spring.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.spring.dto.DataToPredictDto;
import com.spring.dto.Prediction;
import com.spring.dto.TrainingDto;

public interface NNService {

	public Prediction trainNetwork(TrainingDto trainingDto);
	public Prediction predict(DataToPredictDto data);
	
}
