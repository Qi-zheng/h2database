package org.h2.test.self;

import org.h2.store.fs.FilePath;
import org.h2.test.TestBase;
import org.h2.test.TestDb;
import org.h2.tools.Csv;

import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class NetDataTest extends TestDb {

    public static void main(String... a) throws Exception {
        TestBase test = TestBase.createCaller().init();
        test.config.traceTest = true;
        test.testFromMain();
    }

    private void testNetFile() throws Exception{
        Connection conn=getConnection("csv");
        Statement stat=conn.createStatement();
        ResultSet rs;
        rs=stat.executeQuery("select * from csvread('"+
                "http://files.grouplens.org/datasets/movielens/ml-100k/u.data',null,'fieldSeparator=\\\t')");
        Csv csv=new Csv();
        Writer writer=new StringWriter();
        csv.write(writer,rs);
        System.out.println(writer);
    }

    private void testNetStream() throws Exception{


        FilePath.register(new QueryEngineStreamPath());
        Connection conn=getConnection("csv");
        Statement stat=conn.createStatement();
        ResultSet rs;
        rs=stat.executeQuery("select * from csvread('"+
                "talos://files.grouplens.org/datasets/movielens/ml-100k/u.data',null,'fieldSeparator=\\\t')");
        Csv csv=new Csv();
        Writer writer=new StringWriter();
        csv.write(writer,rs);
        System.out.println(writer);
    }

    @Override
    public void test() throws Exception {
        //testNetFile();

        testNetStream();
    }
}
