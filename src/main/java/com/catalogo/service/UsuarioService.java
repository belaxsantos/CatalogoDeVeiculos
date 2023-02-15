package com.catalogo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.catalogo.model.Usuario;
import com.catalogo.model.UsuarioLogin;
import com.catalogo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario){
		
		if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuário já existe",null);
	
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
	return Optional.of(usuarioRepository.save(usuario));
	
	}
	public void atualizarUsario(Usuario usuario){
		if (usuarioRepository.findById(usuario.getId()).isPresent()) {
			Object usuarioLogin = usuario;
			Optional<Usuario> buscaUsuario = usuarioRepository.findByUsuario(((Optional<Usuario>) usuarioLogin).get().getUsuario());
			if (buscaUsuario.isPresent()) {
                if (buscaUsuario.get().getId() != usuario.getId()) 
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                            "Usuário já existe!", null);
            }usuario.setSenha(criptografarSenha(usuario.getSenha())); 
            return; 
            }			
		
		}
	
	private String criptografarSenha(String senha) {
		return null;
	}

	
	
	public static Optional<Usuario> logarUsuario(Optional<UsuarioLogin> usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
