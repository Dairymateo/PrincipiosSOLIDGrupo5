


class UserManager {


    private EmailSender emailSender;
    private Validar validar;
    private UserManagerRepository userManagerRepository;


    public UserManager(){
        this.emailSender = new EmailSender();
        this.validar = new Validar();
        this.userManagerRepository = new UserManagerRepository();

    }


    public void addUser(String email, String password) {
        if (validar.isValidEmail(email) && validar.isValidPassword(password)) {
            userManagerRepository.saveToDatabase(email, password);
            emailSender.sendWelcomeEmail(email);
        } else {
            System.out.println("Invalid email or password. User not added.");
        }
    }



}

