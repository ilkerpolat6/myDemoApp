package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public void testIntDiv() {
        App rlc= new App();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        String res=rlc.search(array, 99,99,99);
        boolean boo=res.equals("densities: 0 0 0 0");
        assertTrue(boo);
    }
    public void test1Div() {
        App rlc= new App();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        String res=rlc.search(array, 1,1,1);
        boolean boo=res.equals("densities: 1 2 3 4");
        assertTrue(boo);
    }
    public void test0Div() {
        App rlc= new App();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(0,0,0,0));
        String res=rlc.search(array,1,100,500);
        boolean boo=res.equals("densities: 0 0 0 0");
        assertTrue(boo);
    }
    public void testSingleMass() {
        App rlc= new App();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(128));
        String res=rlc.search(array,2,2,2);
        boolean boo=res.equals("densities: 16");
        assertTrue(boo);
    }
    public void testnoneMass() {
        App rlc= new App();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList());
        String res=rlc.search(array,2,2,2);
        boolean boo=res.equals("densities:");
        assertTrue(boo);
    }

}
