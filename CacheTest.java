public class CacheTest {
    public static void main(String[] args) {
        //Parse command line to set up 1 cache or 2 cache of certain size
        
        if(args.length == 3){
            //first cache code
            int cacheSize = Integer.parseInt(args[1]);
            Cache<String> dataHolder = new Cache<String>(cacheSize);

            //Delemit file and tokenize into individual words

            /* Algorithm for 1 cache
            Search cache1;
            Increment the # of cache1 references;
            if cache1 hits 
                then Increment the # of cache1 hits;
            Move the hit data item to the top of cache1
            */
            
        }

        if(args.length == 4){
            //second cache code
            int cacheSize1 = Integer.parseInt(args[1]);
            int cacheSize2 = Integer.parseInt(args[2]);
            Cache<String> dataHolder = new Cache<String>(cacheSize1, cacheSize2);


        //Delemit file and institute given algorithm - two versions of this algorithm
        
        /* Algorithm for 2 cache
        Search cache1;
        Increment the # of cache1 references;
        if cache1 hits
            then Increment the # of cache1 hits;
                Move the hit data item to the top of both cache.
            else Search cache2;
                Increment the # of cache2 references; 
                if cache2 hits
                    then Increment the # of cache2 hits;
                        Move the hit data item to the top of cache2;
                        Add the data item to the top of cache1;
                    else Add the data item to the top of both cache;
        */

        }

       

        //Delemit file and institute given algorithm - two versions of this algorithm
        //Command line will tell us if 1 cache algorithm or two cache algorithm and output
        /*
        Search cache1;
        Increment the # of cache1 references;
        if cache1 hits
            then Increment the # of cache1 hits;
                Move the hit data item to the top of both cache.
            else Search cache2;
                Increment the # of cache2 references; 
                if cache2 hits
                    then Increment the # of cache2 hits;
                        Move the hit data item to the top of cache2;
                        Add the data item to the top of cache1;
                    else Add the data item to the top of both cache;
        */

        //Print out the metrics, the hit ratios 

        //Print out how long it took the program to run

        
    }
}