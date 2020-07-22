package builders;

public class ContactInfo {

    public String name;
    public String email;
    public String enquiry;

    public ContactInfo(ContactInfoBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.enquiry = builder.enquiry;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getEnquiry() {
        return enquiry;
    }

    public static class ContactInfoBuilder {
        private String name = "";
        private String email = "";
        private String enquiry = "";

        public ContactInfoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ContactInfoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ContactInfoBuilder enquiry(String enquiry) {
            this.enquiry = enquiry;
            return this;
        }

        public ContactInfo build() {
            return new ContactInfo(this);
        }
    }
}
