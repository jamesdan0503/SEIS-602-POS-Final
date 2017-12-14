/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.of.sale.system;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Time;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Anakin, Will, Eric
 */
public class JsonWR {

    final String loginPath = "C:\\SEIS602 Java\\login\\record.json";
    final String logoutPath = "C:\\SEIS602 Java\\logout\\record.json";
    final static String inventoryPath = "C:\\SEIS602 Java\\inventory\\info.json";
    final static String historyPath = "C:\\SEIS602 Java\\history\\history.json";

    JSONObject jsonObject = new JSONObject();
    JSONObject jsonObject_login = new JSONObject();
    static JSONObject jsonObject_logout = new JSONObject();
    static JSONObject jsonObject_history = new JSONObject();

    public JSONObject json_obj(long appleNum, long bananaNum, long cherryNum) {

        //JSON object and values
        try {
            jsonObject.put("apple", appleNum);
            jsonObject.put("banana", bananaNum);
            jsonObject.put("cherry", cherryNum);

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return jsonObject;
    }

    public void transactionWrite(JSONObject obj, String path, int transNum) {
        try {
            FileWriter fileWriter = new FileWriter(path + transNum + ".json");
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inventoryWrite(JSONObject obj) {
        try {
            FileWriter fileWriter = new FileWriter(inventoryPath);
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject json_obj_login(String time, String name) {

        try {
            jsonObject_login.append("login time", time);
            jsonObject_login.append("name", name);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return jsonObject_login;
    }

    public JSONObject json_obj_logout(String time, String name) {

        try {
            jsonObject_logout.append("logout time", time);
            jsonObject_logout.append("name", name);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return jsonObject_logout;
    }

    public void loginTimeWrite(JSONObject obj) {

        try {
            FileWriter fileWriter = new FileWriter(loginPath);
            fileWriter.write(jsonObject_login.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logoutTimeWrite(JSONObject obj) {

        try {
            FileWriter fileWriter = new FileWriter(logoutPath);
            fileWriter.write(jsonObject_logout.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JSONObject json_obj_history(String name, long appleNum, long bananaNum, long cherryNum, Double total) {

        try {

            jsonObject_history.append("name", name);
            jsonObject_history.append("apple", appleNum);
            jsonObject_history.append("banana", bananaNum);
            jsonObject_history.append("cherry", cherryNum);
            jsonObject_history.append("Total Sale", total);

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return jsonObject_history;
    }

    public void historyWrite(JSONObject obj) {

        try {
            FileWriter fileWriter = new FileWriter(historyPath);
            fileWriter.write(jsonObject_history.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
