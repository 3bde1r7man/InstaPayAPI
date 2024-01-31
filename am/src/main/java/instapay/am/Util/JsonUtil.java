package instapay.am.Util;

import java.util.HashMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {

    public static HashMap<String, String> error(String message){      
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Status", "Error");
        error.put("message", message);
        return error;
    }

    public static HashMap<String, String> success(String message){      
        HashMap<String, String> success = new HashMap<String, String>();
        success.put("Status", "Success");
        success.put("message", message);
        return success;
    }
}

