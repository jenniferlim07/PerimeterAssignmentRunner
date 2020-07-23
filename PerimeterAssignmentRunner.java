import edu.duke.*;
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
        // Put code here
        // 1. Complete writing the method getNumPoints that has one parameter s that is of type Shape. 
        // This method returns an integer that is the number of points in Shape s. 
        // Hint: You will need to iterate over all the points in the Shape S and count them.
        int totalPoint = 0; //instantiate or create a counter, starting at 0
        for (Point currPt : s.getPoints()) {
            totalPoint = totalPoint + 1;
        }
        return totalPoint;
    }

    public double getAverageLength(Shape s) {
        // Complete writing the method getAverageLength that has one parameter s that is of type Shape. 
        //This method returns a number of type double that is the calculated average of all the sides’ lengths in the Shape S.
        double averageSideLengths = 0.0;
        double length = getPerimeter(s);
        int totalPoint = getNumPoints(s);
        averageSideLengths = length / totalPoint;
        return averageSideLengths;
    }

    public double getLargestSide(Shape s) {
        // Complete writing the method getLargestSide that has one parameter s that is of type Shape. 
        // This method returns a number of type double that is the longest side in the Shape S.
        double longestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > longestSide) {
                longestSide = currDist;
            }
            prevPt = currPt;
        }
        return longestSide;
    }

    public double getLargestX(Shape s) {
        // Complete writing the method getLargestX that has one parameter s that is of type Shape. 
        //This method returns a number of type double that is the largest x value over all the points in the Shape s.
        double largestPointXsoFar = 0.0;
        for (Point currentPoint : s.getPoints()) {
            double currentX = currentPoint.getX();
            if (currentX > largestPointXsoFar);
                largestPointXsoFar = currentX;
            }
        return largestPointXsoFar;
    }

    public double getLargestPerimeterMultipleFiles() {
        /* 1. Complete writing the method getLargestPerimeterMultipleFiles that has no parameters. 
         * This method creates a DirectoryResource (so you can select multiple files) and then iterates over these files. 
         * For each File f, it converts the file into a FileResource with the line

         * FileResource fr = new FileResource(f);

         * Then it creates a Shape from the FileResource and calculates the shapes perimeter. 
         * What else does it need to do? It needs to return the the largest perimeter over all the shapes in the files you have selected. */
         DirectoryResource dr = new DirectoryResource(); //creating the DirectoryResource
         
         double largestPerimeter = 0.0; //temp placeholder to store the size, constantly change 
         for (File f : dr.selectedFiles()) { //looping through directory resource for files or for each file f out of directory resource loop
            FileResource fr = new FileResource(f); //creating FileResource from f
            Shape s = new Shape(fr); //creating shape from FileResource
            double currentPerimeter = getPerimeter(s); //create variable of currentPerimeter, calling getPerimeter on shape
            if (currentPerimeter > largestPerimeter) { //
                largestPerimeter = currentPerimeter;
            }
         }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        /* Finish writing the method getFileWithLargestPerimeter that has no parameters. 
         * This method should, like the getLargestPerimeterMultipleFiles method, create its own Directory Resource, 
         * except that this new method returns the File that has the largest such perimeter, so it has return type File. */
        DirectoryResource dr = new DirectoryResource();
        
        double largestPerimeter = 0.0;
        File temp = null; //creating file, placeholder for largest file
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerimeter = getPerimeter(s);
            //double largestPerFile = getLargestPerimeterMultipleFiles();
            if (currentPerimeter > largestPerimeter) {//fileLargestPerimeter.length())
                largestPerimeter = currentPerimeter;
                temp = f; //setting the value to current file f
            }
        }
        if (temp == null) {
            return "";
        } else {
        return temp.getName();
        }
    }


    //Add code in the method testPerimeter to call getNumPoints and to print the result.
    //Add code in the method testPerimeter to call the method getAverageLength and to print out the result. 
    //Note if you were to select the file example1.txt, then the average side length should be 4.0.
    //Add code in the method testPerimeter to call the method getLargestSide and to print out the result. 
    //Note if you were to select the file example1.txt, then the longest side should be 5.0.
    //Add code in the method testPerimeter to call the method getLargestX and to print out the result. 
    //Note if you were to select the file example1.txt, then the longest side should be 4.0.
    public void testPerimeter () {
        System.out.println("************TESTING PERIMETER ONE FILE!***************");
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s); // 22
        System.out.println("perimeter = " + length); // "perimeter = 22"
        int totalPoint = getNumPoints(s); //calling the method
        System.out.println("numPoint = " + totalPoint); // "numPoint = 3"
        double averageSideLengths = getAverageLength(s);
        System.out.println("averageLengths = " + averageSideLengths);
        double longestSide = getLargestSide(s);
        System.out.println("largestSide = " + longestSide);
        double largestPointX = getLargestX(s);
        System.out.println("largestX = " + largestPointX);
    }
    
    public void testPerimeterMultipleFiles() {
        /* Finish writing the void method testPerimeterMultipleFiles to call getLargestPerimeterMultipleFiles 
         * and to print out the largest such perimeter. This method has no parameters and no return value. 
         * You will select the files when you run this method (hint: see our documentation for the DirectoryResource class). */
         System.out.println("************TESTING PERIMETER MULTIPLE FILES!!!!!!!************");
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largestPerimeterMultipleFiles = " + largestPerimeter); //largestPerimeterMultipleFiles = 30.00
        
    }

    public void testFileWithLargestPerimeter() {
        /* Add code to the method testFileWithLargestPerimeter to call getFileWithLargestPerimeter. 
         * For the File that is returned, print the name of that file. */
        String name = getFileWithLargestPerimeter(); //creating a variable of name, calling the method to get the variable of name
        System.out.println("largestPerimeterMultipleFiles = " + name);
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
            System.out.println(f.getName());
        }
    }

    public static void main (String[] args) {
      PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
      pr.testPerimeter();
    }
}
