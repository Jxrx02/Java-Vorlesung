package A_27_Threads.Excercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;

public class SearchEngine {

    private String[] urls;
    public SearchEngine(String[] urls) {
        this.urls = urls;
    }
    public void downloadPages() {
        PageLoader[] loaders = new PageLoader[urls.length];
        Thread[] threads = new Thread[urls.length];

        for (int i = 0; i < urls.length; i++) {
            loaders[i] = new PageLoader(urls[i]);
            threads[i] = new Thread(loaders[i]);
            threads[i].start();
        }

        boolean allPagesLoaded = false;
        while (!allPagesLoaded) {
            allPagesLoaded = true;

            for (PageLoader loader : loaders) {
                if (!loader.pageLoaded()) {
                    allPagesLoaded = false;
                    break;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (PageLoader loader : loaders) {
            if (loader.pageLoaded()) {
                String pageContent = loader.getPageContent();
                System.out.println(pageContent.substring(0, Math.min(pageContent.length(), 60)));
            }
        }
    }

}

class PageLoader implements Runnable{
    private String url;
    private String pageContent;
    private boolean pageLoaded;

    public PageLoader(String url) {
        this.url = url;
        this.pageLoaded = false;
    }

    @Override
    public void run() {

        StringBuilder buffer = new StringBuilder();
        String line = null;
        try ( BufferedReader br = new BufferedReader(
                new InputStreamReader( new URL( url ).openStream(), "UTF-8" ) ) ) {
            while ( (line = br.readLine() ) != null ) {
                buffer.append( line ).append( System.lineSeparator() );
            }
        } catch ( IOException ex ) { }

        pageContent = buffer.toString();
        pageLoaded = true;
    }

    public boolean pageLoaded() {
        return pageLoaded;
    }

    public String getPageContent() {
        return pageContent;
    }

    public static void main(String[] args) {
        String[] urls = {
                "https://www.google.de/?gws_rd=ssl",
                "https://www.tagesschau.de/",
                "https://web.whatsapp.com/"
        };

        SearchEngine searchEngine = new SearchEngine(urls);
        searchEngine.downloadPages();
    }
}


class ReadURLExample {
    public static String getStringContentFromUrl( String url, String encoding ) {
        StringBuilder buffer = new StringBuilder();
        String line = null;
        try ( BufferedReader br = new BufferedReader(
                new InputStreamReader( new URL( url ).openStream(), encoding ) ) ) {
            while ( (line = br.readLine() ) != null ) {
                buffer.append( line ).append( System.lineSeparator() );
            }
        } catch ( IOException ex ) { }
        return buffer.toString();
    }
    public static void main( String[] args ) {
        System.out.println( ReadURLExample.getStringContentFromUrl(
                "https://www.tagesschau.de", "UTF-8" ) );
    }
}

