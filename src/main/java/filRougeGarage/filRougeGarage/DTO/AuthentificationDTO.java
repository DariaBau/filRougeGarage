package filRougeGarage.filRougeGarage.DTO;



public record AuthentificationDTO(String username, String password) {


    public Object getPassword() {
        return  password;
    }

    public String getEmail() {
        return getEmail();
    }
}