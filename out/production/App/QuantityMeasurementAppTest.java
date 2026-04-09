import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementAppTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Coal"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Box", "Grain"));
        assertTrue(UseCase12TrainConsistMgmnt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal"));
        assertFalse(UseCase12TrainConsistMgmnt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Coal"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Box", "Grain"));
        assertTrue(UseCase12TrainConsistMgmnt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Coal"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Grain"));
        assertFalse(UseCase12TrainConsistMgmnt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        assertTrue(UseCase12TrainConsistMgmnt.isTrainSafe(bogies));
    }
}
