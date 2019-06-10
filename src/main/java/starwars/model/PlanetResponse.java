package starwars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlanetResponse
{
    private String next;

    private String count;

    private Planet[] results;

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    @JsonIgnore
    private String previous;

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }



    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public Planet[] getResults ()
    {
        return results;
    }

    public void setResults (Planet[] results)
    {
        this.results = results;
    }


}