package distancing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SocialDistanceChecker{
    public static void main(String[] args) throws SocialDistancingViolation {
        SocialTester buns = new SocialTester("bookings");
        buns.check();
    }
}

// EXTEND THE VIOLATION SO THAT THE CATCHER CAN WORK
class SocialDistancingViolation extends Exception {}

class SocialTester {

    Path path;

    public SocialTester(String fileName){
        this.path= Paths.get("/home/codex/Projects/SocialDistanceChecker/"+ fileName+".txt");
    }

    boolean check() throws SocialDistancingViolation {
        boolean assertion = false;
        try {
            if("x x x x x".equals(Files.readAllLines(path).get(0).toLowerCase())){
                assertion = true;
                System.out.println("This is social distancing");

            } else {
                throw new SocialDistancingViolation();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assertion;
    }


}




