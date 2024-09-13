/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.coreJava;

/**
 *
 * @author saddam
 */
public class MainMethod {
    
    /**
     * @company : Altimetrik
     */
//    public static void main(String[] args) {
//        try
//        {
//            return;
//        }
//        catch (Exception e)
//        {
//            return;
//        }
//        finally
//        {
//            return;
//        }
//        System.out.println("Demo");    
//    }
    
    /**
     * @company : Altimetrik
     */
    public static void main(String[] args)
    {
        System.out.println(methodReturningValue());
    }
    static int methodReturningValue()
    {
        try
        {
            return 10;
        }
        catch (Exception e)
        {
            return 20;
        }
        finally
        {
            return 50;
        }
    }
    
}
