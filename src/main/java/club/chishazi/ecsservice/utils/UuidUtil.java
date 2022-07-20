package club.chishazi.ecsservice.utils;

import java.util.UUID;

/**
 * @author pis
 */
public class UuidUtil {
    public static String getUuid(){
        return  UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
