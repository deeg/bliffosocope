import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Calls the ImageMatcher Jar with Bliffoscope test data.
 */
public class Bliffoscope {

    public static void main(String[] args) throws InterruptedException, IOException {

        Process p = Runtime.getRuntime().exec("java -jar ImageMatcher.jar -p patternImages -s sourceImages");
        BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
        BufferedInputStream bes = new BufferedInputStream(p.getErrorStream());
        synchronized (p) {
            p.waitFor();
        }
System.out.println(p.exitValue());
        int b;
        while((b=bis.read()) >0){
            System.out.print((char)b);
        }

        int e;
        while((e=bes.read()) >0){
            System.out.print((char)e);
        }

    }
}
