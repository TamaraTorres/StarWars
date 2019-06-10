package starwars.model;
public class CharacterResponse
{
    private String next;

    private String previous;

    private String count;

    private Character[] results;

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    public String getPrevious ()
{
    return previous;
}

    public void setPrevious (String previous)
    {
        this.previous = previous;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public Character[] getResults ()
    {
        return results;
    }

    public void setResults (Character[] results)
    {
        this.results = results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [next = "+next+", previous = "+previous+", count = "+count+", results = "+results+"]";
    }
}