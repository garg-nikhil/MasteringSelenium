package Api.Request.Pojo;

public class Variables {
    private Input input;

    public Variables() {}

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Variables{" +
                "input=" + input +
                '}';
    }
}
