public class Ansat extends Medlem
{
    private String userName;
    private String passWord;

    public Ansat(String navn, String email, int alder, String userName, String passWord)
    {
        super (navn, email, alder);
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassWord()
    {
        return passWord;
    }
}