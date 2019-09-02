import edu.duke.*;

import java.awt.Point;
import java.awt.Shape;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
    	int count=0;
        for(Point p: s.getPoints()) {
        	count=count+1;
        	
        }
        return count;
    }

    public double getAverageLength(Shape s) {
    	double perimeter=getPerimeter(s);
    	int totalPoints=getNumPoints(s);
                return perimeter/totalPoints;
    }

    public double getLargestSide(Shape s) {
    	Point prevPt = s.getLastPoint();
    	double LargeDist=-1;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(currDist >LargeDist) {
            	LargeDist=currDist;
            }
        }
        return LargeDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
    	double largePerimeter=-1;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter=getPerimeter(s);
            if(currPerimeter>largePerimeter) {
            	largePerimeter=currPerimeter;
            }
        }
        return largePerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
    	double largePerimeter=-1;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter=getPerimeter(s);
            if(currPerimeter>largePerimeter) {
            	largePerimeter=currPerimeter;
            	temp=f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int getPoints= getNumPoints(s);
        double averageLength=getAverageLength(s);
        double largestSideDist=getLargestSide(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points="+getPoints);
        System.out.println("Average Length="+averageLength);
        System.out.println("Largest side Distance="+largestSideDist);
    }
    
    public void testPerimeterMultipleFiles() {
        double large_Perimeter=getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter of all files is="+large_Perimeter);
    }

    public void testFileWithLargestPerimeter() {
        String fileName=getFileWithLargestPerimeter();
        System.out.println("Largest Perimeter File name is="+fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
