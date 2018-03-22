package tk.timtim3001.tanksclone.engine.window;

public enum WindowDimension {

    DIMENSION_720P(1280, 720), DIMENSION_1080P(1920, 1080);

    private int width;
    private int height;

    WindowDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
