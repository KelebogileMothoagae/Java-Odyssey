/**
 * @author Mr J Orfao
 * @version P07
 * Custom FireworkDisplayCanvas that will Draw the FireworkLayout
 */
package acsse.csc2a.fmb.gui;

import java.util.ArrayList;

import acsse.csc2a.fmb.model.Entity;
import acsse.csc2a.fmb.model.Firework;
import acsse.csc2a.fmb.model.FireworkEntity;
import acsse.csc2a.fmb.model.FountainFirework;
import acsse.csc2a.fmb.model.RocketFirework;
import acsse.csc2a.fmb.particles.FountainParticleSystem;
import acsse.csc2a.fmb.particles.RocketParticleSystem;
import acsse.csc2a.fmb.pattern.EntityVisitor;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * @author: Mothoagae KS 
 * @version: P08
 */

public class FireworkDisplayCanvas extends Canvas {
	// Attributes
	private ArrayList<FireworkEntity> entities = null;
	private static final int NUM_ROWS = 15;
	private static final int NUM_COLS = 15;
	private static final int CELL_SIZE = 50;
	private static final int SIZE = NUM_ROWS * CELL_SIZE;
	private EntityVisitor visitor = null;
	//create a reference for RocketFirework & FountainFirework
	private RocketParticleSystem rocketsystem;
	private FountainParticleSystem fountainsystem;
	private GraphicsContext gc ;
	private long lastnano;
	private  RocketFirework rocketfirework;
	
	/**
	 * Default constructor to set the size of the canvas
	 */
	public FireworkDisplayCanvas() {
		setWidth(SIZE);
		setHeight(SIZE);
		// Create a Visitor to draw the FireworkEntities
		visitor = new EntityVisitor(SIZE, CELL_SIZE);
		//instantiate the Systems
		rocketsystem= new RocketParticleSystem();
		fountainsystem = new FountainParticleSystem();
		this.setStyle("-fx-background-color: black;");
	}

	/**
	 * 
	 * Method to set the FireworkEntity array for drawing
	 * 
	 * @param fireworkEntities ArrayList of FireworkEntity objects
	 */
	public void setFireworkEntities(ArrayList<FireworkEntity> fireworkEntities) {
		this.entities = fireworkEntities;
		// Redraw the canvas to show the FireworkDisplayCanvas objects
		redrawCanvas();
		
		//add fireworks to its particle system
		for(FireworkEntity e:fireworkEntities) {
			//add the firework to the rocketsystem
			rocketsystem.addFirework(NUM_COLS, CELL_SIZE, rocketfirework);
					
			
		}
		
	
	}
		
		
	/**
	 * Method to draw FireworkEntity objects on the canvas
	 */
	public void redrawCanvas() {
		// GraphicsContext
		 gc = getGraphicsContext2D();

		// provide the visitor with the context
		visitor.setGraphicsContext(gc);

		// clear the canvas
		gc.clearRect(0, 0, getWidth(), getHeight());

		// Draw the grid
		gc.setStroke(Color.BLACK);
		// Begin drawing Grid
		for (int r = 0; r < 15; r++) {
			for (int c = 0; c < 15; c++) {
				// Draw Rectangle
				// you need to multiply the row and column by cell_size to get to the correct
				// pixel location
				gc.strokeRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
			}
		}

		// Draw each FireworkEntity using the visitor
		for (Entity entity : entities) {
			entity.accept(visitor);
		}
	}
	
	/**
	 * Method to create the simulation
	 */
	  public void startSimulation() {
	        AnimationTimer timer = new AnimationTimer() {
	            @Override
	            public void handle(long currentNanoTime) {
	                // Convert nanoseconds to seconds
	                double deltaTime = (currentNanoTime - lastnano) / 1e9;
	                lastnano = currentNanoTime;

	                // Update and show particle systems
	                rocketsystem.updateAndShow(gc,deltaTime);
	                fountainsystem.updateAndShow(gc,deltaTime);
	            }
	        };
	        timer.start();
	    }
	 
	 /**
		 * Method to update and sshow
		 */
		
	 
	 private void updateAndShow(double elapsedTime) {
	        rocketsystem.updateAndShow(gc,elapsedTime);
	        fountainsystem.updateAndShow(gc,elapsedTime);
	    }
	
	
}