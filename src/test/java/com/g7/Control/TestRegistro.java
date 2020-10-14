package com.g7.Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.g7.entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.g7.controller.ValidarRegistro;

import static org.junit.Assert.*;

/**
 *
 * @author juand
 */
public class TestRegistro {
    
    private static ValidarRegistro validarRegistro = new ValidarRegistro();
    
    private boolean LONG_NOMBRE_INCORRECTA = false;
    private boolean LONG_PASSWORD_INCORRECTA = false;
    private boolean PASSWORD_DIFERENTE = false;
    private boolean USUARIO_AUTORIZADO = true;
    
    public TestRegistro() {
    }
    
    @Test
    public void testNombre()
    {
        Usuario u = new Usuario();
        
        u.setNombre("Gabriela");
        u.setPassword("12345");
        assertEquals(validarRegistro.verificarLongitudNombre(u.getNombre()), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testContrasenia()
    {
        Usuario u = new Usuario();
        
        u.setNombre("maria");
        u.setPassword("1234567");
        assertEquals(validarRegistro.verificarLongitudPassword(u.getPassword()), LONG_PASSWORD_INCORRECTA);
    }
    
    
    @Test
    public void testTodoCorrecto()
    {
        Usuario u = new Usuario();
        String vPassword = "";
        u.setNombre("juan");
        u.setPassword("1234");
        vPassword = "1234";
        assertEquals(validarRegistro.verificarRegistro(u.getNombre(),u.getPassword()),USUARIO_AUTORIZADO);
        u.setNombre("pedro");
        u.setPassword("123");
        vPassword = "123";
        assertEquals(validarRegistro.verificarRegistro(u.getNombre(),u.getPassword()),USUARIO_AUTORIZADO);
        u.setNombre("maria");
        u.setPassword("12345");
        vPassword = "12345";
        assertEquals(validarRegistro.verificarRegistro(u.getNombre(),u.getPassword()),USUARIO_AUTORIZADO);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
