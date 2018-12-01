package pl.sda.ewidencja.validator;

import pl.sda.ewidencja.domain.entity.Computer;

import java.util.regex.Pattern;

public class ComputerValidator {

    public void validate(Computer computer) {
        if (computer.getMarka() == null || computer.getMarka().isEmpty() || computer.getMarka().length() < 1) {
            throw new IllegalArgumentException("Marka nie moze byc pusta");
        }
        if (computer.getSerialNumber().isEmpty() || computer.getSerialNumber() == null) {
            throw new IllegalArgumentException("SerialNumber nie moze byc pusty");
        }

        if (computer.getOperatingSystem().isEmpty() || computer.getOperatingSystem() == null
                || computer.getOperatingSystem().length() < 1) {
            throw new IllegalArgumentException("Operation System nie moze byc puste");
        }

        final String regex = "[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}";
        boolean isIpCorrect = Pattern.matches(regex, computer.getIpAddress());

        if (computer.getIpAddress().isEmpty() || computer.getIpAddress() == null || !isIpCorrect) {
            throw new IllegalArgumentException("IpAddress is empty or incorrect");
        }


    }
}

