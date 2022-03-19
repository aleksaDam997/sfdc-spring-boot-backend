package com.spring.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.spring.dto.DataToPredictDto;
import com.spring.dto.Prediction;
import com.spring.dto.TrainingDto;

import artificial_neural_network.Network;

@Service
public class NNServiceImplementation implements NNService{
	private Network neuralNetwork;

	@Override
	public Prediction trainNetwork(TrainingDto trainingDto) {
		neuralNetwork = new Network(2, 4, 4, 2);
        
        //dodao
        double[][] inputi = trainingDto.getInputs();
        
        double[][]labels = trainingDto.getLabels();

        for(int i = 0; i < 50000; i++){

            //Biramo nasumicnu kombinaciju xor-a
            Random dice = new Random();
            int a = dice.nextInt(4);



            //Treniramo mrezu
            neuralNetwork.train(inputi[a], labels[a], 0.1);
        }

        //Vrsimo predikciju za poslednji clan niza 1, 1 zeljeni ishod 0
        double[] b = neuralNetwork.calculate(inputi[3]);



        //Kako to zapravo izgleda
        return new Prediction(b);
	}

	@Override
	public Prediction predict(DataToPredictDto data) {

		double[] input = new double[2];
		input[0] = data.getValue1();
		input[1] = data.getValue2();
		
		double[] output = neuralNetwork.calculate(input);
		
		return new Prediction(output);
	}
	
	

}
