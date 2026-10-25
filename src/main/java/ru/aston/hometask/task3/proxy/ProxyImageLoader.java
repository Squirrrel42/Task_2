package ru.aston.hometask.task3.proxy;

import java.util.HashMap;

public class ProxyImageLoader implements ImageLoader {
    private final ImageLoader realImageLoader;
    private final HashMap<String, Image> cache = new HashMap<>();

    public ProxyImageLoader() {
        this.realImageLoader = new RealImageLoader();
    }

    @Override
    public Image getImage(String fileName) {
        Image image = cache.get(fileName);
        if (image == null) {
            image = realImageLoader.getImage(fileName);
            cache.put(image.fileName, image);
        }
        else {
            System.out.println("\nGot image '" + image.fileName + "' from cache.");
        }
        return image;
        }
}
