package com.g7.Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.g7.controller.ValidarLogin;
import com.g7.entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juand
 */
public class TestLogin {
    
    private static ValidarLogin validarLogin = new ValidarLogin();

    private boolean LONG_NOMBRE_INCORRECTA = false;
    private boolean LONG_PASSWORD_INCORRECTA = false;
    private boolean DATOS_INCORRECTOS = false;
    private boolean USUARIO_AUTORIZADO = true;
    
    public TestLogin() {
    }
    
    @Test
    public void testLongitudNombre()
    {
        Usuario u = new Usuario();
        
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testLongitudContrasenia()
    {
       Usuario u = new Usuario();
        
       u.setNombre("Pepe");
       u.setPassword("12");
       assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
       u.setNombre("Pepe");
       u.setPassword("123456");
       assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void testNombre()
    {
       Usuario u = new Usuario();
        
       u.setNombre("Henry");
       u.setPassword("123456");
       assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testContrasenia()
    {
       Usuario u = new Usuario();
        
       u.setNombre("maria");
       u.setPassword("1234");
       assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testDatos()
    {
       Usuario u = new Usuario();
        
       u.setNombre("Henry");
       u.setPassword("123456");
       assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testTodoCorrecto()
    {
       Usuario u = new Usuario();
        
       u.setNombre("juan");
       u.setPassword("1234");
       assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
       u.setNombre("pedro");
       u.setPassword("123");
       assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
       u.setNombre("maria");
       u.setPassword("12345");
       assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
