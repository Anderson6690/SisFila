package com.developlus.sisfila.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.developlus.sisfila.model.Usuario;
import com.developlus.sisfila.repository.UsuarioRepository;
import com.developlus.sisfila.util.cdi.CDIServiceLocator;

public class AppUserDetailsService  { 
	//implements UserDetailsService
	
	/**
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioRepository usuarioRepository = CDIServiceLocator.getBean(UsuarioRepository.class);

		Optional<Usuario> usuarioOptional = usuarioRepository.porEmailEAtivo(email);
		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário ou senha Inváldos"));

		return new User(usuario.getEmail(), usuario.getSenha(), getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		UsuarioRepository usuarioRepository = CDIServiceLocator.getBean(UsuarioRepository.class);

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		List<String> permissoes = usuarioRepository.permissoes(usuario);

		permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));

		return authorities;
	}
	**/
	
}
