import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        CodeWorker code = new CodeWorker();
        System.out.println(code.testMethod());
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public String travel(String adresses, String zip) {
        return this.getAddressString(this.filterRequiredAddresses(adresses, zip), zip);
    }

    public String getAddressString(List<Address> addresses, String zip) {
        return zip+":"+this.mergeAddresses(addresses);
    }

    public List<Address> filterRequiredAddresses(String addresses, String zip) {
        List<Address> addressList = new ArrayList<>();
        var split = addresses.split(",");
        for (var add : split) {
            Address newAddress = this.breakAdress(add);
            if (newAddress.getZip().equals(zip)) {
                addressList.add(newAddress);
            }
        }

        return addressList;
    }

    public Address breakAdress(String address) {
        String city = "";
        String street = "";
        String zip = "";

        String[] split = address.split(" ");
        city = split[0];
        zip = split[split.length - 2] + " " + split[split.length - 1];
        for (var i = 1; i < split.length -2; i++) {
            if (i > 1) {
                street += " ";
            }
            street += split[i];
        }
        return new Address(zip, street, city);
    }

    public String mergeAddresses(List<Address> addresses) {
        var street = "";
        var city = "";
        for (var address : addresses) {
            if (street != "") {
                street += ",";
            }
            street += address.getStreet();
            if (city != "") {
                city += ",";
            }
            city += address.getCity();
        }
        return street+"/"+city;
    }
}

class Address {
    String zip;
    String street;
    String city;

    public Address(String zip, String street, String city) {
        this.zip = zip;
        this.street = street;
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(zip, address.zip) && Objects.equals(street, address.street) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zip, street, city);
    }
}