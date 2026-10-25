package ru.aston.hometask.task3.proxy;

public class RealImageLoader implements ImageLoader {
    @Override
    public Image getImage(String fileName) {
        Image image = loadImage(fileName);
        System.out.println("\nDownloading image '" + image.fileName + "'");
        return image;
    }

    private Image loadImage(String fileName) {
        System.out.println("\nDownloading " + fileName + ". Please wait.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(fileName + " downloaded.");
        return new Image(fileName);
    }
}
