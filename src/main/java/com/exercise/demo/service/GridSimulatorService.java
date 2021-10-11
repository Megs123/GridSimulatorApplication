package com.exercise.demo.service;

import java.io.IOException;

public interface GridSimulatorService {
	/**
     *run simulation for the pointer
     * 
     * @param steps
     *            number of steps simulation should run
     *	@author magrawal
	 * @throws IOException 
     */
	void simulation( Long steps) throws IOException;
}
