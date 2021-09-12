import java.util.*;
import java.io.*;

public class CacheTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //Parse command line to set up 1 cache or 2 cache of certain size
        
        if(args.length == 3){
            //first cache code
            int cacheSize = Integer.parseInt(args[1]);
            Cache<String> cache = new Cache<String>(cacheSize);
            
            File file = new File(args[2]);
            try{
                Scanner input = new Scanner(file);

                while(input.hasNext()){
                    String word = input.next();
                    cache.incrementFirstCacheReferences();
                    if(cache.hasObjectFirst(word)){
                        cache.incrementFirstCacheHits();
                        cache.removeObjectFirst(word);
                        cache.addObjectFirst(word);
                    }
                    else{
                        cache.removeObjectFirst(word);
                        cache.addObjectFirst(word);
                    }
                   
                }
            input.close();
            }
            catch(IOException e){
                 System.out.println("File not found");
                  e.printStackTrace();
            }
                                        
        cache.toStringFirst(cache, args[1], startTime);

        }

        if(args.length == 4){
            
            //second cache code
            int cacheSize1 = Integer.parseInt(args[1]);
            int cacheSize2 = Integer.parseInt(args[2]);
            Cache<String> cache = new Cache<String>(cacheSize1, cacheSize2);
            
            File file = new File(args[3]);
            try{
                Scanner input = new Scanner(file);
                
            
                while(input.hasNext()){
                    String word = input.next();
                    cache.incrementFirstCacheReferences();
                    if(cache.hasObjectFirst(word)){
                        cache.incrementFirstCacheHits();
                        cache.removeObjectFirst(word);
                        cache.addObjectFirst(word);
                        cache.removeObjectSecond(word);
                        cache.addObjectSecond(word);
                    }
                    else{
                        cache.incrementSecondCacheReferences();
                        if(cache.hasObjectSecond(word)){
                            cache.incrementSecondCacheHits();
                            cache.removeObjectSecond(word);
                            cache.addObjectSecond(word);
                            cache.addObjectFirst(word);
                        }
                        else{
                            cache.addObjectFirst(word);
                            cache.addObjectSecond(word);
                        }
                    }
                }

                input.close();
            }
            catch(IOException e){
                System.out.println("File not found");
                e.printStackTrace();
            }
            
        
           cache.toStringBoth(cache, args[1], args[2], startTime);

        }
        
    }
}