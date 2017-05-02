package sorting.ui;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sorting.MergeSort;
import sorting.MergeSort.SortStep;



public class SortUi extends Application {

	 public static void main(String[] args) {
	        launch(args);
	    }
	 
	 MergeSort mergesort;
	 
	 public SortUi() {
		 this.mergesort = new MergeSort();
	 }

	 Label array;
	private int width = 800;
	private int height = 400;
	 
	    @Override
	    public void start(Stage primaryStage) {
	    	
		       
		        
	       
		   	 int[] test = {5,4,66,7,24,3,0,2,44,33,1};
			 mergesort.mergesort(test);
			 List<MergeSort.SortStep> states = mergesort.getSteps();
			 states.forEach(p->System.out.println(p.array));
			 primaryStage.setTitle("Hello World!");
	       
	        Canvas canvas = new Canvas(width, height);
	       
	    

	        
	        StackPane root = new StackPane();
	        root.getChildren().add(canvas);
	        primaryStage.setScene(new Scene(root, width, height));
	        primaryStage.show();
	      
	        final Timeline timeline = new Timeline();
	        timeline.setCycleCount(states.size());
	       
	        KeyFrame animateSort = new KeyFrame(Duration.seconds(.600),	        		
	        		new EventHandler<ActionEvent>() {
	        	 int i=0;
	                    public void handle(ActionEvent event) {
		                    i = drawShapes(canvas.getGraphicsContext2D(), states.get(i), i);
		                
	                    }
	                });

	        timeline.getKeyFrames().add(animateSort);
	        timeline.play();
	       
	    }
	    
	    int x = 0;
	    int nextX(int height) {
	    	return  width/ (height+1) / 2 + x++;
	    }
	    private int  drawShapes(GraphicsContext gc, MergeSort.SortStep sortStep, int pos) {
	    	
	       int x = nextX(pos);
	       int y = sortStep.step+1;
	       
	       System.out.println(sortStep.array);
 	       do {
 	    	   gc.fillText(sortStep.array, x, y*20);
 	       
 	       
 	       
 	     	pos++;
 	       }
 	       while(
 	    		  !isPowerOf2(pos)
 	    	   );
//	    	gc.setFill(Color.GREEN);
//	        gc.setStroke(Color.BLUE);
//	        gc.setLineWidth(5);
//	        gc.strokeLine(40, 10, 10, 40);
//	        gc.fillOval(10, 60, 30, 30);
//	        gc.strokeOval(60, 60, 30, 30);
//	        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
//	        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
//	        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
//	        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
//	        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
//	        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
//	        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
//	        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
//	        gc.fillPolygon(new double[]{10, 40, 10, 40},
//	                       new double[]{210, 210, 240, 240}, 4);
//	        gc.strokePolygon(new double[]{60, 90, 60, 90},
//	                         new double[]{210, 210, 240, 240}, 4);
//	        gc.strokePolyline(new double[]{110, 140, 110, 140},
//	                          new double[]{210, 210, 240, 240}, 4);
	       return pos;
	    }


		private boolean isPowerOf2(int pos) {
			return (pos & (pos - 1)) == 0;
		}


	
}
