package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

public class ListItem
{
    private String title;
    private int image;

    public ListItem(String title, int image)
    {
        this.title=title;
        this.image = image;

    }

    public ListItem(String title)
    {
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {return image;}
}