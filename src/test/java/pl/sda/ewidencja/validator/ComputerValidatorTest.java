package pl.sda.ewidencja.validator;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.enums.Type;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class ComputerValidatorTest {

    @Test
    public void validateGetters() {
    // Given
    ComputerValidator computerValidator = new ComputerValidator();
        Computer computer = new Computer(1L, Type.DESKTOP,"HP","123",
                "WinXP","10.10.10.10",null);
        //Then
        Assert.assertEquals("HP",computer.getMarka());
        Assert.assertEquals(Type.DESKTOP,computer.getTyp());
        Assert.assertEquals("123",computer.getSerialNumber());
    }
    @Test
    public void validate(){
        //Given
        ComputerValidator computerValidator = new ComputerValidator();
        Computer computer = new Computer(1L, Type.DESKTOP,"HP","123",
                "WinXP","10.10.10.10",null);
        //Then
        computerValidator.validate(computer);

    }
}