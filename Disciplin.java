public class Disciplin
{
    private String type;

    public Disciplin(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return this.type;
    }
}
