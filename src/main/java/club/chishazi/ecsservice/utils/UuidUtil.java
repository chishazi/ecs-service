package club.chishazi.ecsservice.utils;

import java.util.UUID;

/**
 * @author han
 */
public class UuidUtil {
    public static String getUuid(){
        return  UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
