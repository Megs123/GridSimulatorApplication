package com.exercise.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.demo.service.GridSimulatorService;

@RestController
@RequestMapping("/grid")
public class GridSimulatorResource {
	
	@Autowired
	private GridSimulatorService gridService;
	
	/**
     *run simulation for the pointer
     * 
     * @param steps
     *            number of steps simulation should run
     *	@author magrawal
	 * @throws IOException 
     */
	@PutMapping(path="/simulation/{steps}")
	public ResponseEntity<Void> simulation(@PathVariable Long steps ) throws IOException  {
		gridService.simulation(steps);
	return new ResponseEntity<>(HttpStatus.OK);
	}


}
