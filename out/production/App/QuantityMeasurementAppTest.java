import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo, "Safe cargo should be assigned successfully");
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo, "Unsafe cargo should not be assigned");
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo, "Cargo must remain null after unsafe assignment");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmnt.GoodsBogie b1 =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        UseCase15TrainConsistMgmnt.GoodsBogie b2 =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");

        b1.assignCargo("Petroleum");   // safe
        b2.assignCargo("Petroleum");   // unsafe

        assertEquals("Petroleum", b1.cargo, "Safe cargo should be assigned");
        assertNull(b2.cargo, "Unsafe cargo should not be assigned");
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo, "Cargo remains null after unsafe assignment");
    }
}
