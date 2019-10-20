

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SiteStats 
{
    private String url;
    private int numVisits;
    public SiteStats(String url, int numVisits) {
        this.url = url;
        this.numVisits = numVisits;
    }
    public int getNumVisits() {
        return this.numVisits;
    }
    public void incVisit()
    {
        this.numVisits ++ ;
    }
    public String getUrl() {
        return this.url;
    }
    public void setNumVisits(int updatedNumVisits) {
        this.numVisits = updatedNumVisits;
    }

    public String toString() {
        return this.url + " | " + this.numVisits;
    }
}
public class SolutionB{

    private static Queue<SiteStats> sites = new LinkedList<SiteStats>();
    public static void listTopVisitedSites(Queue<SiteStats> sites, int n) 
    {
        if(!sites.isEmpty())
        {
            int max = 1;
        for(SiteStats s : sites)
        {
            if(max < s.getNumVisits())
            {
                max = s.getNumVisits();
            }
        }
        while(n!=0 && max>1)
        {
            for(SiteStats s : sites)
            {
                if(s.getNumVisits()==max && n!=0)
                {
                    System.out.println(s);
                    n--;
                }
            }
            max--;
        }
        }
        else 
        {
            System.out.println("No Browsing History");
        }
    }
    public static void updateCount(String url) 
    {
        boolean flag = false ;
        for(SiteStats s : sites)
        {
        	if(s.getUrl().equals(url))
        	{
        		flag = true ;
        		s.incVisit() ;
        	}
        }
        if(!flag)
        {
        	SiteStats s = new SiteStats(url,1);
        	sites.add(s);
        }        
    }
    public static void main(String[] args) 
    {
        String[] visitedSites = { "www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com", "www.google.co.in", "www.youtube.com",
                "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com",
                "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com", "www.amazon.com",
                "www.microsoft.com", "www.upgrad.com" };

        for (String url : visitedSites) 
        {
            updateCount(url);
        }
        listTopVisitedSites(sites, 5);
    }
}
