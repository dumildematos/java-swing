/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.connection.ConnectionEntity;
import com.model.UsuarioModel;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Utils;

/**
 *
 * @author dumildematos
 */
public class UsuarioController {
    
    public void create(UsuarioModel professor){
        
        Connection con = ConnectionEntity.openConection();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("insert into usuario (nome,email,senha) values(?,?,?)");
                        
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar "+ex); 
            
        }finally{
            ConnectionEntity.closeConnection(con,stmt);
        }
        
    }
    
    public int loginUser(UsuarioModel professor){
        
        Connection con = ConnectionEntity.openConection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement("select * from usuario where email=? and senha=?");
                        
            stmt.setString(1, professor.getEmail());
            stmt.setString(2, Utils.setMd5(professor.getSenha()));
            rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("idusuario");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar "+ex); 
        }finally{
            ConnectionEntity.closeConnection(con,stmt);
        }
        return 0;
    }

    public List<UsuarioModel> currentUser(int id){
        
        Connection con = ConnectionEntity.openConection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<UsuarioModel> profData = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("select * from usuario where idusuario=?");
                        
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
               
                UsuarioModel user = new UsuarioModel();
               
                user.setId(rs.getInt("idusuario"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                
                profData.add(user);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar "+ex); 
        }finally{
            ConnectionEntity.closeConnection(con,stmt,rs);
        }
        
        return profData;
    }
    
    public static void main(String args[]) throws NoSuchAlgorithmException 
    { 
     // System.out.println(currentUser(5));
    } 
    
}
