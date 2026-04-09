import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementAppTest {

    @Test
    void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Sleeper", 50));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("AC Chair", 80));
        List<UseCase13TrainConsistMgmnt.Bogie> result = UseCase13TrainConsistMgmnt.filterWithLoop(bogies);
        assertEquals(1, result.size());
        assertEquals(80, result.get(0).capacity);
    }

    @Test
    void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Sleeper", 40));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("First Class", 100));
        List<UseCase13TrainConsistMgmnt.Bogie> result = UseCase13TrainConsistMgmnt.filterWithStream(bogies);
        assertEquals(1, result.size());
        assertEquals(100, result.get(0).capacity);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bogie-" + i, i * 10));
        }
        List<UseCase13TrainConsistMgmnt.Bogie> loopResult = UseCase13TrainConsistMgmnt.filterWithLoop(bogies);
        List<UseCase13TrainConsistMgmnt.Bogie> streamResult = UseCase13TrainConsistMgmnt.filterWithStream(bogies);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bogie-" + i, i % 100));
        }
        long start = System.nanoTime();
        UseCase13TrainConsistMgmnt.filterWithLoop(bogies);
        long end = System.nanoTime();
        long elapsed = end - start;
        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bogie-" + i, (i % 100) + 1));
        }
        List<UseCase13TrainConsistMgmnt.Bogie> loopResult = UseCase13TrainConsistMgmnt.filterWithLoop(bogies);
        List<UseCase13TrainConsistMgmnt.Bogie> streamResult = UseCase13TrainConsistMgmnt.filterWithStream(bogies);
        assertEquals(loopResult.size(), streamResult.size());
    }
}
