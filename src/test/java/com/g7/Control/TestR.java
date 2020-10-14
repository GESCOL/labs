/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g7.Control;

import com.g7.DAO.UsuarioDAO;
import com.g7.entidad.Usuario;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juand
 */
public class TestR extends TestCase{
    
    private boolean OP_SUCCESS=true;
    private boolean OP_UNSUCCESS=false;
    
    public TestR() {
    }
    
    @Test
    public void testRead()
    {
        UsuarioDAO dao=new UsuarioDAO();
        Usuario usuario=new Usuario();
        
        usuario.setNombre("Henry");
        usuario.setPassword("1234");
        assertEquals(dao.leer(usuario),OP_UNSUCCESS);
        usuario.setNombre("juan");
        usuario.setPassword("1234");
        assertEquals(dao.leer(usuario),OP_SUCCESS);        
    }    
}
