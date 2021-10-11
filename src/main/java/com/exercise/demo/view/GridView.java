package com.exercise.demo.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.exercise.demo.entity.Cell;
import com.exercise.demo.entity.Grid;

public class GridView {
	private Grid grid;

	public GridView(Grid grid) {
		this.grid = grid;
	}

	public File render() throws IOException {
		int maxX = 0;
		int maxY = 0;

		for (Cell cell : this.grid.getBlackCells()) {
			int absX = Math.abs(cell.getCoordinateX());
			int absY = Math.abs(cell.getCoordinateY());

			if (maxX < absX) {
				maxX = absX;
			}
			if (maxY < absY) {
				maxY = absY;
			}
		}
		int imageWidth = Math.max(maxX, 100);
		int imageHeight = Math.max(maxY, 100);

		int centerX = imageWidth / 2;
		int centerY = imageHeight / 2;

		final BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		final Graphics2D graphics2D = image.createGraphics();
		 graphics2D.setColor(Color.BLACK);
		 
		for (Cell cell : this.grid.getBlackCells()) {
			graphics2D.drawLine(centerX + cell.getCoordinateX(), centerY + cell.getCoordinateY(),
					centerX + cell.getCoordinateX(), centerY + cell.getCoordinateY());
		}

		graphics2D.dispose();
		File file = new File("gridSimulatorPath.png");
		ImageIO.write(image, "png", file);

		return file;
	}
	
	
}
