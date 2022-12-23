import com.victor.Bonus;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusTest {
    @Test
    public void deveReceber5PorcentoBonus() {
        Bonus bonus = new Bonus();
        double bonusRecebido = bonus.calcularBonus(21, 6, 1000);
        assertEquals(50, bonusRecebido);
    }

    @Test
    public void deveReceber10PorcentoBonus() {
        Bonus bonus = new Bonus();
        double bonusRecebido = bonus.calcularBonus(31, 12, 1000);
        assertEquals(100, bonusRecebido);
    }

    @Test
    public void naoRecebeBonus() {
        Bonus bonus = new Bonus();
        double bonusRecebido = bonus.calcularBonus(19, 5, 1000);
        assertEquals(0, bonusRecebido);
    }
}
