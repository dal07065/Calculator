package sample;

public class Module {
    private String text;
    private boolean isNumber;

    public Module(String text, boolean isNumber)
    {
        this.text = text;
        this.isNumber = isNumber;

    }

    public boolean isNumber()
    {
        return isNumber;
    }

    @Override
    public String toString()
    {
        return text;
    }

    public double toNumber() {
        return Double.valueOf(text);
    }
}
