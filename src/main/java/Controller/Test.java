/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.*;

/**
 *
 * @author Izymi
 */
public class Test {

    public static void main(String[] args) {
        String userName = "root";
        String password = "starbucks";
        String url = "jdbc:mysql://teamlul.cqtdfz66koiq.eu-west-2.rds.amazonaws.com:3306/library?zeroDateTimeBehavior=convertToNull";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
//            create.insertInto("author",
//                    "id", "first_name", "last_name")
//                    .values(100, "Hermann", "Hesse")
//                    .execute();

            //Result<Record> result = create.select().from("author").fetch(); // ...
            System.out.println("ss");
        } // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
