package pl.sda.ewidencja.validator;

import pl.sda.ewidencja.domain.entity.Phone;

public class PhoneValidator {
    public void validate(Phone phone) {
        if (phone.getMarka().isEmpty() || phone.getMarka() == null || phone.getMarka().length()<2) {
            throw new IllegalArgumentException("Marka nie moze byc pusta i krotsza od 2 znakow");
        }

    }
}
