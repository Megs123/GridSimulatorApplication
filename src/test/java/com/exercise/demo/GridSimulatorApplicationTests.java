package com.exercise.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exercise.demo.controller.GridSimulatorResource;
import com.exercise.demo.entity.Direction;
import com.exercise.demo.entity.GridPointer;
import com.exercise.demo.service.GridSimulatorService;

@SpringBootTest
class GridSimulatorApplicationTests {

	 @Autowired 
	  private GridSimulatorResource gridController;
	
	  @Autowired
	  private GridSimulatorService service;
	  @InjectMocks
	  private GridPointer pointer;

	
	  @Test 
	  void contextLoads() { 
		  //assert that controller is created by context
	  assertThat(gridController).isNotNull();
	  }
	  
	  @Test
	  void checkGridPath() throws IOException {
		  Long steps= 5L;
		  service.simulation(steps);
		  assertThat(this.pointer.getDirection().equals(Direction.UP));
	  }
	 

}
