/*
 *  
 *  UADI ActiveTransportIndicators Indictor for Java
 *  Copyright (C) 2017  Guohun Zhu  g.zhu@uq.edu.au
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 * 
 *
 */
package uadi.indicator.uq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author uqgzhu1
 */
public class ActiveTransportIndicatorTest {

    
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Test indicator implementation logic here
     */
    public static void main(String argv[]) {
        ActiveTransportIndicatorTest temp = new ActiveTransportIndicatorTest();
        temp.execIndicatorTest();
    }

    public void execIndicatorTest() {

        try {
            String active_wfsurl = "http://uadi.project.uq.edu.au/UADI/resources/cyclerates/origins";

            JSONObject fjson = new JSONObject(readUrl(active_wfsurl));
            JSONObject features = (JSONObject) fjson.get("features");
            Iterator<String> keysItr = features.keys();
            while(keysItr.hasNext()){
                String name = keysItr.next();
                JSONObject value =(JSONObject) features.get(name);
                System.out.println(name+"\t"+value);
            }
            
            System.out.println("== execIndicator test done");
            return;
        } catch (Exception ex) {
            Logger.getLogger(ActiveTransportIndicatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Test other tasks here
     */
    public void otherTasks() {

        System.out.println("== otherTasks test done");
        return;
    }

}
