public class WashPlan 
{
    private float weight;
    private int numberOfWashes;
    private float price;
    WashPlan(float weight, int numberOfWashes,float price)
    {
        this.weight = weight;
        this.numberOfWashes = numberOfWashes;
        this.price = price;
    }
    public float getWeight()
    {
        return this.weight;
    }
    public int getNumberOfWashes()
    {
        return this.numberOfWashes;
    }
    public float getPrice()
    {
        return this.price;
    }
    public String toString()
    {
        return "Weight : " + weight + ", " + "Number of Washes : " + numberOfWashes + ", Price : " + price;
    }
    
}
