package org.agoncal.application.petstore.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Embeddable
@NoArgsConstructor @AllArgsConstructor public class Address {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(nullable = false)
    @NotNull
    @Size(min = 5, max = 50)
    @Getter @Setter private String street1;
    @Getter @Setter private String street2;
    @Column(nullable = false, length = 100)
    @NotNull
    @Size(min = 2, max = 50)
    @Getter @Setter private String city;
    @Getter @Setter private String state;
    @Column(name = "zip_code", nullable = false, length = 10)
    @NotNull
    @Size(min = 1, max = 10)
    @Getter @Setter private String zipcode;
    @Column(nullable = false, length = 50)
    @NotNull
    @Size(min = 2, max = 50)
    @Getter @Setter private String country; // TODO use an enum

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!city.equals(address.city)) return false;
        if (!country.equals(address.country)) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (!street1.equals(address.street1)) return false;
        if (street2 != null ? !street2.equals(address.street2) : address.street2 != null) return false;
        if (!zipcode.equals(address.zipcode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = street1.hashCode();
        result = 31 * result + (street2 != null ? street2.hashCode() : 0);
        result = 31 * result + city.hashCode();
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + zipcode.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Address");
        sb.append("{street1='").append(street1).append('\'');
        sb.append(", street2='").append(street2).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", zipcode='").append(zipcode).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
