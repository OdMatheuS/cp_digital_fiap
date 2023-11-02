package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.Usuario;
import br.com.fiap.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws RuntimeException {
		Usuario usuario = usuarioRepository.findByUsername(username);

		if (usuario == null) {
			throw new RuntimeException("Usuário não encontrado");
		}
		UserDetails userDetails = User.builder().username(usuario.getUsername()).password(usuario.getPassword())
				.roles(usuario.getRoles()).build();
		return userDetails;
	}
}
