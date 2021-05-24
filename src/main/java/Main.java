import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CodeWorker code = new CodeWorker();
        code.fileInputReadStream();
        System.out.println(code.testMethod());
    }


}

class CodeWorker {
    public void fileInputReadStream() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/input.txt");
            out = new FileOutputStream("output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public String testMethod() {
        return "method";
    }

    public String travel(String adresses, String zip) {
        List<String> addressList = this.filterRequiredAddresses(adresses, zip);

        return this.getAddressString(addressList, zip);
    }

    public String getAddressString(List<String> addresses, String zip) {
        List<Address> addList = new ArrayList<>();
        for (var add: addresses) {
            addList.add(this.breakAdress(add));
        }

        return zip+":"+this.mergeAddresses(addList);
    }

    public List<String> filterRequiredAddresses(String addresses, String zip) {
        List<String> addressList = new ArrayList<>();
        var split = addresses.split(",");
        for (var add : split) {
            if (add.contains(zip)) {
                addressList.add(add);
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
}