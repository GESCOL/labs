/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g7.Control;

import com.g7.DAO.UsuarioDAO;
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
public class TestCUD {
    
    private boolean OP_SUCCESS=true;
    private boolean OP_UNSUCCESS=false;
    
    public TestCUD() {
    }
       
    @Test
    public void testCreate()
    {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        usuario.setNombre("juan");
        usuario.setPassword("1234");
        assertEquals(dao.crear(usuario), OP_SUCCESS);
        usuario.setNombre("pedro");
        usuario.setPassword("123");
        assertEquals(dao.crear(usuario), OP_SUCCESS);
        usuario.setNombre("maria");
        usuario.setPassword("12345");
        assertEquals(dao.crear(usuario), OP_SUCCESS);
        usuario.setNombre("john");
        usuario.setPassword("4567");
        assertEquals(dao.crear(usuario), OP_SUCCESS);
    }  
    
    @Test
    public void testUpdate()
    {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario oldUsuario = new Usuario();  
        
        usuario.setNombre("Henry");
        usuario.setPassword("1234");
        oldUsuario.setNombre("Henry");
        oldUsuario.setPassword("123");
        assertEquals(dao.actualizar(oldUsuario, usuario),OP_UNSUCCESS);
        usuario.setNombre("pedro");
        usuario.setPassword("321");
        oldUsuario.setNombre("pedro");
        oldUsuario.setPassword("123");
        assertEquals(dao.actualizar(oldUsuario, usuario),OP_SUCCESS);
    }    
    
    @Test
    public void testDelete()
    {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        usuario.setNombre("Henry");
        usuario.setPassword("1234");
        assertEquals(dao.eliminar(usuario),OP_UNSUCCESS);
        usuario.setNombre("john");
        usuario.setPassword("4567");
        assertEquals(dao.eliminar(usuario),OP_SUCCESS);
    }
}
