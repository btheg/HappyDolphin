import java.io.Serializable;

public class Disciplin implements Serializable
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
