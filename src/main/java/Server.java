import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableAutoConfiguration
public class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    ICircularShift shifter;
    IAlphabetizedCircularShift alphabetizer;

    @RequestMapping(path="/api/rotate", method = RequestMethod.GET)
    public @ResponseBody List<String> circularShift(@RequestParam("sentence") String pSentence)
    {
        LineStorage sentence = new LineStorage(pSentence);

        shifter = new CircularShift(sentence);
        shifter.generateCircularShift();

        return shifter.getLines();
    }

    @RequestMapping(path="/api/sort", method = RequestMethod.GET)
    public @ResponseBody List<String> sortCircularShift()
    {
        alphabetizer = new AlphabetizedCircularShift(shifter.getLines());
        alphabetizer.generateAlphabetizedCircularShift();

        return (alphabetizer.getLines());
    }

    @RequestMapping(path="/api/reset", method = RequestMethod.GET)
    public @ResponseBody boolean reset()
    {
        alphabetizer.reset();
        return true;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Server.class, args);
    }

}