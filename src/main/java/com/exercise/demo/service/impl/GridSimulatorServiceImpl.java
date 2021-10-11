package com.exercise.demo.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.exercise.demo.entity.Grid;
import com.exercise.demo.entity.GridPointer;
import com.exercise.demo.service.GridSimulatorService;
import com.exercise.demo.view.GridView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GridSimulatorServiceImpl implements GridSimulatorService {
	/**
	 * run simulation for the pointer
	 * 
	 * @param steps number of steps simulation should run
	 * @author magrawal
	 * @throws IOException 
	 */
	@Override
	public void simulation(Long steps) throws IOException {
		Grid grid = new Grid();
		GridPointer pointer = grid.getPointer();

		for (int step = 1; step <= steps; step++) {
			pointer.changeDirection();
			pointer.movePointer(grid);
		}

		GridView view = new GridView(grid);
		File file;
		file = view.render();
		log.info("last direction of pointer is ::" + pointer.getDirection());
		log.info("last color of cell is ::" + pointer.getCurrentCell().getColor());
	}

}
