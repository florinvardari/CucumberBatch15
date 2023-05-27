package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    // we will pass the body in multiple formats for this we have to create this class

    public static String createEmployeePayload(){
        String createEmployeePayload="{\n" +
                "  \"emp_firstname\": \"Synflo\",\n" +
                "  \"emp_lastname\": \"Blend\",\n" +
                "  \"emp_middle_name\": \"fb\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1999-05-05\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","Synflo");
        obj.put("emp_lastname","Blend");
        obj.put("emp_middle_name","SFB");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1999-05-05");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","Engineer");
        return obj.toString();
    }

}
